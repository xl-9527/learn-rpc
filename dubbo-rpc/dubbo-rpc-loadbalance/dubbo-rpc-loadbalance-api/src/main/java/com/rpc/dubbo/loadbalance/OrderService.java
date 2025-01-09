package com.rpc.dubbo.loadbalance;

/**
 * @author xl-9527
 * @since 2025/1/9
 **/
public interface OrderService {

    String getOrderNumber(Long orderId);
}
