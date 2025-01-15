package com.rpc.dubbo.source.service;

import com.rpc.dubbo.source.entity.User;

/**
 * @author xl-9527
 * @since 2025/1/15
 **/
public interface UserService {

    String getUserName();

    User getUserById(int userId);
}
