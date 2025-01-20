package com.rpc.dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xl-9527
 * @since 2025/1/20
 **/
@EnableDubbo
@SpringBootApplication
public class DubboRpcStandardMetricsBootProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboRpcStandardMetricsBootProviderApplication.class, args);
    }
}
