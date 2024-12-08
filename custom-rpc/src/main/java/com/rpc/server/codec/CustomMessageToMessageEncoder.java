package com.rpc.server.codec;

import com.rpc.biz.bean.SerializableUser;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * @author xl-9527
 * @since 2024/12/8
 **/
public class CustomMessageToMessageEncoder extends MessageToMessageEncoder<SerializableUser> {

    @Override
    protected void encode(final ChannelHandlerContext channelHandlerContext, final SerializableUser serializableUser, final List<Object> list) throws Exception {

    }
}
