package com.rpc.dubbo.provider;

import org.junit.jupiter.api.Test;

/**
 * @author xl-9527
 * @since 2024/12/24
 **/
class ProviderStartTest {

    private ProviderStart providerStart;

    /**
     * 这里默认的可能是 hessian
     */
    @Test
    void start() throws InterruptedException {
        providerStart = new ProviderStart("application-context.xml");
        providerStart.start();
    }

    /**
     * 使用应该增加 vm 参数 (-ea --add-opens java.base/java.util=ALL-UNNAMED --add-opens java.base/java.text=ALL-UNNAMED)
     */
    @Test
    void startWithSerializationKryo() throws InterruptedException {
        providerStart = new ProviderStart("application-kryo-context.xml");
        providerStart.start();
    }

    /**
     * 使用应该增加 vm 参数 (-ea --add-opens java.base/java.util=ALL-UNNAMED --add-opens java.base/java.text=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.math=ALL-UNNAMED --add-opens java.base/java.util.concurrent=ALL-UNNAMED --add-opens java.base/java.net=ALL-UNNAMED)
     */
    @Test
    void startWithSerializationFst() throws InterruptedException {
        providerStart = new ProviderStart("application-fst-context.xml");
        providerStart.start();
    }

    @Test
    void startWithSerializationFastJson2() throws InterruptedException {
        providerStart = new ProviderStart("application-fastjson2-context.xml");
        providerStart.start();
    }
}
