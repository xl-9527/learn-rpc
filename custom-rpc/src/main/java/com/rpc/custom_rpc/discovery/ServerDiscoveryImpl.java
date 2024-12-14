package com.rpc.custom_rpc.discovery;

import com.rpc.custom_rpc.config.CustomRpcConfig;
import com.rpc.pre.zookeeper.curator.ZkCuratorFrameworkServerOps;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;

import java.util.List;
import java.util.Objects;

/**
 * @author xl-9527
 * @since 2024/12/14
 **/
@Slf4j
public class ServerDiscoveryImpl implements ServerDiscovery {

    private final ZkCuratorFrameworkServerOps zkCuratorFrameworkServerOps;

    public ServerDiscoveryImpl() {
        this.zkCuratorFrameworkServerOps = new ZkCuratorFrameworkServerOps();
    }

    @Override
    public List<String> discovery(final String serverName) {
        if (zkCuratorFrameworkServerOps.exists(CustomRpcConfig.BASE_PATH + serverName)) {
            final List<String> serverList = zkCuratorFrameworkServerOps.getNode(CustomRpcConfig.BASE_PATH + serverName);
            log.info("发现服务 -> {}", serverList);
            if (Objects.isNull(serverList) || serverList.isEmpty()) {
                log.warn("服务列表为空 -> {}", serverName);
            }
            return serverList;
        }

        log.warn("未发现服务 -> {}", serverName);
        return List.of();
    }

    @Override
    public void updateServerList(final String serverName) {
        zkCuratorFrameworkServerOps.watchNode(
                CustomRpcConfig.BASE_PATH + serverName,
                (PathChildrenCacheListener) (curatorFramework, pathChildrenCacheEvent) -> {
                    log.info("监听到服务列表更新 -> {}", pathChildrenCacheEvent);
                    curatorFramework.getChildren().forPath(CustomRpcConfig.BASE_PATH + serverName).forEach(System.out::println);
                }
        );
    }
}
