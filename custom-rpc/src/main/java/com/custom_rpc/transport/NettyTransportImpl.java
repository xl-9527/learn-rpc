package com.custom_rpc.transport;

import com.custom_rpc.protocol.MethodInvokeData;
import com.custom_rpc.protocol.Result;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author xl-9527
 * @since 2024/12/19
 **/
public class NettyTransportImpl implements Transport {

    private final Bootstrap bootstrap;
    private final EventLoopGroup work;

    public NettyTransportImpl() {
        this(1);
    }

    public NettyTransportImpl(final int workThreads) {
        this.work = new NioEventLoopGroup(workThreads);
        this.bootstrap = new Bootstrap()
                .channel(NioSocketChannel.class)
                .group(work);
        Runtime.getRuntime().addShutdownHook(new Thread(work::shutdownGracefully));
    }

    @Override
    public Result invoke(final String serverAddress, final MethodInvokeData methodInvokeData) throws InterruptedException {
        final String[] serverAddressAndPort = serverAddress.split(":");
        final CustomRpcClientChannelInitializer initializer = new CustomRpcClientChannelInitializer(methodInvokeData);
        final ChannelFuture channelFuture = bootstrap.handler(initializer)
                .connect(serverAddressAndPort[0], Integer.parseInt(serverAddressAndPort[1]))
                .sync();
        channelFuture.channel().closeFuture().sync();
        return initializer.getResult();
    }

    @Override
    public void close() {
        work.shutdownGracefully();
    }
}
