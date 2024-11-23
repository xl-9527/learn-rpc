package com.rpc.grpc.client.retry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.ByteSource;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author xl-9527
 * @since 2024/11/21
 **/
public class RetryConfig {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * GET retry config
     */
    public static Map<String, ?> getRetryConfig() {
        final ByteSource byteSource = Files.asByteSource(new File(getClassPath() + "/retry_server_config.json"));
        try (final InputStream inputStream = byteSource.openStream()) {
            return OBJECT_MAPPER.readValue(inputStream, new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getClassPath() {
        final URL resource = RetryConfig.class.getResource("/");
        return resource.getPath();
    }
}
