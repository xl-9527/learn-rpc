package com.rpc.custom_rpc.registery;

import com.rpc.custom_rpc.config.CustomRpcConfig;
import com.rpc.pre.zookeeper.curator.ZkCuratorFrameworkServerOps;
import org.apache.zookeeper.CreateMode;

import java.nio.charset.StandardCharsets;

/**
 * @author xl-9527
 * @since 2024/12/14
 **/
public class ServerRegistryImpl implements ServerRegistry {
    private final String ip;
    private final int port;
    private final ZkCuratorFrameworkServerOps zkCuratorFrameworkServerOps;

    public ServerRegistryImpl(final String ip, final int port) {
        this.ip = ip;
        this.port = port;
        this.zkCuratorFrameworkServerOps = new ZkCuratorFrameworkServerOps();
    }

    @Override
    public void registry(final String serviceName) {
        final String path = CustomRpcConfig.BASE_PATH + serviceName;
        if (!zkCuratorFrameworkServerOps.exists(path)) {
            zkCuratorFrameworkServerOps.createNode(path, null, true);
        }

        // 创建临时节点
        zkCuratorFrameworkServerOps.createNode(path + "/" + ip + ":" + port, (ip + ":" + port).getBytes(StandardCharsets.UTF_8), CreateMode.EPHEMERAL);
    }
}
