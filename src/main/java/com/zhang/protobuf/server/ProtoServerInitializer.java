package com.zhang.protobuf.server;

import com.zhang.protobuf.ProtoInitializer;
import com.zhang.protobuf.server.handler.ServerProtoHandler;
import io.netty.channel.ChannelHandler;

public class ProtoServerInitializer extends ProtoInitializer{
    public ChannelHandler addCustomHandler() {
        return new ServerProtoHandler();
    }
}
