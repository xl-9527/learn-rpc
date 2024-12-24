package com.rpc.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @author xl-9527
 * @since 2024/12/24
 **/
public class ApplicationStart {

    public void start() throws InterruptedException {
        final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:application-context.xml");
        ctx.start();

        new CountDownLatch(1).await();
    }
}
