package com.custom_rpc.registry;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

/**
 * @author xl-9527
 * @since 2024/12/17
 **/
@Slf4j
public class ZookeeperRegistryImpl implements Registry {

    private final CuratorFramework curatorFramework;

    public ZookeeperRegistryImpl() {
        curatorFramework = initCuratorFramework();
        curatorFramework.start();
    }

    @Override
    public void registry(final String applicationName, final String host, final int port) {
        try {
            final String path = SERVER_PREFIX + "/" + applicationName + SERVER_SUFFIX;
            if (Objects.isNull(curatorFramework.checkExists().forPath(path))) {
                curatorFramework.create().creatingParentsIfNeeded()
                        .forPath(path);
            } else {
                if (log.isDebugEnabled()) {
                    log.debug("节点已经存在 -> {}", path);
                }
            }
            curatorFramework.create().withMode(CreateMode.EPHEMERAL)
                    .forPath(path + "/" + host + ":" + port, (host + ":" + port).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> getServerList(final String applicationName) {
        return List.of();
    }

    @Override
    public void discovery(final String applicationName, final List<String> serverList) {

    }


    /**
     * 初始化 Curator 的对 zookeeper 的链接
     *
     * @return Curator 操作对象
     */
    private CuratorFramework initCuratorFramework() {
        return CuratorFrameworkFactory.builder()
                .connectString("127.0.0.1:2181")
                .connectionTimeoutMs(3000)
                .sessionTimeoutMs(3000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3, 3000))
                .build();
    }
}
