package com.rpc.dubbo.service;

import com.rpc.dubbo.entity.Hello;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author xl-9527
 * @since 2024/12/27
 **/
@Service
@DubboService
public class HelloServiceImpl implements HelloService {

    private final Logger log = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public Boolean hello(final Hello hello) {
        log.info("hello 接口调用 value -> {}, username -> {}", hello.getValue(), hello.getUsername());
        return Boolean.TRUE;
    }
}
