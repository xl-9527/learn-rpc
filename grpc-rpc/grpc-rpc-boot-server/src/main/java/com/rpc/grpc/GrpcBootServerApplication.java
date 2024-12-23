package com.rpc.grpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xl-9527
 * @since 2024/11/12
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class GrpcBootServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(GrpcBootServerApplication.class, args);
    }
}