package com.rpc.dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class DubboRpcBootProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboRpcBootProviderApplication.class, args);
    }

}
