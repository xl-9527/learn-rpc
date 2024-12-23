package com.custom_rpc.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xl-9527
 * @since 2024/12/23
 **/
@Slf4j
public class HelloService {

    public String hello(String params) {
        log.info("hello 接口调用 -> {}", params);
        return "hello：" + params;
    }
}
