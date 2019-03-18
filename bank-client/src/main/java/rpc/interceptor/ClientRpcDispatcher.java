package rpc.interceptor;

import io.grpc.ClientInterceptor;

import java.util.Vector;

public class ClientRpcDispatcher {
    private static Vector<ClientInterceptor> interceptors;

    public static void register(ClientInterceptor interceptor) {
        if (interceptors == null) {
            interceptors = new Vector<>();
        }
        interceptors.addElement(interceptor);
    }

    public static void remove(ClientInterceptor interceptor) {
        interceptors.removeElement(interceptor);
    }

    public static ClientInterceptor[] getInterceptors() {
        return interceptors.toArray(ClientInterceptor[]::new);
    }
}
