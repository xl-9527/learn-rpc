package com.rpc.dubbo.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xl-9527
 * @since 2025/1/1
 **/
@EnableDubbo
@SpringBootApplication
public class DubboRpcStandardBootConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboRpcStandardBootConsumerApplication.class, args);
    }
}