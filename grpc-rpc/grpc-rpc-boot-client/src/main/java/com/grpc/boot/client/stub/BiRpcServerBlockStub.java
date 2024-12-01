package com.grpc.boot.client.stub;

import com.rpc.grpc.bi.BiRpcServiceGrpc;
import com.rpc.grpc.bi.BiService;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xl-9527
 * @since 2024/11/14
 **/
@RestController
@RequestMapping("stub/bi/server")
public class BiRpcServerBlockStub {

    @GrpcClient("grpc_server")
    private BiRpcServiceGrpc.BiRpcServiceBlockingStub biRpcServiceBlockingStub;

    @GetMapping
    public Object getUserInfo(String msg) {
        final BiService.OnceMessageResponse onceMessage = biRpcServiceBlockingStub.getOnceMessage(
                BiService.OnceMessageRequest.newBuilder()
                        .setContent(msg).build()
        );

        return onceMessage.getContent();
    }
}
