package rpc.interceptor;

import io.grpc.*;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener;
import io.grpc.netty.shaded.io.netty.util.internal.StringUtil;

import javax.swing.*;
import java.util.logging.Logger;

/**
 * CLient Concrete Interceptor
 * Responsibility:
 * 1) Implement a specific out-of-band (additional) service
 * 2) Use context object to control GRPC framework
 */
public class AuthorizationInterceptor implements ClientInterceptor {
    private static final Logger logger = Logger.getLogger(AuthorizationInterceptor.class.getName());

    public static String jwtToken;
    /**
     * Callback method, using Header as a context object
     */
    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
            MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
        return new SimpleForwardingClientCall<>(next.newCall(method, callOptions)) {

            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                if (!StringUtil.isNullOrEmpty(jwtToken)) {
                    headers.put(Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER),
                            jwtToken);
                }

                super.start(new SimpleForwardingClientCallListener<>(responseListener) {
                    @Override
                    public void onClose(Status status, Metadata trailers) {

                        if (status.getCode().equals(Status.Code.UNAUTHENTICATED)) {
                            JOptionPane.showMessageDialog(null,
                                    status.getDescription(),
                                    "Sorry", JOptionPane.WARNING_MESSAGE);
                            System.exit(0);
                        }
                        super.onClose(status, trailers);
                    }
                }, headers);
            }


        };
    }
}
