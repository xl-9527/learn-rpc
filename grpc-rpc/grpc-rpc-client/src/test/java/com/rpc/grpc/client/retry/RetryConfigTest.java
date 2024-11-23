package com.rpc.grpc.client.retry;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * @author xl-9527
 * @since 2024/11/21
 **/
@Slf4j
class RetryConfigTest {

    @Test
    void getRetryConfig() {
        final Map<String, ?> map = RetryConfig.getRetryConfig();
        log.info("map: {}", map);
    }
}