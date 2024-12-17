package com.custom_rpc;

import com.custom_rpc.registry.Registry;
import com.custom_rpc.registry.ZookeeperRegistryImpl;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 设计 netty 服务端的代码
 * 2. 注册服务到注册中心中
 * 3. 引入业务代码
 * 4. 根据 client 的调用反射调用 server 的 method
 *
 * @author xl-9527
 * @since 2024/12/16
 **/
@Slf4j
public class RpcServerProvider {

    private final int port;
    private final EventLoopGroup boos;
    private final EventLoopGroup work;
    /* 主要是服务 编解码器，日志，公共发 handler */
    private final EventLoopGroup handler;
    /* 给我们的 biz 业务服务提供线程组的支持 */
    private final EventLoopGroup bizService;

    private final int workThreads;
    private final int handlerThreads;
    private final int bizServiceThreads;

    /* 注册中心相关 */
    private final Registry registry;
    private final Map<String, Object> exposeBeans;

    /**
     * 默认提供 8888 端口，并且提供空的 exposBeans 的配置，而且默认注册中心为 zookeeper
     */
    public RpcServerProvider() {
        this(8888, 1, 1, 1, new ZookeeperRegistryImpl(), new HashMap<>());
    }

    public RpcServerProvider(
            final int port, final int workThreads, final int handlerThreads, final int bizServiceThreads,
            final Registry registry, final Map<String, Object> exposeBeans
    ) {
        this.port = port;
        this.workThreads = workThreads;
        this.handlerThreads = handlerThreads;
        this.bizServiceThreads = bizServiceThreads;
        // 因为 netty 服务端，需要一个线程来处理连接，所以这里需要一个线程
        this.boos = new NioEventLoopGroup(1);
        this.work = new NioEventLoopGroup(workThreads);
        this.handler = new NioEventLoopGroup(handlerThreads);
        this.bizService = new NioEventLoopGroup(bizServiceThreads);
        this.registry = registry;
        this.exposeBeans = exposeBeans;
    }

    public void start() throws InterruptedException {
        final ServerBootstrap server = new ServerBootstrap()
                .group(boos, work)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(final NioSocketChannel nioSocketChannel) throws Exception {
                        final ChannelPipeline pipeline = nioSocketChannel.pipeline();
                        // logging
                        pipeline.addLast(handler, new LoggingHandler());
                    }
                });
        server.bind(8888).sync().addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(final ChannelFuture channelFuture) throws Exception {
                if (channelFuture.isSuccess()) {
                    // 服务注册
                    registry.registry("userService", "127.0.0.1", 8888);
                    log.info("服务启动成功");
                }
            }
        });
    }

    public void stop() {

    }
}
