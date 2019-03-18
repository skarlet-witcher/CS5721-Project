package rpc.interceptor;

import Const.Server;
import io.grpc.*;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class AuthorizationInterceptor implements ServerInterceptor {
    private static final Logger logger = Logger.getLogger(AuthorizationInterceptor.class.getName());
    private final List<String> permitMethod = Arrays.asList(
            "rpc.UserCustomerLogin/LoginReq",
            "rpc.UserCustomerLogin/Login",
            "rpc.UserCustomerLogin/ApplyNewAccount",
            "rpc.UserCustomerLogin/ValidateExistingUser",
            "rpc.UserCustomerLogin/ForgetUserId",
            "rpc.UserCustomerLogin/ForgetPin",
            "rpc.BankStaffLogin/StaffLogin"
    );

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call,
                                                                 Metadata headers, ServerCallHandler<ReqT, RespT> next) {
        String fullMethodName = call.getMethodDescriptor().getFullMethodName();

        if (permitMethod.contains(fullMethodName)) {
            logger.info("request from " + fullMethodName + " permitted without validation.");
            return next.startCall(call, headers);
        }

        String token = headers.get(Server.JWT_METADATA_KEY);

        if (!checkToken(token)) {
            logger.info("request from " + fullMethodName + " with token " + token + " rejected.");

            call.close(Status.UNAUTHENTICATED.withDescription("Invalid Token"), headers);
            return new ServerCall.Listener<>() {
            };// noop_listener
        }

        logger.info("request from " + fullMethodName + "with token" + token + " permitted.");
        return next.startCall(call, headers);
    }

    private boolean checkToken(String token) {
        return true;
    }
}
