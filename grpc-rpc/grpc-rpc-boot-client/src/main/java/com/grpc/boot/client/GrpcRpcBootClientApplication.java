package com.grpc.boot.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GrpcRpcBootClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrpcRpcBootClientApplication.class, args);
    }
}
