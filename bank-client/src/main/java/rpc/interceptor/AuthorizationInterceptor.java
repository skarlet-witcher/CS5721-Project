package rpc.interceptor;

import io.grpc.*;
import io.grpc.netty.shaded.io.netty.util.internal.StringUtil;
import rpc.Response;

public class AuthorizationInterceptor implements ClientInterceptor {
    public static String jwtToken;

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
            MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
        return new ForwardingClientCall.SimpleForwardingClientCall<>((next.newCall(method, callOptions))) {

            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                if (!StringUtil.isNullOrEmpty(jwtToken)) {
                    headers.put(Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER),
                            jwtToken);
                }

                super.start(new ForwardingClientCallListener.SimpleForwardingClientCallListener<>(responseListener) {
                    @Override
                    public void onMessage(RespT message) {
                        System.out.println(message);
                        System.out.println(((Response) message).getStatusCode());
                        super.onMessage(message);
                    }
                }, headers);
            }


        };
    }
}
