package com.rpc.dubbo.service;

import com.rpc.dubbo.api.DubboProtocolService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.UUID;

/**
 * @author xl-9527
 * @since 2025/1/5
 **/
@DubboService(protocol = "dubbo")
public class DubboProtocolServiceImpl implements DubboProtocolService {

    @Override
    public String test(final String req) {
        return "response：" + req + UUID.randomUUID();
    }
}
