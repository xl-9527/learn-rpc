package com.rpc.dubbo.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author xl-9527
 * @since 2024/12/24
 **/
@Getter
@Setter
public class Hello implements Serializable {

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
