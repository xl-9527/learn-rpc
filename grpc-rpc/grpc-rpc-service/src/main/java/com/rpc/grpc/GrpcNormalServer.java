package com.rpc.grpc;

import com.rpc.grpc.service.BiServiceImpl;
import com.rpc.grpc.service.NewBiServiceImpl;
import com.rpc.grpc.service.UserInfoServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @author xl-9527
 * @since 2024/11/7
 **/
public class GrpcNormalServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        // 绑定端口 & service
        final ServerBuilder<?> builder = ServerBuilder.forPort(8888)
                .addService(new UserInfoServiceImpl())
                .addService(new BiServiceImpl())
                .addService(new NewBiServiceImpl());

        final Server server = builder.build();

        // 启动服务
        server.start();
        server.awaitTermination();
    }
}
