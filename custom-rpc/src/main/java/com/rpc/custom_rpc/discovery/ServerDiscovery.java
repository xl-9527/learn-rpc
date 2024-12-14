package com.rpc.custom_rpc.discovery;

import java.util.List;

/**
 * @author xl-9527
 * @since 2024/12/14
 **/
public interface ServerDiscovery {

    List<String> discovery(String serverName);

    void updateServerList(String serverName);
}
