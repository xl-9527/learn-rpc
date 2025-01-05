package com.rpc.dubbo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author xl-9527
 * @since 2025/1/5
 **/
@RequestMapping("/restful")
public interface RestfulProtocolService {

    @GetMapping("/getData")
    Map<String, Object> getData();
}
