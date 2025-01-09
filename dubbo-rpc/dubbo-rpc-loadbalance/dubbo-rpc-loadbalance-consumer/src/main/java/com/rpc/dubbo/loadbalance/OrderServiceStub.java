package com.rpc.dubbo.loadbalance;

import org.apache.dubbo.common.constants.ClusterRules;
import org.apache.dubbo.common.constants.LoadbalanceRules;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author xl-9527
 * @since 2025/1/9
 **/
@Service
public class OrderServiceStub {

    private static final Logger log = LoggerFactory.getLogger(OrderServiceStub.class);

    @DubboReference(loadbalance = LoadbalanceRules.ROUND_ROBIN, cluster = ClusterRules.BROADCAST)
    private OrderService orderService;

    public void getOrderNumber(final Long orderId) {
        log.info("orderId -> {}, num -> {}", orderId, orderService.getOrderNumber(orderId));
    }
}
