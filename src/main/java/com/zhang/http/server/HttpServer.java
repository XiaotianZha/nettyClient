package com.zhang.http.server;

import com.zhang.http.server.client.HttpReceiveHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

public class HttpServer {

    public static void main(String[] args) throws Exception{

        new HttpServer().run();
    }

        public void run() throws Exception{

            final HttpReceiveHandler handler = new HttpReceiveHandler();
            EventLoopGroup group = new NioEventLoopGroup();
            try {
                ServerBootstrap bootstrap = new ServerBootstrap();
                bootstrap.group(group)
                        .channel(NioServerSocketChannel.class)
                        .localAddress(8080)
                        .childHandler(new ChannelInitializer<SocketChannel>() {
                            protected void initChannel(SocketChannel ch) throws Exception {
                                ch.pipeline().addLast(new HttpServerCodec());
                                ch.pipeline().addLast(new HttpObjectAggregator(64*1024));
                                ch.pipeline().addLast(handler);

                            }
                        });
                ChannelFuture f= bootstrap.bind().sync();
                f.channel().closeFuture().sync();
            }finally {
                group.shutdownGracefully().sync();
            }
        }
}
