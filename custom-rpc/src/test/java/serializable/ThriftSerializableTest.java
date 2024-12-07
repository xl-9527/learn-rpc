package serializable;

import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TIOStreamTransport;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author xl-9527
 * @since 2024/12/5
 **/
@Slf4j
public class ThriftSerializableTest {

    @Test
    public void doTestThriftSerializable() throws TException {
        final SerializableUser serializableUser = new SerializableUser("xl-9527");
        final com.rpc.custom_rpc.thrift.SerializableUser user =
                new com.rpc.custom_rpc.thrift.SerializableUser(serializableUser.getUsername());

        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final TBinaryProtocol tBinaryProtocol = new TBinaryProtocol(new TIOStreamTransport(byteArrayOutputStream));
        user.write(tBinaryProtocol);

        log.info("序列化后大小：{}", byteArrayOutputStream.size());

        /* 反序列化 */
        final TBinaryProtocol inProtocol =
                new TBinaryProtocol(new TIOStreamTransport(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())));
        final com.rpc.custom_rpc.thrift.SerializableUser newUser = new com.rpc.custom_rpc.thrift.SerializableUser();
        newUser.read(inProtocol);

        log.info("反序列化后：{}", newUser.getUsername());
    }
}
