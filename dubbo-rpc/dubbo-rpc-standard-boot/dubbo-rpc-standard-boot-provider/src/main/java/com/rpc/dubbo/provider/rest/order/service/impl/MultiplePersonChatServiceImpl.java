package com.rpc.dubbo.provider.rest.order.service.impl;

import com.rpc.dubbo.api.triple.service.MultiplePersonChatService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.context.annotation.Profile;

/**
 * @author xl-9527
 * @since 2025/1/5
 **/
@Profile("tri")
@DubboService(protocol = {"rest", "tri"})
public class MultiplePersonChatServiceImpl implements MultiplePersonChatService {

    @Override
    public String startChat(final String message) {
        return "tri：" + message;
    }

    @Override
    public void sendMessage(final String message) {
        System.out.println("restful：" + message);
    }
}
