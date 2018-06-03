package com.zhang.protobuf.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class ProtoBufServer {

    public static void main(String[] args) throws Exception{

        new ProtoBufServer().run();
    }

    public void run() throws Exception{

        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(8080)
                    .childHandler(new ProtoServerInitializer());
            ChannelFuture f= bootstrap.bind().sync();
            f.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully().sync();
        }
    }
}
