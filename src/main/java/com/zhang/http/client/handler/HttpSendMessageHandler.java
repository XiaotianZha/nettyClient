package com.zhang.http.client.handler;

import com.zhang.http.client.message.HttpRequestFuture;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

public class HttpSendMessageHandler extends ChannelInboundHandlerAdapter{

    private HttpRequestFuture future = new HttpRequestFuture();


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);


    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        FullHttpResponse response=(FullHttpResponse)msg;
        future.setResponse(response);
        future.done();
    }




    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    public HttpRequestFuture getFuture() {
        return future;
    }

}
