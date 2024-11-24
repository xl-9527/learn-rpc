package com.rpc.grpc.consul.resolver;

import com.orbitz.consul.Consul;
import io.grpc.EquivalentAddressGroup;
import io.grpc.NameResolver;
import io.grpc.Status;
import io.grpc.StatusOr;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xl-9527
 * @since 2024/11/24
 **/
@Slf4j
public class CustomConsulNamingResolver extends NameResolver {

    private final String serverName;

    private final Consul consul = Consul.builder().build();
    private final ScheduledThreadPoolExecutor scheduledPool = new ScheduledThreadPoolExecutor(10);
    private Listener2 listener;

    public CustomConsulNamingResolver(final String serverName) {
        log.info("初始化 consul resolver -> {}", serverName);
        this.serverName = serverName;
    }

    /**
     * 开始获取可用服务的列表通过监听的方式，在响应式编程的时候 observer ｜ listener 的方式是十分的常见的
     *
     * @param listener 监听器，监听结果（error）、结果（address）
     */
    @Override
    public void start(final Listener2 listener) {
        this.listener = listener;
        scheduledPool.scheduleAtFixedRate(this::doResolver, 10, 10, TimeUnit.SECONDS);
    }

    private void doResolver() {
        log.debug("开始解析服务 -> {}", serverName);
        // 封装地址
        final List<InetSocketAddress> socketAddressList = consul.healthClient()
                .getHealthyServiceInstances(serverName).getResponse()
                .stream().map(v -> new InetSocketAddress(v.getService().getAddress(), v.getService().getPort()))
                .toList();

        if (ObjectUtils.isEmpty(socketAddressList)) {
            log.warn("没有可以用的服务节点 -> {}", serverName);
            listener.onError(Status.UNAVAILABLE.withDescription("没有可用的节点"));
        } else {
            // 监听结果
            listener.onResult(ResolutionResult.newBuilder().setAddressesOrError(
                    StatusOr.fromValue(socketAddressList.stream().map(EquivalentAddressGroup::new).toList())
            ).build());
        }
    }

    @Override
    public void shutdown() {
        scheduledPool.shutdown();
    }

    @Override
    public String getServiceAuthority() {
        return serverName;
    }
}
