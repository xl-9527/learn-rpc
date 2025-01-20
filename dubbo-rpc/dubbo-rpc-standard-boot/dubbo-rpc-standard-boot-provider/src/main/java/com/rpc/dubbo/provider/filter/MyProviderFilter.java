package com.rpc.dubbo.provider.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

/**
 * @author xl-9527
 * @since 2025/1/11
 **/
@Slf4j
//@Activate(group = CommonConstants.PROVIDER) // active 中 group 的设置是表示他运行在 consumer 还是 provider 端，这是必须要要配置的
public class MyProviderFilter implements Filter {

    /**
     * @param invoker    实际这次的调用
     * @param invocation 本次调用的参数
     * @return 调用结果，这里的调用结果是从 provider 端调用过来的
     */
    @Override
    public Result invoke(final Invoker<?> invoker, final Invocation invocation) throws RpcException {
        System.out.println("invoker.getUrl() = " + invoker.getUrl());
        System.out.println("invocation.getMethodName() = " + invocation.getMethodName());
        System.out.println("invocation.getServiceModel().getServiceName() = " + invocation.getServiceModel().getServiceName());
        log.info("MyProviderFilter invoke");
        return invoker.invoke(invocation);
    }
}
