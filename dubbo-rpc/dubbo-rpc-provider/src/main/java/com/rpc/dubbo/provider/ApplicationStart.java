package com.rpc.dubbo.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @author xl-9527
 * @since 2024/12/24
 **/
@Slf4j
public class ApplicationStart {

    public void start() throws InterruptedException {
        final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
        ctx.start();
        log.info("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (final String definitionName : ctx.getBeanDefinitionNames()) {
            log.info("|-----{}", definitionName);
        }
        log.info("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        new CountDownLatch(1).await();
    }
}
