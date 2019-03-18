package rpc.interceptor;

import io.grpc.*;

public class TestInterceptor implements ClientInterceptor {

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
            MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
        return new ForwardingClientCall.SimpleForwardingClientCall<>(next.newCall(method, callOptions)) {

            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                //headers.merge(extraHeaders);
                System.out.println("TestInterceptor invoked");

                super.start(responseListener, headers);
            }
        };
    }
}
