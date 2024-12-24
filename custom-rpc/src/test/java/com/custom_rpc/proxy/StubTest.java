package com.custom_rpc.proxy;

import com.custom_rpc.service.HelloService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xl-9527
 * @since 2024/12/24
 **/
class StubTest {

    @Test
    void create() {
        new Stub().create(HelloService.class).hello("你好");
    }
}
