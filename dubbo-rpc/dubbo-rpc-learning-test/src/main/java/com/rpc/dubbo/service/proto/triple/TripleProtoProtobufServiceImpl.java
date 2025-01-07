package com.rpc.dubbo.service.proto.triple;

import com.rpc.dubbo.api.proto.DubboTripleGrpcProtocolServiceTriple;
import com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO;
import com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO;
import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xl-9527
 * @since 2025/1/7
 **/
@DubboService(protocol = "tri")
public class TripleProtoProtobufServiceImpl extends DubboTripleGrpcProtocolServiceTriple.TripleGrpcProtocolServiceImplBase {

    private final Logger log = LoggerFactory.getLogger(TripleProtoProtobufServiceImpl.class);

    @Override
    public void testTripleGrpcProtocolService(final TripleGrpcProtocolServiceDTO request, final StreamObserver<TripleGrpcProtocolServiceVO> responseObserver) {
        log.info("request name : {}", request.getName());
        try {
            responseObserver.onNext(TripleGrpcProtocolServiceVO.newBuilder().setName("hello " + request.getName()).build());
        } catch (Exception e) {
            log.error("error", e);
            responseObserver.onError(e);
        } finally {
            responseObserver.onCompleted();
        }
    }
}
