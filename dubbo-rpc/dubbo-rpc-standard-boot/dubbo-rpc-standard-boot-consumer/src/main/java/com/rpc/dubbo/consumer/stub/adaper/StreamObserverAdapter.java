package com.rpc.dubbo.consumer.stub.adaper;


import io.grpc.stub.StreamObserver;

/**
 * @author xl-9527
 * @since 2025/1/4
 **/
public class StreamObserverAdapter<T> implements StreamObserver<T> {

    private final org.apache.dubbo.common.stream.StreamObserver<T> dubboStreamObserver;

    public StreamObserverAdapter(final org.apache.dubbo.common.stream.StreamObserver<T> dubboStreamObserver) {
        this.dubboStreamObserver = dubboStreamObserver;
    }

    @Override
    public void onNext(final T value) {
        dubboStreamObserver.onNext(value);
    }

    @Override
    public void onError(final Throwable t) {
        dubboStreamObserver.onError(t);
    }

    @Override
    public void onCompleted() {
        dubboStreamObserver.onCompleted();
    }
}
