package rpc.client;

import io.grpc.ManagedChannel;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NegotiationType;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import rpc.interceptor.AuthorityInterceptor;
import rpc.interceptor.ClientRpcDispatcher;
import rpc.interceptor.TestInterceptor;

import javax.net.ssl.SSLException;
import java.io.File;

import static Const.Server.*;

public abstract class ClientRpc {
    private static ManagedChannel channel;

    public static ManagedChannel getChannel() throws SSLException {
        ClientRpcDispatcher.register(new TestInterceptor());
        ClientRpcDispatcher.register(new AuthorityInterceptor());

        if (channel == null) {
            channel = NettyChannelBuilder.forAddress(SERVER_HOST, SERVER_PORT)
                    .negotiationType(NegotiationType.TLS)
                    .sslContext(GrpcSslContexts
                            .forClient()
                            .trustManager(new File(TRUST_CERT_COLLECTION))
                            .keyManager(new File(CLIENT_CERT_CHAIN), new File(CLIENT_PRIVATE_KEY))
                            .build())
                    .intercept(ClientRpcDispatcher.getInterceptors())
                    .build();
        }
        return channel;
    }
}
