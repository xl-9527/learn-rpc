package com.rpc.dubbo.service.version;

import com.rpc.dubbo.api.version.VersionDubboService;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xl-9527
 * @since 2025/1/7
 **/
@DubboService(protocol = "tri", version = "1.0.0", group = "version", accesslog = "xl-9527")
public class VersionDubboService1Impl implements VersionDubboService {

    private static final Logger log = LoggerFactory.getLogger(VersionDubboService1Impl.class);

    @Override
    public String sayHello(final String name) {
        log.info("version one name is {}", name);
        return "1";
    }
}
