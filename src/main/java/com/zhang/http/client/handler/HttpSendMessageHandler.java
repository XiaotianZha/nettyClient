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
        this.channel=ctx.channel();
        System.out.println(channel);
        super.channelActive(ctx);

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        FullHttpResponse response=(FullHttpResponse)msg;
        future.setResponse(response);
        future.done();
    }

    public HttpRequestFuture sendMessage(String ms){
        ByteBuf buf = Unpooled.copiedBuffer(ms, CharsetUtil.UTF_8);
        FullHttpRequest request =
                new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST,uri,buf);
        request.headers().set(HttpHeaders.Names.CONTENT_LENGTH,request.content().readableBytes());
        future = new HttpRequestFuture();
        channel.writeAndFlush(request);
        return future;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
