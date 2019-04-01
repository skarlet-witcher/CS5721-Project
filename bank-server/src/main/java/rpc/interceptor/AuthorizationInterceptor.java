package rpc.interceptor;

import Const.Server;
import io.grpc.*;
import io.jsonwebtoken.Jws;
import util.JWTUtil;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Server Concrete Interceptor
 * Responsibility:
 * 1) Implement a specific out-of-band (additional) service
 * 2) Use context object to control GRPC framework
 */
public class AuthorizationInterceptor implements ServerInterceptor {
    private static final Logger logger = Logger.getLogger(AuthorizationInterceptor.class.getName());
    //permitted methods which are not intercepted
    private final List<String> permitMethod = Arrays.asList(
            "rpc.UserCustomerLogin/LoginReq",
            "rpc.UserCustomerLogin/Login",
            "rpc.UserCustomerLogin/ApplyNewAccount",
            "rpc.UserCustomerLogin/ValidateExistingUser",
            "rpc.UserCustomerLogin/ForgetUserId",
            "rpc.UserCustomerLogin/ForgetPin",
            "rpc.BankStaffLogin/StaffLogin",
            "rpc.ATMWithdraw/ATMWithDraw",
            "rpc.ATMWithdraw/ATMGetBalance"
    );

    /**
     * Callback method, using Header as a context object
     * @param call : method callback when event occurs
     * @param headers: Context object containing JWT token for obtaining state of users
     * @param next : next callback if available
     */
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call,
                                          Metadata headers, ServerCallHandler<ReqT, RespT> next) {
        String fullMethodName = call.getMethodDescriptor().getFullMethodName();

        if (permitMethod.contains(fullMethodName)) {
            logger.info("request from " + fullMethodName + " permitted without validation.");
            return next.startCall(call, headers);
        }

        String token = headers.get(Server.JWT_METADATA_KEY);
        try{
            checkToken(token);
        }catch (Exception e){
            logger.info("request from " + fullMethodName + " with token " + token + " rejected because "+e.getMessage());

            call.close(Status.UNAUTHENTICATED.withDescription(e.getMessage()), headers);
            return new ServerCall.Listener<>() {};
        }

        logger.info("request from " + fullMethodName + "with token " + token + " permitted.");
        return next.startCall(call, headers);
    }

    private Jws checkToken(String token) {
        return JWTUtil.verifyJWTToken(token);
    }
}
