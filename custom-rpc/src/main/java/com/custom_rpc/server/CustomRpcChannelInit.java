package com.custom_rpc.server;

import com.custom_rpc.codec.CustomRpcMessageToMessageCodec;
import com.custom_rpc.protocol.MethodInvokeData;
import com.custom_rpc.protocol.Protocol;
import com.custom_rpc.protocol.Result;
import io.netty.channel.*;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Objects;

/**
 * @author xl-9527
 * @since 2024/12/18
 **/
@Slf4j
public class CustomRpcChannelInit extends ChannelInitializer<NioSocketChannel> {

    private final EventLoopGroup handler;
    private final EventLoopGroup bizServer;
    private final Map<String, Object> exposeBean;

    public CustomRpcChannelInit(final EventLoopGroup handler, final EventLoopGroup bizServer, final Map<String, Object> exposeBean) {
        this.handler = handler;
        this.bizServer = bizServer;
        this.exposeBean = exposeBean;
    }

    @Override
    protected void initChannel(final NioSocketChannel nioSocketChannel) throws Exception {
        final ChannelPipeline pipeline = nioSocketChannel.pipeline();
        // logging
        pipeline.addLast(handler, new LoggingHandler());
        // 封帧操作
        pipeline.addLast(
                handler,
                new LengthFieldBasedFrameDecoder(
                        1024, 11, 4, 0, 0
                )
        );
        // codec
        pipeline.addLast(handler, new CustomRpcMessageToMessageCodec());
        // custom rpc handler
        pipeline.addLast(bizServer, new ChannelInboundHandlerAdapter() {

            @Override
            public void channelRead(final ChannelHandlerContext ctx, final Object msg) throws Exception {
                log.info("收到信息 -> {}", msg);
                if (msg instanceof MethodInvokeData methodInvokeData) {
                    Protocol protocol = this.execute(methodInvokeData);
                    ctx.writeAndFlush(protocol).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
                }
            }

            private Protocol execute(final MethodInvokeData methodInvokeData) {
                final String interfaceName = methodInvokeData.getInterfaceName();
                final Object object = exposeBean.get(interfaceName);
                if (Objects.isNull(object)) {
                    final Result result = new Result();
                    result.setException(new RuntimeException("调用对象不存在 -> " + interfaceName));
                    return result;
                }

                // 反射调用
                return new Result();
            }

            @Override
            public void exceptionCaught(final ChannelHandlerContext ctx, final Throwable cause) throws Exception {
                log.error("服务端异常", cause);
            }
        });
    }
}
