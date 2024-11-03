package com.rpc;

import com.rpc.service.UserServiceImpl;
import com.rpc.thrift.UserService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.*;

/**
 * @author xl-9527
 * @since 2024/9/22
 **/
public class TestServer {

    public static void main(String[] args) throws TTransportException {
        // tSimpleServer();
        // tThreadPoolServer();
        // tNonBlockingServer();
        tThreadSelectorServer();
    }

    private static void tThreadSelectorServer() throws TTransportException {
        try (TNonblockingServerSocket serverSocket = new TNonblockingServerSocket(9090)) {
            serverSocket.accept();
            final TThreadedSelectorServer selectorServer = new TThreadedSelectorServer(
                    new TThreadedSelectorServer.Args(serverSocket)
                            .protocolFactory(new TCompactProtocol.Factory())
                            .processor(new UserService.Processor<>(new UserServiceImpl()))
            );
            selectorServer.serve();
        }
    }

    private static void tNonBlockingServer() throws TTransportException {
        try (final TNonblockingServerTransport framedTransport = new TNonblockingServerSocket(9090)) {
            final TNonblockingServer nonblockingServer = new TNonblockingServer(
                    new TNonblockingServer.Args(framedTransport)
                            .protocolFactory(new TCompactProtocol.Factory())
                            .processor(new UserService.Processor<>(new UserServiceImpl()))
            );
            framedTransport.accept();
            nonblockingServer.serve();
        }
    }

    private static void tThreadPoolServer() throws TTransportException {
        // TTransportFactory
        try (final TServerTransport serverTransport = new TServerSocket(9090)) {
            final TThreadPoolServer threadPoolServer = new TThreadPoolServer(
                    new TThreadPoolServer.Args(serverTransport)
                            .protocolFactory(new TBinaryProtocol.Factory())
                            .processor(new UserService.Processor<>(new UserServiceImpl()))
            );

            threadPoolServer.serve();
        }
    }

    private static void tSimpleServer() throws TTransportException {
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
