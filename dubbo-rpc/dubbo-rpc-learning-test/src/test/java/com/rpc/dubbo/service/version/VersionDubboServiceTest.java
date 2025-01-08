package com.rpc.dubbo.service.version;

import com.rpc.dubbo.api.version.VersionDubboService;
import org.apache.dubbo.common.constants.LoadbalanceRules;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author xl-9527
 * @since 2025/1/7
 **/
@SpringBootTest
@ActiveProfiles("test")
class VersionDubboServiceTest {

    private static final Logger log = LoggerFactory.getLogger(VersionDubboServiceTest.class);

    @DubboReference(version = "1.0.0", group = "version", providedBy = "dubbo-rpc-learning-test")
    private VersionDubboService versionDubboService;

    @DubboReference(version = "2.0.0", group = "version")
    private VersionDubboService versionDubboService2;

    @RepeatedTest(99)
    void getVersion() {
        String version = versionDubboService.sayHello("xl-9527");
        log.info("version is {}", version);
    }

    @Test
    void getVersion2() {
        String version = versionDubboService2.sayHello("xl-9527");
        log.info("2 version is {}", version);
    }
}
