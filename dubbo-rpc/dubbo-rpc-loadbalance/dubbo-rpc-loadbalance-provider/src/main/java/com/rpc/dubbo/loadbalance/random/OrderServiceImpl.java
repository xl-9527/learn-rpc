package com.rpc.dubbo.loadbalance.random;

import com.rpc.dubbo.loadbalance.OrderService;
import org.apache.dubbo.common.constants.ClusterRules;
import org.apache.dubbo.common.constants.LoadbalanceRules;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * @author xl-9527
 * @since 2025/1/9
 **/
//@DubboService(protocol = "tri", loadbalance = LoadbalanceRules.ROUND_ROBIN, cluster = ClusterRules.FAIL_OVER)
@DubboService(protocol = "tri", loadbalance = LoadbalanceRules.ROUND_ROBIN)
public class OrderServiceImpl implements OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public String getOrderNumber(final Long orderId) {
        log.info("orderId -> {}", orderId);
        /*try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        return UUID.randomUUID().toString();
    }
}
