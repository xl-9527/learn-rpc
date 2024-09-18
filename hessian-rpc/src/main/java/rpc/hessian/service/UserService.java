package rpc.hessian.service;

import rpc.hessian.service.bo.User;

/**
 * @author xl-9527
 * @since 2024/9/19
 **/
public interface UserService {

    boolean login(String username, String password);

    void register(User user);
}
