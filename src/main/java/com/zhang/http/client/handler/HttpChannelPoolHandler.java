package com.zhang.http.client.handler;

import io.netty.channel.Channel;
import io.netty.channel.pool.ChannelPoolHandler;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;

public class HttpChannelPoolHandler implements ChannelPoolHandler{

    @Override
    public void channelReleased(Channel ch) throws Exception {
        System.out.println("channel release");
    }

    @Override
    public void channelAcquired(Channel ch) throws Exception {
        System.out.println("channel acquire: "+ch);
    }

    @Override
    public void channelCreated(Channel ch) throws Exception {

        System.out.println("channel create");

        NioSocketChannel channel = (NioSocketChannel) ch;

        channel.pipeline().addLast(new HttpClientCodec());
        channel.pipeline().addLast(new HttpObjectAggregator(64*1024));
        channel.pipeline().addLast("sender",new HttpSendMessageHandler());

    }
}
