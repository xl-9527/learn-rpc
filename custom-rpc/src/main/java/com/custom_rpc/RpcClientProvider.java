package com.custom_rpc;

import com.custom_rpc.loadbalance.LoadBalance;
import com.custom_rpc.loadbalance.RandomLoadBalance;
import com.custom_rpc.protocol.MethodInvokeData;
import com.custom_rpc.protocol.Result;
import com.custom_rpc.registry.Registry;
import com.custom_rpc.registry.ZookeeperRegistryImpl;
import com.custom_rpc.transport.NettyTransportImpl;
import com.custom_rpc.transport.Transport;

import java.util.List;

/**
 * @author xl-9527
 * @since 2024/12/23
 **/
public class RpcClientProvider {
    private final Registry registry;
    private final Transport transport;
    private final LoadBalance loadBalance;

    public RpcClientProvider() {
        this.registry = new ZookeeperRegistryImpl();
        this.transport = new NettyTransportImpl();
        this.loadBalance = new RandomLoadBalance();
    }

    public Result invoke(final MethodInvokeData methodInvokeData) {
        try {
            return transport.invoke(this.getRpcAddress(methodInvokeData.getInterfaceName()), methodInvokeData);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String getRpcAddress(final String applicationName) {
        try {
            final List<String> serverList = registry.getServerList(applicationName);
            return loadBalance.select(serverList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
