package com.rpc.dubbo.api.rest.order.service;

import com.rpc.dubbo.api.rest.order.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xl-9527
 * @since 2024/12/31
 **/
@RestController
@RequestMapping("order")
public interface OrderService {

    @GetMapping
    Order getOrderById(Long orderId);
}
