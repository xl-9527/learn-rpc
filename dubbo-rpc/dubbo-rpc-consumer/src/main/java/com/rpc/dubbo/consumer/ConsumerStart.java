package com.rpc.dubbo.consumer;

import com.rpc.dubbo.entity.Hello;
import com.rpc.dubbo.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xl-9527
 * @since 2024/12/25
 **/
@Slf4j
public class ConsumerStart {

    public void start() {
        final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
        ctx.start();
        Boolean hello = ctx.getBean("helloService", HelloService.class).hello(new Hello("你好", "dubbo-consumer"));
        log.info("调用结果 -> {}", hello);
    }
}
