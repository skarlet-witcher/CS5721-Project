package rpc.interceptor;

import io.grpc.*;

import java.util.logging.Logger;

public class TestInterceptor implements ClientInterceptor {
    private static final Logger logger = Logger.getLogger(TestInterceptor.class.getName());

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
            MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
        return new ForwardingClientCall.SimpleForwardingClientCall<>(next.newCall(method, callOptions)) {

            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                //headers.merge(extraHeaders);
                logger.info("TestInterceptor invoked");

                super.start(responseListener, headers);
            }
        };
    }
}
