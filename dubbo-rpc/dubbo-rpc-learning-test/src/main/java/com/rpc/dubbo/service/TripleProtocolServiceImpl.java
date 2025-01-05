package com.rpc.dubbo.service;

import com.rpc.dubbo.api.TripleProtocolService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author xl-9527
 * @since 2025/1/5
 **/
@DubboService(protocol = "tri")
public class TripleProtocolServiceImpl implements TripleProtocolService {

    @Override
    public void testTriple() {
        System.out.println("我被调用了");
    }
}
