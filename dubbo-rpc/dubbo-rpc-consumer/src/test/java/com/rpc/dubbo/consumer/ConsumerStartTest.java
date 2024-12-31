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

    /**
     * 使用应该增加 vm 参数 (-ea --add-opens java.base/java.util=ALL-UNNAMED --add-opens java.base/java.text=ALL-UNNAMED)
     */
    @Test
    void startSerializationWithKryo() {
        new ConsumerStart("application-kryo-context.xml").start();
    }

    /**
     * 使用应该增加 vm 参数 (-ea --add-opens java.base/java.util=ALL-UNNAMED --add-opens java.base/java.text=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.math=ALL-UNNAMED --add-opens java.base/java.util.concurrent=ALL-UNNAMED --add-opens java.base/java.net=ALL-UNNAMED)
     */
    @Test
    void startSerializationWithFst() {
        new ConsumerStart("application-fst-context.xml").start();
    }
}
