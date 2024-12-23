package com.custom_rpc.transport;

import com.custom_rpc.protocol.MethodInvokeData;
import com.custom_rpc.service.HelloService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xl-9527
 * @since 2024/12/19
 **/
class NettyTransportImplTest {

    final Transport transport = new NettyTransportImpl();

    @Test
    void invoke() throws InterruptedException {
        final MethodInvokeData invokeData = new MethodInvokeData(
                HelloService.class.getName(),
                "hello",
                new Class[]{String.class},
                new Object[]{"xl-9527"}
        );
        transport.invoke("localhost:8888", invokeData);
    }
}