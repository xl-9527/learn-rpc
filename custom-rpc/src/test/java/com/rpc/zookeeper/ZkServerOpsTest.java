package com.rpc.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
}