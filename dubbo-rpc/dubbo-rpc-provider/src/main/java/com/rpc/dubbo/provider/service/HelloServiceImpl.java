package com.rpc.dubbo.provider.service;

import com.rpc.dubbo.entity.Hello;
import com.rpc.dubbo.service.HelloService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xl-9527
 * @since 2024/12/24
 **/
@Slf4j
public class HelloServiceImpl implements HelloService {

    @Override
    public boolean hello(final Hello hello) {
        log.info("hello 接口调用 -> {}", hello);
        return false;
    }
}
