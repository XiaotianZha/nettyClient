package com.zhang.http.client.handler;

import io.netty.channel.Channel;
import io.netty.channel.pool.ChannelPoolHandler;
import io.netty.channel.socket.nio.NioSocketChannel;

public class HttpChannelPoolHandler implements ChannelPoolHandler{

    @Override
    public void channelReleased(Channel ch) throws Exception {

    }

    @Override
    public void channelAcquired(Channel ch) throws Exception {
        System.out.println("channel acquire: "+ch);
    }

    @Override
    public void channelCreated(Channel ch) throws Exception {

        NioSocketChannel channel = (NioSocketChannel) ch;
        channel.pipeline().addLast(new HttpSendMessageHandler());
    }
}
