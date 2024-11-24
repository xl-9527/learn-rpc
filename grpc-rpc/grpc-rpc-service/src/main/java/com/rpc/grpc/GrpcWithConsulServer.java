package com.rpc.grpc;

import com.orbitz.consul.AgentClient;
import com.orbitz.consul.Consul;
import com.orbitz.consul.model.agent.ImmutableRegistration;
import com.orbitz.consul.model.agent.Registration;
import com.rpc.grpc.service.BiServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;
import java.util.random.RandomGenerator;

/**
 * @author xl-9527
 * @since 2024/11/24
 **/
public class GrpcWithConsulServer {

    public static void main(String[] args) throws InterruptedException, IOException {
        final int port = Random.from(RandomGenerator.getDefault()).nextInt(65535);
        final Server server = ServerBuilder.forPort(port)
                .addService(new BiServiceImpl())
                .build();

        server.start();
        toRegister(port);
        server.awaitTermination();
    }

    private static void toRegister(final int port) {
        final Consul consul = Consul.builder().build();

        // get client instance
        final AgentClient agentClient = consul.agentClient();

        agentClient.register(
                ImmutableRegistration.builder()
                        .id("server-" + UUID.randomUUID())
                        .name("bi-server")
                        .port(port)
                        .address("127.0.0.1")
                        .check(Registration.RegCheck.tcp("127.0.0.1:" + port, 10))
                        .build()
        );
    }
}
