package com.rpc.service;

import com.rpc.thrift.User;
import com.rpc.thrift.UserService;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xl-9527
 * @since 2024/9/22
 **/
public class UserServiceImpl implements UserService.Iface {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User queryUserByNameAndPassword(final String username, final String password) throws TException {
        log.info("name is {}, password is {}", username, password);
        return new User("Hello", "1325695548");
    }

    @Override
    public void save(final User user) throws TException {
        log.info("save user {}, user.name is {}, user.password is {}", user, user.getUsername(), user.getPassword());
    }
}
