package com.rpc.custom_rpc.discovery;

import org.junit.jupiter.api.Test;

/**
 * @author xl-9527
 * @since 2024/12/14
 **/
class ServerDiscoveryImplTest {

    final ServerDiscovery discovery = new ServerDiscoveryImpl();

    @Test
    void discovery() {
        discovery.discovery("orderServer").forEach(System.out::println);
    }

    @Test
    void updateServerList() {
        discovery.updateServerList("orderServer");
    }
}