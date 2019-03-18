package Const;

import io.grpc.Metadata;

public class Server {
    public static final String JWT_SECRETKEY = "NUCLEARNUCLEARNUCLEARNUCLEARNUCLEARNUCLEARNUCLEARNUCLEARNUCLEARNUCLEARNUCLEARNUCLEARNUCLEARNUCLEARNUCLEARNUCLEARNUCLEARNUCLEARNUCLEARNUCLEARNUCLEARNUCLEARNUCLEARNUCLEAR";
    public static final Metadata.Key<String> JWT_METADATA_KEY = Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER);
    public static final int SESSION_TIME = 3600000;
    public static final String SERVER_HOST = "localhost";
    public static final int SERVER_PORT = 7777;
    public static final String SERVER_PRIVATE_KEY = "cert/server.pem";
    public static final String SERVER_CERT_CHAIN_LOCAL = "cert/server-local.crt";
    public static final String SERVER_CERT_CHAIN = "cert/server.crt";
    public static final String CLIENT_PRIVATE_KEY = "cert/client.pem";
    public static final String CLIENT_CERT_CHAIN = "cert/client.crt";
    public static final String TRUST_CERT_COLLECTION = "cert/ca.crt";
}
