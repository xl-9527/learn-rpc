package com.rpc.dubbo.service.group;

import com.rpc.dubbo.api.group.GroupDubboService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xl-9527
 * @since 2025/1/7
 **/
@SpringBootTest
@ActiveProfiles("test")
class GroupDubboServiceJsonImplTest {

    private static final Logger log = LoggerFactory.getLogger(GroupDubboServiceJsonImplTest.class);

    @DubboReference(group = "json")
    private GroupDubboService groupDubboService;
    @DubboReference(group = "binary")
    private GroupDubboService groupDubboServiceBinary;

    @Test
    void sayHello() {
        final String hello = groupDubboService.sayHello("xl-9527");
        log.info("hello 接口调用 -> {}", hello);
    }

    @Test
    void sayHelloWithException() {
        Assertions.assertThrows(Exception.class, () ->
                groupDubboServiceBinary.sayHello("xl-9527")
        );
    }
}