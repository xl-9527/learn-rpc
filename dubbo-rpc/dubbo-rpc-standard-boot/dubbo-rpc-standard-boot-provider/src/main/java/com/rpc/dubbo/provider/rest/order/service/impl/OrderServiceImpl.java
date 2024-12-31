package com.rpc.dubbo.provider.rest.order.service.impl;

import com.rpc.dubbo.api.rest.order.Order;
import com.rpc.dubbo.api.rest.order.service.OrderService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * @author xl-9527
 * @since 2024/12/31
 **/
@Service
@DubboService(protocol = "rest")
public class OrderServiceImpl implements OrderService {

    @Override
    public Order getOrderById(final Long orderId) {
        return new Order(orderId, "测试 rest 订单");
    }
}
