package com.rpc.server;

import com.rpc.custom_grpc.SerializableProto;
import com.rpc.server.codec.CustomMessageToMessageCodec;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
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
        new Bootstrap()
                .channel(NioSocketChannel.class)
                .group(new NioEventLoopGroup())
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(final NioSocketChannel nioSocketChannel) throws Exception {
                        final ChannelPipeline pipeline = nioSocketChannel.pipeline();
                        // add logger
                        pipeline.addLast(new LoggingHandler());
                        // 添加不需要便宜量的分帧
                        pipeline.addLast(new LengthFieldBasedFrameDecoder(1024, 0,4, 0,0));
                        pipeline.addLast(new CustomMessageToMessageCodec());
                        pipeline.addLast(new ChannelInboundHandlerAdapter() {

                            @Override
                            public void channelActive(final ChannelHandlerContext ctx) throws Exception {
                                super.channelActive(ctx);
                                log.info("连接到服务器");
                                ctx.writeAndFlush(
                                        SerializableProto.SerializableUser.newBuilder()
                                                .setUsername("xl-9527")
                                                .build()
                                );
                            }
                        });
                    }
                })
                .connect(new InetSocketAddress("localhost", 8888));
    }
}
