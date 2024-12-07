package serializable;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.rpc.biz.bean.SerializableUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author xl-9527
 * @since 2024/12/5
 **/
@Slf4j
public class HessianSerializableTest {

    @Test
    public void doTestHessianSerializable() {
        final SerializableUser serializableUser = new SerializableUser("xl-9527");

        try {
            final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            final Hessian2Output hessian2Output = new Hessian2Output(outputStream);
            hessian2Output.writeObject(serializableUser);
            hessian2Output.flush();

            log.info("序列化后的字节数组：{}", outputStream.size());

            final Hessian2Input hessian2Input = new Hessian2Input(new ByteArrayInputStream(outputStream.toByteArray()));
            final Object object = hessian2Input.readObject();
            if (object instanceof SerializableUser user) {
                log.info(user.getUsername());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
