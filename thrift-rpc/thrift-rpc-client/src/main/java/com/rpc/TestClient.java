package com.rpc;

import com.rpc.thrift.User;
import com.rpc.thrift.UserService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * @author xl-9527
 * @since 2024/9/22
 **/
public class TestClient {

    public static void main(String[] args) {
        try (TTransport clientTransport = new TSocket("localhost", 9090)) {
            final TBinaryProtocol protocol = new TBinaryProtocol(clientTransport);
            clientTransport.open();
            final UserService.Client client = new UserService.Client(protocol);
            final User user = client.queryUserByNameAndPassword("nihao", "");
            System.out.println(user);
        } catch (TException e) {
            throw new RuntimeException(e);
        }
    }
}
