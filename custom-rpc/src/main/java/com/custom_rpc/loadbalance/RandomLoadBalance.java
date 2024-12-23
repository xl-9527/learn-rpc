package com.custom_rpc.loadbalance;

import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * 随机
 *
 * @author xl-9527
 * @since 2024/12/23
 **/
public class RandomLoadBalance implements LoadBalance {

    private final Random random = new Random();

    @Override
    public String select(final List<String> serverList) {
        if (Objects.isNull(serverList) || serverList.isEmpty()) {
            throw new RuntimeException("serverList is empty");
        }
        return serverList.get(random.nextInt(serverList.size()));
    }
}
