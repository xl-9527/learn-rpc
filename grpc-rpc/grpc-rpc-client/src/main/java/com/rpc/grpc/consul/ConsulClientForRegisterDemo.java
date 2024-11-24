package com.rpc.grpc.consul;

import com.orbitz.consul.Consul;
import com.orbitz.consul.model.agent.ImmutableRegistration;
import com.orbitz.consul.model.agent.Registration;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author xl-9527
 * @since 2024/11/23
 **/
@Slf4j
public class ConsulClientForRegisterDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
         registerServer();

        getAllHealInstance();
    }

    private static void getAllHealInstance() {
        final Consul consul = Consul.builder().build();
        consul.healthClient().getHealthyServiceInstances("bi-server").getResponse().forEach(v -> log.info("{}", v));
    }

    private static void registerServer() throws IOException, InterruptedException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress(9000));

        final Consul consul = Consul.builder().build();

        consul.agentClient()
                .register(
                        ImmutableRegistration.builder()
                                .id("server-" + UUID.randomUUID())
                                .name("bi-server")
                                .address("127.0.0.1")
                                .port(9000)
                                .tags(List.of("bi", "server"))
                                .meta(Map.of("version", "1.0.0"))
                                .check(Registration.RegCheck.tcp("127.0.0.1:9000", 10))
                                .build()
                );


        Thread.sleep(100000);
    }
}