package com.rpc;

import com.rpc.service.UserServiceImpl;
import com.rpc.thrift.UserService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * @author xl-9527
 * @since 2024/9/22
 **/
public class TestServer {

    public static void main(String[] args) throws TTransportException {
        try (TServerTransport transport = new TServerSocket(9090)) {
            final UserService.Processor<UserService.Iface> processor = new UserService.Processor<>(new UserServiceImpl());
            final TSimpleServer server = new TSimpleServer(new TSimpleServer.Args(transport)
                    .protocolFactory(new TBinaryProtocol.Factory())
                    .processor(processor));
            // 启动服务
            server.serve();
        }
    }
}
