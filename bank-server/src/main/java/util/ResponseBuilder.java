package util;

import rpc.Response;

public class ResponseBuilder {
    public static Response.Builder ResponseSuccessBuilder() {
        return Response.newBuilder().setStatusCode(200);
    }

    public static Response.Builder ResponseFailBuilder(String description) {
        return Response.newBuilder()
                .setStatusCode(400)
                .setDescription(description);
    }
}
