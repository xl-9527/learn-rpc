package com.custom_rpc.serializable;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.custom_rpc.protocol.Protocol;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author xl-9527
 * @since 2024/12/16
 **/
public class HessianSerializationImpl implements Serialization {

    @Override
    public byte[] serialization(final Protocol protocol) {
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final Hessian2Output hessian2Output = new Hessian2Output(outputStream);
        try {
            hessian2Output.writeObject(protocol);
            hessian2Output.flush();
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Protocol deserialization(final byte[] bytes) {
        final ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
        final Hessian2Input hessian2Input = new Hessian2Input(stream);
        try {
            return (Protocol) hessian2Input.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
