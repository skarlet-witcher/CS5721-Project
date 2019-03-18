package rpc.interceptor;

import io.grpc.*;
import io.grpc.netty.shaded.io.netty.util.internal.StringUtil;

public class AuthorityInterceptor implements ClientInterceptor {
    public static String jwtToken;

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
            MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
        return new ForwardingClientCall.SimpleForwardingClientCall<>((next.newCall(method, callOptions))) {

            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                if (!StringUtil.isNullOrEmpty(jwtToken)) {
                    headers.put(Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER),
                            "Bearer " + jwtToken);
                }
                super.start(responseListener, headers);
            }
        };
    }
}
