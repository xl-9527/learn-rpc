package com.rpc.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author xl-9527
 * @since 2024/12/13
 **/
@Slf4j
class ZkServerOpsTest {

    private final ZkServerOps zkServerOps = new ZkServerOps();

    @Test
    void initServer() throws IOException {
        try (ZooKeeper zooKeeper = zkServerOps.initServer()) {
            log.info("链接成功 zk 服务 -> {}", zooKeeper);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void createNode() {
        final String node = zkServerOps.createNode("/test/watch-t");
        log.info("创建节点 -> {}", node);
    }

    @Test
    void deleteNode() {
        zkServerOps.deleteNode("/test/watch-t");
    }

    @Test
    void setValue() {
        final Stat stat = zkServerOps.setValue("/zookeeper-val", "hello-1".getBytes());
        log.info("修改值 -> {}", stat);
    }

    @Test
    void creatDataNode() {
        final String dataNode = zkServerOps.creatDataNode("/zookeeper-valsahdksalkdkjsad", "hello".getBytes());
        log.info("创建数据节点 -> {}", dataNode);
    }

    @Test
    void exists() {
        final boolean existsNot = zkServerOps.exists("/zookeeper-val-not");
        final boolean exists = zkServerOps.exists("/zookeeper-val");
        log.info("节点是否存在 -> {}", exists);
        log.info("节点是否存在 -> {}", existsNot);
    }

    @Test
    void watchNode() {
        zkServerOps.watchNode("/test/watch-t");
    }

    @Test
    void getNode() {
        final List<String> node = zkServerOps.getNode("/");
        for (final String nodePath : node) {
            log.info("获取节点 -> {}", nodePath);
        }
    }
}