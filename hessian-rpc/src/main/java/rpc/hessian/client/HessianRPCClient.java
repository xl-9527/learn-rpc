package rpc.hessian.client;

import com.caucho.hessian.client.HessianProxyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rpc.hessian.service.UserService;
import rpc.hessian.service.bo.User;

import java.net.MalformedURLException;

/**
 * @author xl-9527
 * @since 2024/9/19
 **/
public class HessianRPCClient {
    private static final HessianProxyFactory HESSIAN_PROXY_FACTORY = new HessianProxyFactory();

    private static final Logger log = LoggerFactory.getLogger(HessianRPCClient.class);

    public static void main(String[] args) throws MalformedURLException {
        final HessianUserStub userStub = new HessianUserStub();
        final boolean logined = userStub.login("你好", "123456");
        log.debug("logined: {}", logined);
    }

    /**
     * user stub
     */
    private static class HessianUserStub implements UserService {
        private final UserService stub = (UserService) HESSIAN_PROXY_FACTORY
                .create(UserService.class, "http://localhost:8080/hessian-rpc/rpc/user");

        public HessianUserStub() throws MalformedURLException {
        }

        @Override
        public boolean login(final String username, final String password) {
            return stub.login(username, password);
        }

        @Override
        public void register(final User user) {
            stub.register(user);
        }
    }
}
