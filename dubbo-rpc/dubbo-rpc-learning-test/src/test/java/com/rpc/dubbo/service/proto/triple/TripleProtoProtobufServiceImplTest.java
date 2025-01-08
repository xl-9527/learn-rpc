package com.rpc.dubbo.service.proto.triple;

import com.rpc.dubbo.api.proto.TripleGrpcProtocolService;
import com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO;
import com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author xl-9527
 * @since 2025/1/7
 **/
@SpringBootTest
@ActiveProfiles("test")
class TripleProtoProtobufServiceImplTest {

    private static final Logger log = LoggerFactory.getLogger(TripleProtoProtobufServiceImplTest.class);

    @DubboReference(protocol = "grpc", providedBy = "dubbo-rpc-learning-test")
    private TripleGrpcProtocolService tripleGrpcProtocolService;

    @Test
    void testTripleGrpcProtocolService() {
        TripleGrpcProtocolServiceVO tripleGrpcProtocolServiceVO = tripleGrpcProtocolService.testTripleGrpcProtocolService(TripleGrpcProtocolServiceDTO.newBuilder().setName("xl-9527").build());
        log.info("response name : {}", tripleGrpcProtocolServiceVO.getName());
    }
}
