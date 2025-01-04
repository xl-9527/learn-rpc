package com.rpc.dubbo.provider.rest.order.service.impl;

import com.rpc.dubbo.api.triple.GreeterService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.context.annotation.Profile;

/**
 * @author xl-9527
 * @since 2025/1/4
 **/
@Slf4j
@DubboService
@Profile("triple")
public class GreeterServiceImpl implements GreeterService {

    @Override
    public String greet(final String request) {
        log.info("receive request: {}", request);
        return "server say：" + request;
    }

    @Override
    public StreamObserver<String> biGreet(final StreamObserver<String> response) {
        response.onNext("server say：hello");
        return new StreamObserver<>() {
            @Override
            public void onNext(final String data) {
                log.info("receive request data: {}", data);
            }

            @Override
            public void onError(final Throwable throwable) {
                log.error("", throwable);
                response.onCompleted();
            }

            @Override
            public void onCompleted() {
                log.info("receive request completed");
                response.onCompleted();
            }
        };
    }
}
