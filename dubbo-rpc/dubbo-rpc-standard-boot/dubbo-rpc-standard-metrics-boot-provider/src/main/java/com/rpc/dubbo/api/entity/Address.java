package com.rpc.dubbo.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xl-9527
 * @since 2025/1/20
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private int addressId;

    private String addressName;
}
