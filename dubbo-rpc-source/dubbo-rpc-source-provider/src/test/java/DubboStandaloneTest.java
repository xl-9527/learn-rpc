import com.rpc.dubbo.source.service.UserService;
import com.rpc.dubbo.source.service.impl.UserServiceImpl;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.junit.jupiter.api.Test;

/**
 * @author xl-9527
 * @since 2025/1/26
 **/
public class DubboStandaloneTest {

    @Test
    void m1() {
        // 服务配置，主要是做基础的一些配置
        final ServiceConfig<UserServiceImpl> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(new UserServiceImpl());

        // dubbo 服务启动
        final DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        bootstrap.application(new ApplicationConfig("dubbo-rpc-source-provider"))
                .service(serviceConfig)
                .start().await();
    }
}
