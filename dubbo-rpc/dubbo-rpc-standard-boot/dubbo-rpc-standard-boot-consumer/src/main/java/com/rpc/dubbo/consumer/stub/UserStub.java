package com.rpc.dubbo.consumer.stub;

import com.rpc.dubbo.api.grpc.DubboUserServiceGrpc;
import com.rpc.dubbo.api.grpc.UserServiceProto;
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
    private DubboUserServiceGrpc.IUserService userService;


    public UserServiceProto.User getUserById(int userId) {
         return userService.queryUserById(UserServiceProto.UserRequest.newBuilder().setUserId(userId).build());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("UserStub init... {}", getUserById(1).getUsername());
    }
}
