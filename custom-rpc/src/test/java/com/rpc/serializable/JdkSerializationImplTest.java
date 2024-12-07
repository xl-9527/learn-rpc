package com.rpc.serializable;

import com.rpc.biz.bean.SerializableUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xl-9527
 * @since 2024/12/7
 **/
class JdkSerializationImplTest {

    private final Serialization<Object> serialization = new JdkSerializationImpl();

    @Test
    void serialization() throws Exception {
        final byte[] bytes = serialization.serialization(new SerializableUser("xl-9527"));
        assertNotNull(bytes);
    }

    @Test
    void deserialization() throws Exception {
        final byte[] bytes = serialization.serialization(new SerializableUser("xl-9527"));
        assertNotNull(bytes);
        final Object deserialization = serialization.deserialization(bytes, SerializableUser.class);
        assertNotNull(deserialization);
    }
}