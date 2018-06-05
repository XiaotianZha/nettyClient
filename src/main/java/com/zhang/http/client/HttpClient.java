package com.zhang.http.client;

import com.zhang.http.client.handler.HttpChannelPoolHandler;
import com.zhang.http.client.handler.HttpSendMessageHandler;
import com.zhang.http.client.message.HttpRequestFuture;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.pool.FixedChannelPool;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.util.concurrent.CountDownLatch;

public class HttpClient {

    private int port;

    private String host;

    private EventLoopGroup group = new NioEventLoopGroup();

    private FixedChannelPool channelPool;

    public static HttpClient getClient(String host, int port) {
        return new HttpClient(port, host);
    }

    private HttpClient(int port, String host) {
        this.port = port;
        this.host = host;
        Bootstrap boot = new Bootstrap();
        boot.group(group)
                .channel(NioSocketChannel.class)
                .remoteAddress(new InetSocketAddress(host, port))
        .option(ChannelOption.TCP_NODELAY,true);
        channelPool = new FixedChannelPool(boot,new HttpChannelPoolHandler(),10);
    }

    public HttpRequestFuture send(String msg, String uri) throws Exception {
        System.out.println("send start");
        Channel channel = channelPool.acquire().get();
        System.out.println("get channel");
        ByteBuf buf = Unpooled.copiedBuffer(msg, CharsetUtil.UTF_8);
        FullHttpRequest request =
                new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST,uri,buf);
        request.headers().set(HttpHeaders.Names.CONTENT_LENGTH,request.content().readableBytes());
        channel.writeAndFlush(request);
        HttpRequestFuture future =channel.pipeline().get(HttpSendMessageHandler.class).getFuture();
        channelPool.release(channel);
        return future;

    }

    public void stop() throws Exception {
        group.shutdownGracefully();
    }

    public static void main(String[] args) throws Exception {
        final HttpClient client = getClient("localhost", 8080);
        final CountDownLatch start = new CountDownLatch(1);
        int threads=1;
        final CountDownLatch end = new CountDownLatch(threads);
        try {
            for(int i=0;i<threads;i++){
                final String requst="request message "+i;
                Thread t = new Thread(){
                    @Override
                    public void run() {
                        try {
                            start.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        try {
                            HttpRequestFuture future = client.send(requst, "localhost:8080/testClient");
                            FullHttpResponse f = future.get();
                            if (null != f){
                                String resoponse=f.content().toString(CharsetUtil.UTF_8);
                                end.countDown();
                                assert resoponse.equals(requst);
                            }
                        } catch (Exception e) {
                            System.out.println("future");
                            e.printStackTrace();
                        }
                    }
                };
                t.start();
            }
            start.countDown();
            end.await();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            client.stop();
        }

    }


}
