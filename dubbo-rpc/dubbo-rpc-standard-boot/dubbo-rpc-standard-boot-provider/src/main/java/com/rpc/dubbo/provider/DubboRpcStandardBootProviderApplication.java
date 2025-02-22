package com.rpc.dubbo.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class DubboRpcStandardBootProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboRpcStandardBootProviderApplication.class, args);
    }
}
