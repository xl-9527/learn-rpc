package com.rpc.dubbo.consumer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xl-9527
 * @since 2024/12/25
 **/
class ConsumerStartTest {

    @Test
    void start() {
        new ConsumerStart("application-context.xml").start();
    }

    @Test
    void startSerializationWithKryo() {
        new ConsumerStart("application-kryo-context.xml").start();
    }
}
