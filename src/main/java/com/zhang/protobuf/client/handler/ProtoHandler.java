package com.zhang.protobuf.client.handler;

import com.zhang.protobuf.model.HeartBeatProto.HeartBeat;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.atomic.AtomicInteger;

public class ProtoHandler extends ChannelInboundHandlerAdapter{

    private AtomicInteger id = new AtomicInteger();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        super.channelActive(ctx);
        System.out.println("TCP active");
        HeartBeat.Builder heart = HeartBeat.newBuilder();
        heart.setId("clientId"+id.incrementAndGet());
        heart.setMsg("hello");
        heart.setRemark("Client");
        ctx.writeAndFlush(heart.build());

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        HeartBeat heart= (HeartBeat)msg;
        System.out.println(heart.getId());
        System.out.println(heart.getRemark());
        if (id.get()<=10){
            HeartBeat.Builder res = HeartBeat.newBuilder();
            res.setId("clientId"+id.incrementAndGet());
            res.setMsg("hello");
            res.setRemark("Client");

            ctx.writeAndFlush(res.build());

        }
    }
}
