package com.rpc.dubbo.stub;

import com.alibaba.fastjson2.JSON;
import com.rpc.dubbo.entity.Hello;
import com.rpc.dubbo.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * @author xl-9527
 * @since 2024/12/29
 **/
@Slf4j
@Service
public class HelloServiceStub implements InitializingBean {


    @DubboReference(url = "dubbo://172.29.32.1:20880/com.rpc.dubbo.service.HelloService?serializable=fastjson2")
    private HelloService helloService;

    @Override
    public void afterPropertiesSet() throws Exception {
        Boolean hello = helloService.hello(new Hello("hello", "xl-9527"));
        log.info("hello 接口调用 -> {}", JSON.toJSONString(hello));
    }
}
