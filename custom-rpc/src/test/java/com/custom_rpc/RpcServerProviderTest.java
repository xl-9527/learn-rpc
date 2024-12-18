package com.custom_rpc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xl-9527
 * @since 2024/12/19
 **/
class RpcServerProviderTest {

    final RpcServerProvider rpcServerProvider = new RpcServerProvider();

    @Test
    void start() throws InterruptedException {
        rpcServerProvider.start();
    }
}