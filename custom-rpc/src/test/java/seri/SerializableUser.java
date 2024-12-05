package seri;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xl-9527
 * @since 2024/12/5
 **/
@Data
@AllArgsConstructor
public class SerializableUser implements Serializable {

    private String username;
}
