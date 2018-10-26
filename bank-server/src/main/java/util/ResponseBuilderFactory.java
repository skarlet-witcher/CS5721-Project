package util;

import Const.ResponseStatusType;
import rpc.Response;

public class ResponseBuilderFactory {
    public static Response.Builder ResponseSuccessBuilder() {
        return Response.newBuilder().setStatusCode(ResponseStatusType.SUCCESS);
    }

    public static Response.Builder ResponseFailBuilder(String description) {
        return Response.newBuilder()
                .setStatusCode(ResponseStatusType.OPERATION_FAIL)
                .setDescription(description);
    }

    public static Response.Builder ResponseFailBuilder(Integer statusType, String description) {
        return Response.newBuilder()
                .setStatusCode(statusType)
                .setDescription(description);
    }
}
