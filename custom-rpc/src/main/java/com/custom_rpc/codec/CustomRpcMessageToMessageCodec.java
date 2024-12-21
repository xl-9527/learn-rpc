package com.custom_rpc.codec;

import com.custom_rpc.protocol.Protocol;
import com.custom_rpc.serializable.HessianSerializationImpl;
import com.custom_rpc.serializable.Serialization;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

/**
 * @author xl-9527
 * @since 2024/12/16
 **/
public class CustomRpcMessageToMessageCodec extends MessageToMessageCodec<ByteBuf, Protocol> {

    private final Serialization serialization = new HessianSerializationImpl();

    @Override
    protected void encode(final ChannelHandlerContext channelHandlerContext, final Protocol protocol, final List<Object> list) throws Exception {
        // 序列化
        final byte[] bytes = serialization.serialization(protocol);
        final ByteBuf buffer = channelHandlerContext.alloc().buffer();
        // 幻术 10b
        buffer.writeBytes(Protocol.MAGIC_NUMBER.getBytes(StandardCharsets.UTF_8));
        // 协议版本 1b
        buffer.writeByte(Protocol.PROTOCOL_VERSION);
        // 数据长度 4b
        buffer.writeInt(bytes.length);
        // 数据内容
        final ByteBuf byteBuf = buffer.writeBytes(bytes);
        list.add(byteBuf);
    }

    @Override
    protected void decode(final ChannelHandlerContext channelHandlerContext, final ByteBuf byteBuf, final List<Object> list) throws Exception {
        // 幻术
        final CharSequence magicNumber = byteBuf.readCharSequence(10, StandardCharsets.UTF_8);
        if (!Objects.equals(magicNumber, Protocol.MAGIC_NUMBER)) {
            throw new RuntimeException("协议错误 - magic");
        }
        // 版本信息
        final byte protocolVersion = byteBuf.readByte();
        if (protocolVersion != Protocol.PROTOCOL_VERSION) {
            throw new RuntimeException("协议错误 - version");
        }
        // 数据长度
        final int length = byteBuf.readInt();
        // 数据
        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);
        final Protocol deserialization = serialization.deserialization(bytes);
        list.add(deserialization);
    }
}
