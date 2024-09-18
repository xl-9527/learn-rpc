package rpc.hessian.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rpc.hessian.service.UserService;
import rpc.hessian.service.bo.User;

/**
 * @author xl-9527
 * @since 2024/9/19
 **/
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public boolean login(final String username, final String password) {
        log.debug("login method invoke username is {}, password is {}", username, password);
        return false;
    }

    @Override
    public void register(final User user) {
        log.debug("register method invoke user is {}", user);
    }
}
