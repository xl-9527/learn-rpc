package com.custom_rpc;

import com.custom_rpc.protocol.MethodInvokeData;
import com.custom_rpc.service.HelloService;
import org.junit.jupiter.api.Test;

/**
 * @author xl-9527
 * @since 2024/12/23
 **/
class RpcClientProviderTest {

    private final RpcClientProvider rpcClientProvider = new RpcClientProvider();

    @Test
    void invoke() {
        rpcClientProvider.invoke(new MethodInvokeData(HelloService.class, "hello", new Object[]{"你好哇"}));
    }
}