package com.zhang.protobuf.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class ProtoBufClient {

    public static void main(String[] args) throws Exception{
        new ProtoBufClient().run();
    }

    public void run() throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap boot = new Bootstrap();
            boot.group(group)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress("localhost", 8080))
                    .handler(new ClientInitializer());
            ChannelFuture f =boot.connect().sync();
            f.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully().sync();
        }
    }
}
