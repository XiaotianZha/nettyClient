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
import io.netty.util.ReferenceCountUtil;

import java.net.InetSocketAddress;
import java.util.concurrent.*;

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
        return requestFuture;

    }

    public void stop() throws Exception {
        group.shutdownGracefully();
    }

    public static void main(String[] args) throws Exception {
//        final ExecutorService exec = Executors.newFixedThreadPool(10);
        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(16, 16,
                6L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(65536));
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
                            HttpRequestFuture future = client.send(requst, "localhost:8080/testClient");
                            future.addListener(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        System.out.println("run");
                                        FullHttpResponse f = future.get();
                                        if (null != f){
                                            String response=f.content().toString(CharsetUtil.UTF_8);
                                            ReferenceCountUtil.release(f);
                                            assert response.equals(requst);
                                        }
                                    }finally {
                                        System.out.println("end count");
                                        end.countDown();
                                    }

                                }
                            },threadPoolExecutor);

                        } catch (Exception e) {
                            System.out.println("future");
                            e.printStackTrace();
                        }
                    }
                };
                t.start();
            }
            start.countDown();
            System.out.println("start");
            end.await();
            System.out.println("end");
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("close client");
            threadPoolExecutor.shutdown();
            client.stop();
        }

    }


}
