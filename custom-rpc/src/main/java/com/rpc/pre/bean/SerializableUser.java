package com.rpc.pre.bean;

import com.google.protobuf.InvalidProtocolBufferException;
import com.rpc.pre.custom_grpc.SerializableProto;
import com.rpc.pre.serializable.AbsGrpcSerialization;
import lombok.*;

import java.io.Serializable;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author xl-9527
 * @since 2024/12/5
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SerializableUser extends AbsGrpcSerialization<SerializableUser> implements Serializable {

    private String username;

    @Override
    public Function<SerializableUser, byte[]> transferToByteArray() {
        return serializableUser -> SerializableProto.SerializableUser.newBuilder()
                .setUsername(serializableUser.getUsername())
                .build()
                .toByteArray();
    }

    @Override
    public BiFunction<byte[], Class<SerializableUser>, SerializableUser> transferToObj() {
        return ((bytes, serializableUserClass) -> {
            try {
                SerializableProto.SerializableUser serializableUser = SerializableProto.SerializableUser.parseFrom(bytes);
                return new SerializableUser(serializableUser.getUsername());
            } catch (InvalidProtocolBufferException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
