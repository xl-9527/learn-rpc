package com.rpc.dubbo.service;

import com.rpc.dubbo.api.TripleProtocolService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author xl-9527
 * @since 2025/1/7
 **/
@SpringBootTest
@ActiveProfiles("test")
class TripleProtocolServiceImplTest {

    @DubboReference(protocol = "tri")
    private TripleProtocolService tripleProtocolService;

    @RepeatedTest(50)
    void testTriple() {
        tripleProtocolService.testTriple();
    }
}
