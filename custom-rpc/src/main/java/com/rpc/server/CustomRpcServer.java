package com.rpc.server;

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
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(final NioSocketChannel nioSocketChannel) throws Exception {
                        final ChannelPipeline pipeline = nioSocketChannel.pipeline();
                        // add logger
                        pipeline.addLast(new LoggingHandler());
                        // 添加不需要便宜量的分帧
                        pipeline.addLast(new LengthFieldBasedFrameDecoder(1024, 0, 4, 0, 0));
                        pipeline.addLast(new CustomMessageToMessageCodec());
                        pipeline.addLast(new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelRead(final ChannelHandlerContext ctx, final Object msg) throws Exception {
                                log.info("收到客户端的消息");
                                super.channelRead(ctx, msg);
                            }
                        });
                    }
                });

        serverBootstrap.bind(8888).sync();
    }
}
