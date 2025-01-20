package com.rpc.dubbo.service;

import com.rpc.dubbo.api.entity.Address;
import com.rpc.dubbo.api.service.AddressService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.List;

/**
 * @author xl-9527
 * @since 2025/1/20
 **/
@DubboService(protocol = "triple")
public class AddressServiceImpl implements AddressService {

    @Override
    public List<Address> queryList() {
        return List.of();
    }
}
