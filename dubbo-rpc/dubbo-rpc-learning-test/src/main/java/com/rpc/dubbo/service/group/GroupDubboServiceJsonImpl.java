package com.rpc.dubbo.service.group;

import com.rpc.dubbo.api.group.GroupDubboService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author xl-9527
 * @since 2025/1/7
 **/
@DubboService(group = "json", protocol = "tri")
public class GroupDubboServiceJsonImpl implements GroupDubboService {
    @Override
    public String sayHello(final String name) {
        return "{'bean': '你好'}";
    }
}
