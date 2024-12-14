package com.rpc.pre.zookeeper;

import org.apache.zookeeper.CreateMode;

import java.util.List;
import java.util.function.Function;

/**
 * @author xl-9527
 * @since 2024/12/14
 **/
public interface ZkOps {

    String createNode(String path);

    String createNode(String path, byte[] bytes);

    String createNode(String path, byte[] bytes, CreateMode createMode);

    boolean exists(String path);

    void deleteNode(String path);

    void watchNode(String path);

    List<String> getNode(String path);

    <T> T setData(String path, Function<byte[], T> clazz);
}
