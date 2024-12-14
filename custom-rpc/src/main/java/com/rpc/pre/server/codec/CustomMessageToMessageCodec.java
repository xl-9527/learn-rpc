package com.rpc.pre.server.codec;

import com.rpc.pre.bean.SerializableUser;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author xl-9527
 * @since 2024/12/8
 **/
@Slf4j
public class CustomMessageToMessageCodec extends MessageToMessageCodec<ByteBuf, SerializableUser> {

    @Override
    protected void encode(final ChannelHandlerContext channelHandlerContext, final SerializableUser serializableUser, final List<Object> list) throws Exception {
        log.info("开始序列化");
        final ByteBuf buffer = channelHandlerContext.alloc().buffer();
        // 序列化
        final byte[] bytes = serializableUser.serialization(serializableUser);
        // 因为使用封帧操作所以需要写入头，这里表示数据的长度
        buffer.writeInt(bytes.length);
        buffer.writeBytes(bytes);
        list.add(buffer);
        log.info("序列化完成");
    }

    @Override 
    protected void decode(final ChannelHandlerContext channelHandlerContext, final ByteBuf byteBuf, final List<Object> list) throws Exception {
        log.info("开始反序列化");
        final int lengthField = byteBuf.readInt();
        byte[] bytes = new byte[lengthField];
        byteBuf.readBytes(bytes);
        list.add(new SerializableUser().deserialization(bytes, SerializableUser.class));
        log.info("反序列化完成");
    }
}
