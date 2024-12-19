package com.custom_rpc.transport;

import com.custom_rpc.protocol.MethodInvokeData;
import com.custom_rpc.protocol.Result;

/**
 * @author xl-9527
 * @since 2024/12/19
 **/
public interface Transport {

    Result invoke(String serverAddress, MethodInvokeData methodInvokeData) throws InterruptedException;

    void close();
}
