package com.rpc.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * @author xl-9527
 * @since 2024/12/13
 **/
@Slf4j
public class ZkServerOps {

    private final ZooKeeper zooKeeper;

    public ZkServerOps() {
        try {
            this.zooKeeper = initServer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String createNode(String path) {
        try {
            return zooKeeper.create(path, null, null, CreateMode.PERSISTENT);
        } catch (KeeperException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteNode() {
    }

    public void deleteAllNode() {
    }

    public void setValue() {
    }

    public void watchNode() {
    }

    public void getNode() {
    }

    public ZooKeeper initServer() throws IOException {
        return new ZooKeeper("101.35.52.157:2181", 10000, new Watcher() {
            @Override
            public void process(final WatchedEvent watchedEvent) {
                log.info("receive watch event -> {}", watchedEvent);
            }
        });
    }
}
