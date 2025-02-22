package com.rpc.dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class DubboRpcLearningTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboRpcLearningTestApplication.class, args);
    }
}
