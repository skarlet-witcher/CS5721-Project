package app;

import io.grpc.ManagedChannel;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NegotiationType;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import view.StaffLoginView;

import javax.net.ssl.SSLException;
import javax.swing.*;
import java.io.File;

import static Const.Server.*;
import static Const.Server.CLIENT_PRIVATE_KEY;

public class StaffClient {
    private static ManagedChannel channel;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new StaffLoginView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ManagedChannel getChannel() throws SSLException {
        if (channel == null) {
            channel = NettyChannelBuilder.forAddress(SERVER_HOST, SERVER_PORT)
                    .negotiationType(NegotiationType.TLS)
                    .sslContext(GrpcSslContexts
                            .forClient()
                            .trustManager(new File(TRUST_CERT_COLLECTION))
                            .keyManager(new File(CLIENT_CERT_CHAIN), new File(CLIENT_PRIVATE_KEY))
                            .build())
                    .build();
        }
        return channel;
    }

}
