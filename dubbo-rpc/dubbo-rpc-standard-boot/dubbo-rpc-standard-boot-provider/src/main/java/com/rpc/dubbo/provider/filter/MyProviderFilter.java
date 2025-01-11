package com.rpc.dubbo.provider.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.rpc.*;

/**
 * @author xl-9527
 * @since 2025/1/11
 **/
@Slf4j
public class MyProviderFilter implements Filter {

    /**
     * @param invoker    实际这次的调用
     * @param invocation 本次调用的参数
     */
    @Override
    public Result invoke(final Invoker<?> invoker, final Invocation invocation) throws RpcException {
        log.info("MyProviderFilter invoke");
        return invoker.invoke(invocation);
    }
}
