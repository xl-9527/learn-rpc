package com.rpc.grpc;

import com.rpc.grpc.service.BiServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @author xl-9527
 * @since 2024/11/23
 **/
public class GrpcRetryServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        final Server server = ServerBuilder.forPort(8888)
                .addService(new BiServiceImpl())
                .build();

        server.start();
        server.awaitTermination();
    }
}
