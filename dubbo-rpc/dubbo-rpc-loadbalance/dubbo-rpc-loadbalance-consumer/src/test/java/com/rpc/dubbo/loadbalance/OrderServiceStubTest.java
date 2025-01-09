package com.rpc.dubbo.loadbalance;

import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author xl-9527
 * @since 2025/1/9
 **/
@SpringBootTest
class OrderServiceStubTest {

    @Autowired
    private OrderServiceStub orderServiceStub;

    @RepeatedTest(10)
    void getOrderNumber() {
        orderServiceStub.getOrderNumber(1L);
    }
}
