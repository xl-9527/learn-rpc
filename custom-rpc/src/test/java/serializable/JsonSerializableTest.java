package serializable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author xl-9527
 * @since 2024/12/7
 **/
@Slf4j
public class JsonSerializableTest {

    @Test
    public void doTestJsonSerializable() throws IOException {
        final SerializableUser serializableUser = new SerializableUser("xl-9527");

        final ObjectMapper mapper = new ObjectMapper();
        final String jsonStr = mapper.writeValueAsString(serializableUser);

        final byte[] bytes = jsonStr.getBytes(StandardCharsets.UTF_8);
        log.info("jsonStr byte size: {}", bytes.length);

        // 反序列化
        final SerializableUser newSerializableUser = mapper.readValue(bytes , SerializableUser.class);
        log.info("newSerializableUser user name is : {}", newSerializableUser.getUsername());
    }
}
