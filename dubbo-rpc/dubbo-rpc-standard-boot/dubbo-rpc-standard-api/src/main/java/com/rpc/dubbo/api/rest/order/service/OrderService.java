package com.rpc.dubbo.api.rest.order.service;

import com.rpc.dubbo.api.rest.order.Order;

/**
 * @author xl-9527
 * @since 2024/12/31
 **/
public interface OrderService {

    Order getOrderById(Long orderId);
}
