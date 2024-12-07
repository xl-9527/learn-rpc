package serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xl-9527
 * @since 2024/12/5
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SerializableUser implements Serializable {

    private String username;
}
