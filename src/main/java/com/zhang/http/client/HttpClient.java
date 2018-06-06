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
        channelPool = new FixedChannelPool(boot,new HttpChannelPoolHandler(),3);
    }

    public String send(String msg, String uri) throws Exception {
        Channel channel = channelPool.acquire().get();
        ChannelPipeline pipeline=channel.pipeline();
        HttpSendMessageHandler handler = (HttpSendMessageHandler)pipeline.get("sender");
        ByteBuf buf = Unpooled.copiedBuffer(msg, CharsetUtil.UTF_8);
        FullHttpRequest request =
                new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST,uri,buf);
        request.headers().set(HttpHeaders.Names.CONTENT_LENGTH,request.content().readableBytes());
        channel.writeAndFlush(request);

        HttpRequestFuture future  =handler.getFuture();
        String response= future.get();
        channelPool.release(channel);
        return response;

    }

    public void stop() throws Exception {
//        channelPool.close();
        group.shutdownGracefully();
    }

    public static void main(String[] args) throws Exception {
        final HttpClient client = getClient("localhost", 8080);
        final CountDownLatch start = new CountDownLatch(1);
        int threads=70;
        final CountDownLatch end = new CountDownLatch(threads);
        try {
            for(int i=0;i<threads;i++){
                final String requst="request message "+i;
                Thread t = new Thread(){
                    @Override
                    public void run() {
                        try {
                            start.await();
                            String response = client.send(requst, "localhost:8080/testClient");
                            if (null != response){
                                assert response.equals(requst);
                            }
                        } catch (Exception e) {
                            System.out.println("future");
                            e.printStackTrace();
                        }finally {
                            end.countDown();
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
