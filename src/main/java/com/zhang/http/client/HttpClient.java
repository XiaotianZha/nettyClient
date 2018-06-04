package com.zhang.http.client;

import com.zhang.http.client.handler.HttpSendMessageHandler;
import com.zhang.http.client.message.HttpRequestFuture;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
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

    public static HttpClient getClient(String host, int port) {
        return new HttpClient(port, host);
    }

    private HttpClient(int port, String host) {
        this.port = port;
        this.host = host;
    }

    public HttpRequestFuture send(String msg, String uri) throws Exception {

        final HttpSendMessageHandler handler = new HttpSendMessageHandler(uri);
        Bootstrap boot = new Bootstrap();
        boot.group(group)
                .channel(NioSocketChannel.class)
                .remoteAddress(new InetSocketAddress(host, port))
                .handler(new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new HttpClientCodec());
                        pipeline.addLast(new HttpObjectAggregator(64 * 1024));
                        pipeline.addLast(handler);

                    }
                });
        ChannelFuture f = boot.connect().sync();
        HttpRequestFuture requestFuture = handler.sendMessage(msg);
   /*     f.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture future) throws Exception {
                //params future in this method is the same with f
                System.out.println("complete " + future);
                System.out.println(future.channel());
            }
        });*/
        return requestFuture;
           /* System.out.println("main"+future.channel());
            ChannelFuture closse=future.channel().closeFuture();
            System.out.println(closse);
            //will be blocked until channel closed
            closse.sync();*/

    }

    public void stop() throws Exception {
        group.shutdownGracefully();
    }

    public static void main(String[] args) throws Exception {
        final HttpClient client = getClient("localhost", 8080);
        final CountDownLatch start = new CountDownLatch(1);
        int threads=50;
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
