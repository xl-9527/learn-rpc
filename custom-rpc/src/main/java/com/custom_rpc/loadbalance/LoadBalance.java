package com.custom_rpc.loadbalance;

import java.util.List;

/**
 * @author xl-9527
 * @since 2024/12/23
 **/
public interface LoadBalance {

    String select(final List<String> serverList);
}
