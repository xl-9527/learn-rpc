package com.rpc.dubbo.provider;

import org.junit.jupiter.api.Test;

/**
 * @author xl-9527
 * @since 2024/12/24
 **/
class ProviderStartTest {

    private ProviderStart providerStart;

    @Test
    void start() throws InterruptedException {
        providerStart = new ProviderStart("application-context.xml");
        providerStart.start();
    }

    @Test
    void startWithSerializationKryo() throws InterruptedException {
        providerStart = new ProviderStart("application-kryo-context.xml");
        providerStart.start();
    }
}
