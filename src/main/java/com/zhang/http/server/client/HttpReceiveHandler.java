package com.zhang.http.server.client;

import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

@ChannelHandler.Sharable
public class HttpReceiveHandler extends SimpleChannelInboundHandler<FullHttpRequest>{

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        System.out.println("Server Active");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
        String s=msg.content().toString(CharsetUtil.UTF_8);
        System.out.println(msg.getUri());
        HttpResponse response = new DefaultHttpResponse(msg.getProtocolVersion(), HttpResponseStatus.OK);
        response.headers().set(HttpHeaders.Names.CONTENT_TYPE,"text/html; charset=UTF-8");
        ctx.write(response);
        ctx.write(Unpooled.copiedBuffer(s, CharsetUtil.UTF_8));
        ChannelFuture future = ctx.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);
        future.addListener(ChannelFutureListener.CLOSE);

    }

}
