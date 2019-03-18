package rpc.interceptor;

import io.grpc.ServerInterceptor;

import java.util.Vector;

public class ServerRpcDispatcher {
    private static Vector<ServerInterceptor> interceptors;

    public static void register(ServerInterceptor interceptor) {
        interceptors.addElement(interceptor);
    }

    public static void remove(ServerInterceptor interceptor) {
        interceptors.removeElement(interceptor);
    }

    public static ServerInterceptor[] getInterceptors() {
        return interceptors.toArray(ServerInterceptor[]::new);
    }
}
