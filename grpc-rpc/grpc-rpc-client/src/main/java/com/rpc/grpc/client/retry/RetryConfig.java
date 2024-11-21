package com.rpc.grpc.client.retry;

import com.google.common.io.Files;

import java.io.File;
import java.util.Map;

/**
 * @author xl-9527
 * @since 2024/11/21
 **/
public class RetryConfig {

    /**
     * GET retry config
     */
    public static Map<String, ?> getRetryConfig() {
        Files.asByteSource(new File(getClassPath() + "/src/resources/retry_server_config.json"));
        return Map.of();
    }

    private static String getClassPath() {
        return System.getProperty("user.dir");
    }
}
