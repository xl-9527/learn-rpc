package com.rpc.serializable;

import com.rpc.biz.bean.SerializableUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xl-9527
 * @since 2024/12/8
 **/
@Slf4j
class AbsGrpcSerializationTest {

    private final SerializableUser serializableUser = new SerializableUser("xl-9527");

    @Test
    void serialization() throws Exception {
        final byte[] bytes = serializableUser.serialization(serializableUser);
        assertNotNull(bytes);
    }

    @Test
    void deserialization() throws Exception {
        final byte[] bytes = serializableUser.serialization(serializableUser);
        log.info("bytes length: {}", bytes.length);
        final SerializableUser deserialization = serializableUser.deserialization(bytes, SerializableUser.class);
        assertNotNull(deserialization);
        assertEquals(serializableUser.getUsername(), deserialization.getUsername());
    }
}