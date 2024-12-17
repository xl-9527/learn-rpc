package com.rpc.pre.zookeeper.curator;

import com.rpc.pre.zookeeper.ZkOps;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CreateBuilder;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * curator 的简单实用
 *
 * @author xl-9527
 * @since 2024/12/14
 **/
@Slf4j
public class ZkCuratorFrameworkServerOps implements ZkOps {

    private final CuratorFramework curatorFramework;

    public ZkCuratorFrameworkServerOps() {
        this.curatorFramework = this.initFrameWork();
        // start and to connection to remote zookeeper
        curatorFramework.start();
    }

    /**
     * create node
     *
     * @param path  path node
     * @param bytes data if data is null then curator will use default data ( client ip address)
     * @return data node path
     */
    public String createNode(String path, byte[] bytes, boolean parentNeed) {
        final CreateBuilder createBuilder = curatorFramework.create();

        if (parentNeed) {
            createBuilder.creatingParentsIfNeeded();
        }
        try {
            if (!Objects.isNull(bytes)) {
                return createBuilder
                        .forPath(path, bytes);
            }
            // none data
            return createBuilder
                    .forPath(path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String path) {
        try {
            curatorFramework.delete().deletingChildrenIfNeeded()
                    .forPath(path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected CuratorFramework initFrameWork() {
        // retry setting
        final ExponentialBackoffRetry backoffRetry = new
                ExponentialBackoffRetry(1000, 3, 3000);
        // init client
        return CuratorFrameworkFactory.builder()
                .connectString("101.35.52.157:2181")
                .connectionTimeoutMs(3000)
                .sessionTimeoutMs(3000)
                .retryPolicy(backoffRetry)
                .build();
    }

    @Override
    public String createNode(final String path) {
        try {
            return curatorFramework.create().forPath(path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String createNode(final String path, final byte[] bytes) {
        try {
            return curatorFramework.create().forPath(path, bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String createNode(final String path, final byte[] bytes, final CreateMode createMode) {
        try {
            return curatorFramework.create().withMode(createMode)
                    .forPath(path, bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean exists(final String path) {
        try {
            return !Objects.isNull(curatorFramework.checkExists().forPath(path));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteNode(final String path) {
        try {
            curatorFramework.delete().deletingChildrenIfNeeded().forPath(path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void watchNode(String path, PathChildrenCacheListener pathChildrenCacheListener) {
        try (final CuratorCache curatorCache = CuratorCache.builder(curatorFramework, path).build()) {
            curatorCache.listenable().addListener(
                    CuratorCacheListener.builder()
                            .forPathChildrenCache(path, curatorFramework, pathChildrenCacheListener)
                            .build()
            );
            curatorCache.start();
            final int read = System.in.read();
            log.info("read path child listener is {}", read);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void watchNode(String path, CuratorCacheListenerBuilder.ChangeListener changeListener) {
        try (final CuratorCache curatorCache = CuratorCache.builder(curatorFramework, path).build()) {
            curatorCache.listenable().addListener(
                    CuratorCacheListener.builder()
                            .forChanges(changeListener)
                            .build()
            );
            curatorCache.start();
        } finally {
            final int read;
            try {
                read = System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            log.info("read is {}", read);
        }
    }

    @Override
    public void watchNode(final String path) {
        try {
            // 监听数据的改变
            final CuratorCacheListener listener = CuratorCacheListener.builder().forChanges((oldData, newData) -> {
                log.info("old data is {} , new data is {}", new String(oldData.getData()), new String(newData.getData()));
            }).build();

            // 监听路径的变化
            // 监听子节点的变化
            final CuratorCacheListenerBuilder pathChildrenCache = CuratorCacheListener.builder().forPathChildrenCache(path, curatorFramework, (curatorFramework, pathChildrenCacheEvent) -> {
                curatorFramework.getChildren().forPath("/").forEach(System.out::println);
                log.info("path is {} , type is {}", pathChildrenCacheEvent.getType(), pathChildrenCacheEvent.getType());
            });

            // 监听子节点以及父节点的变化。父节点只会监听父一集的并不会父一集以上的的节点变化
            final CuratorCacheListener treeCacheListener = CuratorCacheListener.builder().forTreeCache(curatorFramework, new TreeCacheListener() {
                @Override
                public void childEvent(final CuratorFramework curatorFramework, final TreeCacheEvent treeCacheEvent) throws Exception {
                    log.info("tree cache is listener path is {} , type is {}", treeCacheEvent.getType(), treeCacheEvent.getType());
                }
            }).build();


            final CuratorCache curatorCache = CuratorCache.build(curatorFramework, path);

            // curatorCache.listenable().addListener(listener);
            // curatorCache.listenable().addListener(pathChildrenCache.build());
            curatorCache.listenable().addListener(treeCacheListener);
            curatorCache.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> getNode(final String path) {
        try {
            return curatorFramework.getChildren().forPath(path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T setData(final String path, final Function<byte[], T> handler) {
        try {
            return handler.apply(curatorFramework.getData().forPath(path));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}