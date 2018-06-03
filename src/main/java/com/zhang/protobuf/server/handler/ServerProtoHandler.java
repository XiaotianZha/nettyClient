package com.zhang.protobuf.server.handler;

import com.zhang.protobuf.model.HeartBeatProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerProtoHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        System.out.println("active");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        HeartBeatProto.HeartBeat heart = (HeartBeatProto.HeartBeat) msg;
        System.out.println(heart.getId());
        System.out.println(heart.getRemark());
        HeartBeatProto.HeartBeat.Builder res = HeartBeatProto.HeartBeat.newBuilder();
        res.setId("serverId" + heart.getId());
        res.setMsg("hello");
        res.setRemark("Client");
        ctx.writeAndFlush(res.build());

    }
}
