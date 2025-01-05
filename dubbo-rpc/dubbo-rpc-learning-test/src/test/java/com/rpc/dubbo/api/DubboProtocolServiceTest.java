package com.rpc.dubbo.api;

import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xl-9527
 * @since 2025/1/5
 **/
@SpringBootTest
class DubboProtocolServiceTest {

    @DubboReference(protocol = "dubbo")
    private DubboProtocolService dubboProtocolService;

    @Test
    void test() {
        System.out.println("dubboProtocolService.test(\"hello\") = " + dubboProtocolService.test("hello"));
    }
}