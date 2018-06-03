package com.zhang.http.client;

import com.zhang.http.client.handler.HttpSendMessageHandler;
import com.zhang.http.client.handler.WritrHandler;
import com.zhang.http.client.message.HttpRequestFuture;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
        System.out.println("bind" + f);
        HttpRequestFuture requestFuture = handler.sendMessage(msg);
        f.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture future) throws Exception {
                //params future in this method is the same with f
                System.out.println("complete " + future);
                System.out.println(future.channel());
//                    System.out.println(future == f);
            }
        });
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
        HttpClient client = getClient("localhost", 8080);
        HttpRequestFuture future = client.send("request message", "localhost:8080/testClient");
        FullHttpResponse f = future.get();
        System.out.println(f.content().toString(CharsetUtil.UTF_8));
        client.stop();

    }


}
