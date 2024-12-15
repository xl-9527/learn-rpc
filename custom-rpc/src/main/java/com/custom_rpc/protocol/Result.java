package com.custom_rpc.protocol;

import lombok.Data;

/**
 * @author xl-9527
 * @since 2024/12/15
 **/
@Data
public class Result implements Protocol {

    private Object resultValue;

    private Exception exception;
}
