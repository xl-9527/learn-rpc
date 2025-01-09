package com.rpc.dubbo.loadbalance.random;

import com.rpc.dubbo.loadbalance.OrderService;
import org.apache.dubbo.common.constants.LoadbalanceRules;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * @author xl-9527
 * @since 2025/1/9
 **/
@DubboService(protocol = "tri", loadbalance = LoadbalanceRules.CONSISTENT_HASH)
public class OrderServiceImpl implements OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public String getOrderNumber(final Long orderId) {
        log.info("orderId -> {}", orderId);
        return UUID.randomUUID().toString();
    }
}
