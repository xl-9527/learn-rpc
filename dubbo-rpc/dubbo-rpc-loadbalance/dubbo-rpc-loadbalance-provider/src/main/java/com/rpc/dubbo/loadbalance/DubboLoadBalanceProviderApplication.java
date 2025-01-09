package com.rpc.dubbo.loadbalance;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xl-9527
 * @since 2025/1/9
 **/
@EnableDubbo
@SpringBootApplication
public class DubboLoadBalanceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboLoadBalanceProviderApplication.class, args);
    }
}
