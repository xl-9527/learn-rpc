package serializable;

import com.google.protobuf.InvalidProtocolBufferException;
import com.rpc.custom_grpc.SerializableProto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author xl-9527
 * @since 2024/12/7
 **/
@Slf4j
public class GrpcProtoSerializableTest {

    @Test
    public void doTestGrpcProtoSerializable() throws InvalidProtocolBufferException {
        final SerializableProto.SerializableUser serializableUser = SerializableProto.SerializableUser.newBuilder()
                .setUsername("xl-9527")
                .build();

        log.info("grpc use proto serializableUser size: {}", serializableUser.toByteArray().length);

        final SerializableProto.SerializableUser newSerializable = SerializableProto.SerializableUser.parseFrom(serializableUser.toByteArray());
        log.info("grpc use proto newSerializableUser: {}", newSerializable.getUsername());
    }
}
