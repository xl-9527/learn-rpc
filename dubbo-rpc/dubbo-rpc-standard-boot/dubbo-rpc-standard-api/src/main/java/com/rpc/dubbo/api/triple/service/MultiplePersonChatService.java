package com.rpc.dubbo.api.triple.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这里多协议我们使用 triple + restful
 *
 * @author xl-9527
 * @since 2025/1/5
 **/
@RestController
@RequestMapping("/multiple")
public interface MultiplePersonChatService {

    /**
     * tri protocol
     *
     * @param message receive msg
     * @return send message
     */
    String startChat(String message);

    /**
     * restful protocol
     *
     * @param message send message
     */
    @GetMapping("/sendMessage")
    void sendMessage(@RequestParam("message") String message);
}
