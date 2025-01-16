package com.rpc.dubbo.consumer.stub.filter.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xl-9527
 * @since 2025/1/16
 **/
@Activate(group = CommonConstants.CONSUMER)
public class ConsumerFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(ConsumerFilter.class);

    @Override
    public Result invoke(final Invoker<?> invoker, final Invocation invocation) throws RpcException {
        log.info("ConsumerFilter invoke -> {}", invocation.getMethodName());
        return invoker.invoke(invocation);
    }
}
