package com.rpc.dubbo.api.service;

import com.rpc.dubbo.api.entity.Address;

import java.util.List;

/**
 * @author xl-9527
 * @since 2025/1/20
 **/
public interface AddressService {

    List<Address> queryList();
}
