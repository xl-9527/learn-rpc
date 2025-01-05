package com.rpc.dubbo.service;

import com.rpc.dubbo.api.RestfulProtocolService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Map;

/**
 * @author xl-9527
 * @since 2025/1/5
 **/
@DubboService(protocol = "rest")
public class RestfulProtocolServiceImpl implements RestfulProtocolService {

    @Override
    public Map<String, Object> getData() {
        return Map.of("response", "OK");
    }
}
