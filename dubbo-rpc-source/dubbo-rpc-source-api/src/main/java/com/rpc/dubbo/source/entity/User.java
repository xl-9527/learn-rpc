package com.rpc.dubbo.source.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xl-9527
 * @since 2025/1/15
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int userId;

    private String userName;
}
