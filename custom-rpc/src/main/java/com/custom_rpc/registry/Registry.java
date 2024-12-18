package com.custom_rpc.registry;

import java.util.List;

/**
 * 1. registry server
 * 2. get server list (server discovery)
 *
 * @author xl-9527
 * @since 2024/12/17
 **/
public interface Registry {

    String SERVER_PREFIX = "/RPC";
    String SERVER_SUFFIX = "/PROVIDER";

    void registry(String applicationName, String host, int port);

    /**
     * get server list
     *
     * @param applicationName server name
     */
    List<String> getServerList(String applicationName);

    /**
     * server discover
     *
     * @param applicationName server name
     */
    void discovery(String applicationName, List<String> serverList);
}
