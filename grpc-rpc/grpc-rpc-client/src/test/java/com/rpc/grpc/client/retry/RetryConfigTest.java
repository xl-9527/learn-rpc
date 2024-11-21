package com.rpc.grpc.client.retry;


import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * @author xl-9527
 * @since 2024/11/21
 **/
class RetryConfigTest {

    @Test
    void getRetryConfig() {
        final Map<String, ?> map = RetryConfig.getRetryConfig();
    }
}