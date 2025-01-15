package com.rpc.dubbo.source.service.impl;

import com.rpc.dubbo.source.entity.User;
import com.rpc.dubbo.source.service.UserService;

/**
 * @author xl-9527
 * @since 2025/1/15
 **/
public class UserServiceImpl implements UserService {

    @Override
    public String getUserName() {
        return "xl-9527";
    }

    @Override
    public User getUserById(final int userId) {
        return null;
    }
}
