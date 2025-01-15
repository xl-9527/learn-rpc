package com.rpc.dubbo.source;

import com.rpc.dubbo.source.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author xl-9527
 * @since 2025/1/15
 **/
public class DubboRpcSourceApplication {
    private static final Logger log = LoggerFactory.getLogger(DubboRpcSourceApplication.class);

    public static void main(String[] args) throws IOException {
        final ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        applicationContext.start();
        final String userName = applicationContext.getBean(UserService.class).getUserName();
        log.info("调用结果 -> {}", userName);
        System.in.read();
    }
}