package com.custom_rpc.protocol;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 这个主要是处理请求的数据的包装
 * 1. 目标的接口
 * 2. 方法
 * 3. 参数类型
 * 4. 实际上数据
 *
 * @author xl-9527
 * @since 2024/12/15
 **/
@Getter
@Setter
@NoArgsConstructor
public class MethodInvokeData implements Protocol {

    public MethodInvokeData(final String interfaceName, final String method, final Class<?>[] parameterTypes, final Object[] args) {
        this.interfaceName = interfaceName;
        this.method = method;
        this.parameterTypes = parameterTypes;
        this.args = args;
    }

    /**
     * 目标接口
     */
    private String interfaceName;

    /**
     * 方法名
     */
    private String method;

    /**
     * 参数类型
     */
    private Class<?>[] parameterTypes;

    /**
     * 实际参数
     */
    private Object[] args;
}
