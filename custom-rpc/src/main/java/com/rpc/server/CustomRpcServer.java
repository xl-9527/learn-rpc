package com.rpc.server;

import com.rpc.biz.bean.SerializableUser;
import com.rpc.server.codec.CustomMessageToMessageCodec;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xl-9527
 * @since 2024/12/8
 **/
@Slf4j
public class CustomRpcServer {

    public static void main(String[] args) throws InterruptedException {
        final ServerBootstrap serverBootstrap = new ServerBootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler())
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(final NioSocketChannel nioSocketChannel) {
                        final ChannelPipeline pipeline = nioSocketChannel.pipeline();
                        // 添加不需要偏移量的分帧
                        pipeline.addLast(new LengthFieldBasedFrameDecoder(1024, 0, 4, 0, 0));
                        pipeline.addLast(new CustomMessageToMessageCodec());
                        pipeline.addLast(new SimpleChannelInboundHandler<>() {
                            @Override
                            protected void channelRead0(final ChannelHandlerContext channelHandlerContext, final Object o) {
                                if (o instanceof SerializableUser serializableUser) {
                                    log.info("serializableUser -> {}", serializableUser.getUsername());
                                }
                            }
                        });
                    }
                });

        serverBootstrap.bind(8888).sync().channel().closeFuture().sync();
    }
}
