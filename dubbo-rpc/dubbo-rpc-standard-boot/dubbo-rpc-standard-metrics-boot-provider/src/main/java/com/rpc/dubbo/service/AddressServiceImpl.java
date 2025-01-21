package com.rpc.dubbo.service;

import com.rpc.dubbo.api.entity.Address;
import com.rpc.dubbo.api.service.AddressService;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

/**
 * @author xl-9527
 * @since 2025/1/20
 **/
@Service
@DubboService(protocol = "triple")
public class AddressServiceImpl implements AddressService {

    private static final Logger log = LoggerFactory.getLogger(AddressServiceImpl.class);

    private final Random random = new Random();

    @Override
    public List<Address> queryList() {
        log.info("queryList -> {}", LocalDateTime.now().getNano());
        return List.of(new Address(random.nextInt(), "xl-9527"));
    }
}
