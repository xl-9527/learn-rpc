package com.custom_rpc.config;

import lombok.Getter;

/**
 * @author xl-9527
 * @since 2024/12/21
 **/
public class RpcConfig {

    @Getter
    public static class ZkConfig {
        public static final ZkConfig INSTANCE = new ZkConfig();;

        private final String zkHost;

        private ZkConfig() {
            String zkHost = System.getenv().get("ZK_HOST");
            if (zkHost != null && !zkHost.isEmpty()) {
                this.zkHost = zkHost;
            } else {
                this.zkHost = "127.0.0.1";
            }
        }
    }
}
