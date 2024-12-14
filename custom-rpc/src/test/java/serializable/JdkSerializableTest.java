package serializable;

import com.rpc.pre.bean.SerializableUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author xl-9527
 * @since 2024/12/4
 **/
@Slf4j
public class JdkSerializableTest {

    @Test
    public void testJdkSerializable() {
        final SerializableUser serializableUser = new SerializableUser("xl-9527");
        try (
                final ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
                final ObjectOutputStream outputStream = new ObjectOutputStream(arrayOutputStream)
        ) {
            outputStream.writeObject(serializableUser);
            log.info("serializableUser use jdk serializable size is {}", arrayOutputStream.size());

            // test un serializable
            final byte[] bytes = arrayOutputStream.toByteArray();
            try (ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(bytes))) {
                final Object object = inputStream.readObject();
                if (object instanceof SerializableUser user) {
                    log.info("user name is {}", user.getUsername());
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
