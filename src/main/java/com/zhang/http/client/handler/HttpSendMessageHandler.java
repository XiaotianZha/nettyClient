package com.zhang.http.client.handler;

import com.zhang.http.client.message.HttpRequestFuture;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

public class HttpSendMessageHandler extends ChannelInboundHandlerAdapter{

    private Channel channel;

    private final String uri;

    private HttpRequestFuture future;

    public HttpSendMessageHandler(String uri) {
        this.uri = uri;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        this.channel=ctx.channel();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        FullHttpResponse response=(FullHttpResponse)msg;
        future.setResopnse(response);
        future.done();
//        System.out.println(response.getStatus());
//        System.out.println(response.content().toString(CharsetUtil.UTF_8));
//        super.channelRead(ctx, msg);
    }

    public HttpRequestFuture sendMessage(String ms){
        ByteBuf buf = Unpooled.copiedBuffer(ms, CharsetUtil.UTF_8);
        FullHttpRequest request =
                new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST,uri,buf);
        request.headers().set(HttpHeaders.Names.CONTENT_LENGTH,request.content().readableBytes());
        channel.writeAndFlush(request);
        future = new HttpRequestFuture();
        return future;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
