package com.rpc.serializable;

import com.rpc.biz.bean.SerializableUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xl-9527
 * @since 2024/12/7
 **/
class HessianSerializationImplTest {

    private final Serialization<Object> serialization = new HessianSerializationImpl();

    @Test
    void serialization() throws Exception {
        final SerializableUser serializableUser = new SerializableUser("xl-9527");
        assertNotNull(serialization.serialization(serializableUser));
    }

    @Test
    void deserialization() throws Exception {
        final byte[] bytes = serialization.serialization(new SerializableUser("xl-9527"));
        assertNotNull(bytes);
        final SerializableUser deserialization = serialization.deserialization(bytes, SerializableUser.class);
        assertInstanceOf(SerializableUser.class, deserialization);
        assertEquals("xl-9527", deserialization.getUsername());
    }
}