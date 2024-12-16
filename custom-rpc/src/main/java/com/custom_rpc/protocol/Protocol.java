package com.custom_rpc.protocol;

import java.io.Serializable;

/**
 * @author xl-9527
 * @since 2024/12/15
 **/
public interface Protocol extends Serializable {

    /* 魔术 9b */
    String MAGIC_NUMBER = "CUSTOM_RPC";
    /* 协议版本 1b */
    byte PROTOCOL_VERSION = 1;
}
