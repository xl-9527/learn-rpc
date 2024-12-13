package com.rpc.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

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
        return this.createNode(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE);
    }

    public String creatDataNode(String path, byte[] bytes) {
        return this.createNode(path, bytes, ZooDefs.Ids.OPEN_ACL_UNSAFE);
    }

    public String createNode(String path, byte[] bytes, List<ACL> acl) {
        try {
            if (!Objects.isNull(bytes) && this.exists(path)) {
                throw new RuntimeException("数据节点不可以对已经存在的节点操作");
            }
            return zooKeeper.create(path, bytes, acl, CreateMode.PERSISTENT);
        } catch (KeeperException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteNode(String path) {
        try {
            zooKeeper.delete(path, -1);
        } catch (InterruptedException | KeeperException e) {
            throw new RuntimeException(e);
        }
    }

    public Stat setValue(String path, byte[] bytes) {
        try {
            if (!exists(path)) {
                return zooKeeper.setData(path, bytes, -1);
            }

            return null;
        } catch (KeeperException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void watchNode(String path) {
        try {
            zooKeeper.addWatch(path, event -> log.info("receive watch event -> {}, and is ok", event), AddWatchMode.PERSISTENT_RECURSIVE);
        } catch (KeeperException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<String> getNode(String path) {
        try {
            return zooKeeper.getChildren(path, false);
        } catch (KeeperException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean exists(String path) {
        try {
            final Stat exists = zooKeeper.exists(path, false);
            return exists != null;
        } catch (KeeperException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public ZooKeeper initServer() throws IOException {
        return new ZooKeeper("101.35.52.157:2181", 10000, watchedEvent -> log.info("receive watch event -> {}", watchedEvent));
    }
}
