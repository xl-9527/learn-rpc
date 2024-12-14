package com.rpc.custom_rpc.discovery;

import java.util.List;
import java.util.Random;

/**
 * @author xl-9527
 * @since 2024/12/14
 **/
public class LoadBalanceImpl implements LoadBalance {

    private final Random random = new Random();

    @Override
    public String select(final List<String> serverList) {
        final int nextInt = random.nextInt(serverList.size());
        return serverList.get(nextInt);
    }
}
