package com.custom_rpc;

import com.custom_rpc.service.HelloService;
import com.custom_rpc.service.HelloServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * @author xl-9527
 * @since 2024/12/19
 **/
class RpcServerProviderTest {

    final RpcServerProvider rpcServerProvider = new RpcServerProvider(
            Map.of(HelloService.class.getName(), new HelloServiceImpl())
    );

    @Test
    void start() throws InterruptedException {
        rpcServerProvider.start();
    }
}