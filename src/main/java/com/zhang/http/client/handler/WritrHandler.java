package com.zhang.http.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.FullHttpRequest;

public class WritrHandler extends ChannelOutboundHandlerAdapter{

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        super.write(ctx, msg, promise);
        FullHttpRequest request=(FullHttpRequest)msg;
        System.out.println(request);
        System.out.println("client write");
    }
}
