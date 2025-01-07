package com.rpc.dubbo.api;

import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xl-9527
 * @since 2025/1/5
 **/
@SpringBootTest
@ActiveProfiles("test")
class DubboProtocolServiceTest {

    private static final Logger log = LoggerFactory.getLogger(DubboProtocolServiceTest.class);
    @DubboReference(protocol = "dubbo")
    private DubboProtocolService dubboProtocolService;

    @RepeatedTest(5)
    void test() {
        log.info("dubboProtocolService.test(\"hello\") = {}", dubboProtocolService.test("hello"));
    }
}
