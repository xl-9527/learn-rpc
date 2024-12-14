package com.rpc.pre.server;

import com.rpc.pre.bean.SerializableUser;
import com.rpc.pre.server.codec.CustomMessageToMessageCodec;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;

/**
 * @author xl-9527
 * @since 2024/12/8
 **/
@Slf4j
public class CustomRpcClient {

    public static void main(String[] args) throws InterruptedException {
        ChannelFuture connect = new Bootstrap()
                .channel(NioSocketChannel.class)
                .group(new NioEventLoopGroup())
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(final NioSocketChannel nioSocketChannel) {
                        final ChannelPipeline pipeline = nioSocketChannel.pipeline();
                        // 添加不需要便宜量的分帧
                        pipeline.addLast(new LengthFieldBasedFrameDecoder(1024, 0, 4, 0, 0));
                        pipeline.addLast(new CustomMessageToMessageCodec());
                        // add logger
                        pipeline.addLast(new LoggingHandler());
                    }
                })
                .connect(new InetSocketAddress("localhost", 8888)).sync();

        connect.addListener((ChannelFutureListener) channelFuture -> {
            if (channelFuture.isSuccess()) {
                log.info("连接成功");
                channelFuture.channel().writeAndFlush(new SerializableUser("xl-9527"))
                        .addListener((ChannelFutureListener) listener -> {
                            if (listener.isSuccess()) {
                                log.info("发送成功");
                            } else {
                                log.error("发送失败 -> ", listener.cause());
                            }
                        });
            }
        });
    }
}
