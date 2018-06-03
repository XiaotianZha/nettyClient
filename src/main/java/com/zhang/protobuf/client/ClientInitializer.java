package com.zhang.protobuf.client;

import com.zhang.protobuf.ProtoInitializer;
import com.zhang.protobuf.client.handler.ProtoHandler;
import io.netty.channel.ChannelHandler;

public class ClientInitializer extends ProtoInitializer{
    public ChannelHandler addCustomHandler() {

        return new ProtoHandler();

    }
}
