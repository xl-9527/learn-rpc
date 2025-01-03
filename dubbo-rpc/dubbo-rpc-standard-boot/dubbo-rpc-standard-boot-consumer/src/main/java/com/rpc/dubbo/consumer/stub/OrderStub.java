package com.rpc.dubbo.consumer.stub;

import com.rpc.dubbo.api.rest.order.Order;
import com.rpc.dubbo.api.rest.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author xl-9527
 * @since 2025/1/1
 **/
@Slf4j
@Component
@Profile("rest")
public class OrderStub implements InitializingBean {

    @DubboReference
    private OrderService orderService;

    public Order getOrderById(Long orderId) {
        final Order order = orderService.getOrderById(orderId);
        log.info("order: orderId -> {}, orderName -> {}", order.getOrderId(), order.getOrderName());
        return order;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("this.getOrderById(1L) = " + this.getOrderById(1L));
    }
}
