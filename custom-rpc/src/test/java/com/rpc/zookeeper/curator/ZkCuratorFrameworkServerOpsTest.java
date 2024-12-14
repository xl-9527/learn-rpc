package com.rpc.zookeeper.curator;

import com.rpc.pre.zookeeper.curator.ZkCuratorFrameworkServerOps;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xl-9527
 * @since 2024/12/14
 **/
@Slf4j
class ZkCuratorFrameworkServerOpsTest {

    private final ZkCuratorFrameworkServerOps zkCuratorFrameworkServerOps = new ZkCuratorFrameworkServerOps();

    @Test
    void createNode() {
        String path = "/test";
        String node = zkCuratorFrameworkServerOps.createNode("/test", null, false);
        log.info("node -> {}", node);
        assertEquals(path, node);
    }

    @Test
    void delete() {
        zkCuratorFrameworkServerOps.delete("/test");
    }

    @Test
    void exists() {
        assertTrue(zkCuratorFrameworkServerOps.exists("/test"));
    }

    @Test
    void deleteNode() {
        this.delete();
    }

    @Test
    void watchNode() throws IOException {
        zkCuratorFrameworkServerOps.watchNode("/watch_t");
        System.in.read();
    }

    @Test
    void getNode() {
        final List<String> nodes = zkCuratorFrameworkServerOps.getNode("/test");
        assertNotNull(nodes);
        for (final String node : nodes) {
            log.info("node is -> {}", node);
        }
    }

    @Test
    void setData() {
    }
}