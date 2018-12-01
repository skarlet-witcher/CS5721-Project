package Const;

public class Server {
    public static final String SERVER_HOST = "ec2-52-204-41-200.compute-1.amazonaws.com";
    public static final int SERVER_PORT = 7777;
    public static final String SERVER_PRIVATE_KEY = "cert/server.pem";
    public static final String SERVER_CERT_CHAIN_LOCAL = "cert/server-local.crt";
    public static final String SERVER_CERT_CHAIN = "cert/server.crt";
    public static final String CLIENT_PRIVATE_KEY = "cert/client.pem";
    public static final String CLIENT_CERT_CHAIN = "cert/client.crt";
    public static final String TRUST_CERT_COLLECTION = "cert/ca.crt";
}
