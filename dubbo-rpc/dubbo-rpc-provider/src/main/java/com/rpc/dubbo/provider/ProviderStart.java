package com.rpc.dubbo.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @author xl-9527
 * @since 2024/12/24
 **/
@Slf4j
public class ProviderStart {

    private final String applicationXmlConfig;

    public ProviderStart(final String applicationXmlConfig) {
        this.applicationXmlConfig = applicationXmlConfig;
    }

    public void start() throws InterruptedException {
        final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(applicationXmlConfig);
        ctx.start();
        new CountDownLatch(1).await();
    }
}
