package com.rpc.serializable;

import com.rpc.custom_rpc.thrift.SerializableUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xl-9527
 * @since 2024/12/7
 **/
class ThriftSerializationImplTest {

    private final ThriftSerializationImpl thriftSerialization = new ThriftSerializationImpl();

    @Test
    void serialization() throws Exception {
        final byte[] bytes = thriftSerialization.serialization(new SerializableUser("xl-9527"));
        assertNotNull(bytes);
    }

    @Test
    void deserialization() throws Exception {
        final byte[] bytes = thriftSerialization.serialization(new SerializableUser("xl-9527"));
        final SerializableUser deserialization = thriftSerialization.deserialization(bytes, SerializableUser.class);
        assertNotNull(deserialization);
        assertEquals("xl-9527", deserialization.getUsername());
    }
}