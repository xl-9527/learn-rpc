package com.custom_rpc.proxy;

import com.custom_rpc.RpcClientProvider;
import com.custom_rpc.protocol.MethodInvokeData;
import com.custom_rpc.protocol.Result;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xl-9527
 * @since 2024/12/24
 **/
public class Stub implements InvocationHandler {

    private static final RpcClientProvider RPC_CLIENT_PROVIDER = new RpcClientProvider();

    public <T> T create(Class<T> clazz) {
        if (!clazz.isInterface()) {
            throw new RuntimeException(clazz.getName() + "不是接口");
        }
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
    }

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
        String methodName = method.getName();

        MethodInvokeData methodInvokeData = new MethodInvokeData(method.getDeclaringClass(), methodName, args);

        Result result = RPC_CLIENT_PROVIDER.invoke(methodInvokeData);

        if (result.getException() != null) {
            throw result.getException();
        }

        return result.getResultValue();
    }
}
