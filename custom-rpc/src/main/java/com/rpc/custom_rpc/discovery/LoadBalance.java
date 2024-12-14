package com.rpc.custom_rpc.discovery;

import java.util.List;

/**
 * 适配服务发现，实现负载均衡
 *
 * @author xl-9527
 * @since 2024/12/14
 **/
public interface LoadBalance {

    String select(List<String> serverList);
}
