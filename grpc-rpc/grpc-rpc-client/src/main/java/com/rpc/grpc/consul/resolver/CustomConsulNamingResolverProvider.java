package com.rpc.grpc.consul.resolver;

import io.grpc.NameResolver;
import io.grpc.NameResolverProvider;

import java.net.URI;

/**
 * @author xl-9527
 * @since 2024/11/24
 **/
public class CustomConsulNamingResolverProvider extends NameResolverProvider {

    /**
     * 是否可以使用
     */
    @Override
    protected boolean isAvailable() {
        return true;
    }

    /**
     * 优先级，越大越优先，grpc 有默认的优先级，我们如果想要覆盖 grpc 默认的名字解析实现，我们需要把这个优先级定义的高一点 {@link DnsNameResolverProvider} 的优先级为 5，我们只需要大于 5 就可以了
     */
    @Override
    protected int priority() {
        return 6;
    }

    @Override
    public NameResolver newNameResolver(final URI targetUri, final NameResolver.Args args) {
        return new CustomConsulNamingResolver(targetUri.getPath().split("/")[1]);
    }

    /**
     * 默认协议，命名解析，通信协议是 consul
     */
    @Override
    public String getDefaultScheme() {
        return "consul";
    }
}
