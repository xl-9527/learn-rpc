package com.rpc.dubbo.consumer.stub;

import com.rpc.dubbo.api.triple.GreeterService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author xl-9527
 * @since 2025/1/4
 **/
@Slf4j
@Service
@Profile("triple")
public class GreeterStub implements InitializingBean {

    @DubboReference(protocol = "tri")
    private GreeterService greeterService;

    public String greet(String request) {
        return greeterService.greet(request);
    }

    public void biGreet(StreamObserver<String> response) {
        final StreamObserver<String> stringStreamObserver = greeterService.biGreet(response);
        stringStreamObserver.onNext("client say：hello");
        stringStreamObserver.onCompleted();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("triple stub init -> {}", greet("hello"));
    }
}
