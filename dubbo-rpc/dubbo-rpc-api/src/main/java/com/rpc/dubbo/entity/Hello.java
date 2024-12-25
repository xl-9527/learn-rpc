package com.rpc.dubbo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author xl-9527
 * @since 2024/12/24
 **/
@Getter
@Setter
@NoArgsConstructor
public class Hello implements Serializable {

    public Hello(final String value, final String username) {
        this.value = value;
        this.username = username;
    }

    private String value;
    private String username;

    @Override
    public String toString() {
        return "Hello{" +
                "value='" + value + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
