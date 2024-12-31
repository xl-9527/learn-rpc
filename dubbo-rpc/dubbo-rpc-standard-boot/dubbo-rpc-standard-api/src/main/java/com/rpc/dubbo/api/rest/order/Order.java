package com.rpc.dubbo.api.rest.order;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xl-9527
 * @since 2024/12/31
 **/
@Data
@NoArgsConstructor
public class Order {

    public Order(final Long orderId, final String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    private Long orderId;

    private String orderName;
}
