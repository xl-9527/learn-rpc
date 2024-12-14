package com.rpc.custom_rpc.registery;

import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author xl-9527
 * @since 2024/12/14
 **/
class ServerRegistryImplTest {

    final ServerRegistryImpl serverRegistry = new ServerRegistryImpl("127.0.0.1", 2181);

    @Test
    void registry() throws IOException {
        serverRegistry.registry("orderServer");
        System.out.println(System.in.read());
    }
}