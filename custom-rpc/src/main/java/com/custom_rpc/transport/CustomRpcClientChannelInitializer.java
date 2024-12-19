package com.custom_rpc.transport;

import com.custom_rpc.codec.CustomRpcMessageToMessageCodec;
import com.custom_rpc.protocol.MethodInvokeData;
import com.custom_rpc.protocol.Result;
import io.netty.channel.*;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LoggingHandler;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xl-9527
 * @since 2024/12/19
 **/
@Slf4j
public class CustomRpcClientChannelInitializer extends ChannelInitializer<NioSocketChannel> {

    private final MethodInvokeData methodInvokeData;

    @Getter
    @Setter
    private Result result;

    public CustomRpcClientChannelInitializer(final MethodInvokeData methodInvokeData) {
        this.methodInvokeData = methodInvokeData;
    }

    @Override
    protected void initChannel(final NioSocketChannel ch) throws Exception {
        final ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new LoggingHandler());
        pipeline.addLast(new LengthFieldBasedFrameDecoder(1024, 10, 4, 0, 0));
        pipeline.addLast(new CustomRpcMessageToMessageCodec());
        pipeline.addLast(new ChannelInboundHandlerAdapter() {

            /**
             * 请求服务，如果请求的过程中发生异常将会自动关闭请求的 channel
             */
            @Override
            public void channelActive(final ChannelHandlerContext ctx) throws Exception {
                log.info("请求服务的方法 -> {}", methodInvokeData.getMethod());
                ctx.writeAndFlush(methodInvokeData).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
            }

            /**
             * 收到响应
             */
            @Override
            public void channelRead(final ChannelHandlerContext ctx, final Object msg) throws Exception {
                // 响应数据到客户端 server -> client
                if (msg instanceof Result result) {
                    log.info("收到服务端到消息 -> {}", result.getResultValue());
                    setResult(result);
                }
            }
        });
    }
}
