package rpc.hessian.service.bo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author xl-9527
 * @since 2024/9/19
 **/
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {

    public User(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
