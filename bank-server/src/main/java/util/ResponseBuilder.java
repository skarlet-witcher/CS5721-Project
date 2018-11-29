package util;

import Const.ResponseStatusType;
import rpc.Response;

public class ResponseBuilder {
    public static Response.Builder getSuccessBuilder() {
        return Response.newBuilder().setStatusCode(ResponseStatusType.SUCCESS);
    }

    public static Response.Builder getFailBuilder() {
        return Response.newBuilder()
                .setStatusCode(ResponseStatusType.OPERATION_FAIL);
    }

    public static Response.Builder getFailBuilder(String description) {
        if (description == null) {
            return getFailBuilder();
        }
        return Response.newBuilder()
                .setStatusCode(ResponseStatusType.OPERATION_FAIL)
                .setDescription(description);
    }

    public static Response.Builder getFailBuilder(Integer statusType, String description) {
        if (description == null) {
            return getFailBuilder();
        }
        if (statusType == null) {
            return getFailBuilder(description);
        }
        return Response.newBuilder()
                .setStatusCode(statusType)
                .setDescription(description);
    }
}
