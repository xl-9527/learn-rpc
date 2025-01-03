package com.rpc.dubbo.consumer.stub;

import com.rpc.dubbo.api.grpc.User;
import com.rpc.dubbo.api.grpc.UserRequest;
import com.rpc.dubbo.api.grpc.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author xl-9527
 * @since 2025/1/2
 **/
@Slf4j
@Service
@Profile("grpc")
public class UserStub implements InitializingBean {

    @DubboReference(protocol = "grpc")
    private UserService userService;


    public User getUserById(int userId) {
         return userService.queryUserById(UserRequest.newBuilder().setUserId(userId).build());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("UserStub init... {}", getUserById(1).getUsername());
    }
}
