package com.rpc.dubbo.provider;

import org.junit.jupiter.api.Test;

/**
 * @author xl-9527
 * @since 2024/12/24
 **/
class ApplicationStartTest {

    private final ApplicationStart applicationStart = new ApplicationStart();

    @Test
    void start() throws InterruptedException {
        applicationStart.start();
    }
}