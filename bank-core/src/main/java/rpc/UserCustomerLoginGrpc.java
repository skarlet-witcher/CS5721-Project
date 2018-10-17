package rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.15.1)",
        comments = "Source: Bank.proto")
public final class UserCustomerLoginGrpc {

    public static final String SERVICE_NAME = "rpc.UserCustomerLogin";
    private static final int METHODID_LOGIN_REQ = 0;
    private static final int METHODID_LOGIN = 1;
    private static final int METHODID_APPLY_NEW_ACCOUNT = 2;
    private static final int METHODID_FORGET_USER_ID = 3;
    private static final int METHODID_FORGET_PIN = 4;
    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<UserLoginReqRequest,
            Response> getLoginReqMethod;
    private static volatile io.grpc.MethodDescriptor<UserLoginRequest,
            Response> getLoginMethod;
    private static volatile io.grpc.MethodDescriptor<UserApplyNewAccountRequest,
            Response> getApplyNewAccountMethod;
    private static volatile io.grpc.MethodDescriptor<UserForgetUserIdRequest,
            Response> getForgetUserIdMethod;
    private static volatile io.grpc.MethodDescriptor<UserForgetPinRequest,
            Response> getForgetPinMethod;
    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    private UserCustomerLoginGrpc() {
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "LoginReq",
            requestType = UserLoginReqRequest.class,
            responseType = Response.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<UserLoginReqRequest,
            Response> getLoginReqMethod() {
        io.grpc.MethodDescriptor<UserLoginReqRequest, Response> getLoginReqMethod;
        if ((getLoginReqMethod = UserCustomerLoginGrpc.getLoginReqMethod) == null) {
            synchronized (UserCustomerLoginGrpc.class) {
                if ((getLoginReqMethod = UserCustomerLoginGrpc.getLoginReqMethod) == null) {
                    UserCustomerLoginGrpc.getLoginReqMethod = getLoginReqMethod =
                            io.grpc.MethodDescriptor.<UserLoginReqRequest, Response>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "rpc.UserCustomerLogin", "LoginReq"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            UserLoginReqRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Response.getDefaultInstance()))
                                    .setSchemaDescriptor(new UserCustomerLoginMethodDescriptorSupplier("LoginReq"))
                                    .build();
                }
            }
        }
        return getLoginReqMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "Login",
            requestType = UserLoginRequest.class,
            responseType = Response.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<UserLoginRequest,
            Response> getLoginMethod() {
        io.grpc.MethodDescriptor<UserLoginRequest, Response> getLoginMethod;
        if ((getLoginMethod = UserCustomerLoginGrpc.getLoginMethod) == null) {
            synchronized (UserCustomerLoginGrpc.class) {
                if ((getLoginMethod = UserCustomerLoginGrpc.getLoginMethod) == null) {
                    UserCustomerLoginGrpc.getLoginMethod = getLoginMethod =
                            io.grpc.MethodDescriptor.<UserLoginRequest, Response>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "rpc.UserCustomerLogin", "Login"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            UserLoginRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Response.getDefaultInstance()))
                                    .setSchemaDescriptor(new UserCustomerLoginMethodDescriptorSupplier("Login"))
                                    .build();
                }
            }
        }
        return getLoginMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "ApplyNewAccount",
            requestType = UserApplyNewAccountRequest.class,
            responseType = Response.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<UserApplyNewAccountRequest,
            Response> getApplyNewAccountMethod() {
        io.grpc.MethodDescriptor<UserApplyNewAccountRequest, Response> getApplyNewAccountMethod;
        if ((getApplyNewAccountMethod = UserCustomerLoginGrpc.getApplyNewAccountMethod) == null) {
            synchronized (UserCustomerLoginGrpc.class) {
                if ((getApplyNewAccountMethod = UserCustomerLoginGrpc.getApplyNewAccountMethod) == null) {
                    UserCustomerLoginGrpc.getApplyNewAccountMethod = getApplyNewAccountMethod =
                            io.grpc.MethodDescriptor.<UserApplyNewAccountRequest, Response>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "rpc.UserCustomerLogin", "ApplyNewAccount"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            UserApplyNewAccountRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Response.getDefaultInstance()))
                                    .setSchemaDescriptor(new UserCustomerLoginMethodDescriptorSupplier("ApplyNewAccount"))
                                    .build();
                }
            }
        }
        return getApplyNewAccountMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "ForgetUserId",
            requestType = UserForgetUserIdRequest.class,
            responseType = Response.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<UserForgetUserIdRequest,
            Response> getForgetUserIdMethod() {
        io.grpc.MethodDescriptor<UserForgetUserIdRequest, Response> getForgetUserIdMethod;
        if ((getForgetUserIdMethod = UserCustomerLoginGrpc.getForgetUserIdMethod) == null) {
            synchronized (UserCustomerLoginGrpc.class) {
                if ((getForgetUserIdMethod = UserCustomerLoginGrpc.getForgetUserIdMethod) == null) {
                    UserCustomerLoginGrpc.getForgetUserIdMethod = getForgetUserIdMethod =
                            io.grpc.MethodDescriptor.<UserForgetUserIdRequest, Response>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "rpc.UserCustomerLogin", "ForgetUserId"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            UserForgetUserIdRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Response.getDefaultInstance()))
                                    .setSchemaDescriptor(new UserCustomerLoginMethodDescriptorSupplier("ForgetUserId"))
                                    .build();
                }
            }
        }
        return getForgetUserIdMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "ForgetPin",
            requestType = UserForgetPinRequest.class,
            responseType = Response.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<UserForgetPinRequest,
            Response> getForgetPinMethod() {
        io.grpc.MethodDescriptor<UserForgetPinRequest, Response> getForgetPinMethod;
        if ((getForgetPinMethod = UserCustomerLoginGrpc.getForgetPinMethod) == null) {
            synchronized (UserCustomerLoginGrpc.class) {
                if ((getForgetPinMethod = UserCustomerLoginGrpc.getForgetPinMethod) == null) {
                    UserCustomerLoginGrpc.getForgetPinMethod = getForgetPinMethod =
                            io.grpc.MethodDescriptor.<UserForgetPinRequest, Response>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "rpc.UserCustomerLogin", "ForgetPin"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            UserForgetPinRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Response.getDefaultInstance()))
                                    .setSchemaDescriptor(new UserCustomerLoginMethodDescriptorSupplier("ForgetPin"))
                                    .build();
                }
            }
        }
        return getForgetPinMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static UserCustomerLoginStub newStub(io.grpc.Channel channel) {
        return new UserCustomerLoginStub(channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static UserCustomerLoginBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        return new UserCustomerLoginBlockingStub(channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static UserCustomerLoginFutureStub newFutureStub(
            io.grpc.Channel channel) {
        return new UserCustomerLoginFutureStub(channel);
    }

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (UserCustomerLoginGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new UserCustomerLoginFileDescriptorSupplier())
                            .addMethod(getLoginReqMethod())
                            .addMethod(getLoginMethod())
                            .addMethod(getApplyNewAccountMethod())
                            .addMethod(getForgetUserIdMethod())
                            .addMethod(getForgetPinMethod())
                            .build();
                }
            }
        }
        return result;
    }

    /**
     */
    public static abstract class UserCustomerLoginImplBase implements io.grpc.BindableService {

        /**
         */
        public void loginReq(UserLoginReqRequest request,
                             io.grpc.stub.StreamObserver<Response> responseObserver) {
            asyncUnimplementedUnaryCall(getLoginReqMethod(), responseObserver);
        }

        /**
         */
        public void login(UserLoginRequest request,
                          io.grpc.stub.StreamObserver<Response> responseObserver) {
            asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
        }

        /**
         */
        public void applyNewAccount(UserApplyNewAccountRequest request,
                                    io.grpc.stub.StreamObserver<Response> responseObserver) {
            asyncUnimplementedUnaryCall(getApplyNewAccountMethod(), responseObserver);
        }

        /**
         */
        public void forgetUserId(UserForgetUserIdRequest request,
                                 io.grpc.stub.StreamObserver<Response> responseObserver) {
            asyncUnimplementedUnaryCall(getForgetUserIdMethod(), responseObserver);
        }

        /**
         */
        public void forgetPin(UserForgetPinRequest request,
                              io.grpc.stub.StreamObserver<Response> responseObserver) {
            asyncUnimplementedUnaryCall(getForgetPinMethod(), responseObserver);
        }

        @Override
        public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            getLoginReqMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            UserLoginReqRequest,
                                            Response>(
                                            this, METHODID_LOGIN_REQ)))
                    .addMethod(
                            getLoginMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            UserLoginRequest,
                                            Response>(
                                            this, METHODID_LOGIN)))
                    .addMethod(
                            getApplyNewAccountMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            UserApplyNewAccountRequest,
                                            Response>(
                                            this, METHODID_APPLY_NEW_ACCOUNT)))
                    .addMethod(
                            getForgetUserIdMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            UserForgetUserIdRequest,
                                            Response>(
                                            this, METHODID_FORGET_USER_ID)))
                    .addMethod(
                            getForgetPinMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            UserForgetPinRequest,
                                            Response>(
                                            this, METHODID_FORGET_PIN)))
                    .build();
        }
    }

    /**
     */
    public static final class UserCustomerLoginStub extends io.grpc.stub.AbstractStub<UserCustomerLoginStub> {
        private UserCustomerLoginStub(io.grpc.Channel channel) {
            super(channel);
        }

        private UserCustomerLoginStub(io.grpc.Channel channel,
                                      io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override
        protected UserCustomerLoginStub build(io.grpc.Channel channel,
                                              io.grpc.CallOptions callOptions) {
            return new UserCustomerLoginStub(channel, callOptions);
        }

        /**
         */
        public void loginReq(UserLoginReqRequest request,
                             io.grpc.stub.StreamObserver<Response> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getLoginReqMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void login(UserLoginRequest request,
                          io.grpc.stub.StreamObserver<Response> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void applyNewAccount(UserApplyNewAccountRequest request,
                                    io.grpc.stub.StreamObserver<Response> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getApplyNewAccountMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void forgetUserId(UserForgetUserIdRequest request,
                                 io.grpc.stub.StreamObserver<Response> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getForgetUserIdMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void forgetPin(UserForgetPinRequest request,
                              io.grpc.stub.StreamObserver<Response> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getForgetPinMethod(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     */
    public static final class UserCustomerLoginBlockingStub extends io.grpc.stub.AbstractStub<UserCustomerLoginBlockingStub> {
        private UserCustomerLoginBlockingStub(io.grpc.Channel channel) {
            super(channel);
        }

        private UserCustomerLoginBlockingStub(io.grpc.Channel channel,
                                              io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override
        protected UserCustomerLoginBlockingStub build(io.grpc.Channel channel,
                                                      io.grpc.CallOptions callOptions) {
            return new UserCustomerLoginBlockingStub(channel, callOptions);
        }

        /**
         */
        public Response loginReq(UserLoginReqRequest request) {
            return blockingUnaryCall(
                    getChannel(), getLoginReqMethod(), getCallOptions(), request);
        }

        /**
         */
        public Response login(UserLoginRequest request) {
            return blockingUnaryCall(
                    getChannel(), getLoginMethod(), getCallOptions(), request);
        }

        /**
         */
        public Response applyNewAccount(UserApplyNewAccountRequest request) {
            return blockingUnaryCall(
                    getChannel(), getApplyNewAccountMethod(), getCallOptions(), request);
        }

        /**
         */
        public Response forgetUserId(UserForgetUserIdRequest request) {
            return blockingUnaryCall(
                    getChannel(), getForgetUserIdMethod(), getCallOptions(), request);
        }

        /**
         */
        public Response forgetPin(UserForgetPinRequest request) {
            return blockingUnaryCall(
                    getChannel(), getForgetPinMethod(), getCallOptions(), request);
        }
    }

    /**
     */
    public static final class UserCustomerLoginFutureStub extends io.grpc.stub.AbstractStub<UserCustomerLoginFutureStub> {
        private UserCustomerLoginFutureStub(io.grpc.Channel channel) {
            super(channel);
        }

        private UserCustomerLoginFutureStub(io.grpc.Channel channel,
                                            io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override
        protected UserCustomerLoginFutureStub build(io.grpc.Channel channel,
                                                    io.grpc.CallOptions callOptions) {
            return new UserCustomerLoginFutureStub(channel, callOptions);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<Response> loginReq(
                UserLoginReqRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getLoginReqMethod(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<Response> login(
                UserLoginRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getLoginMethod(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<Response> applyNewAccount(
                UserApplyNewAccountRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getApplyNewAccountMethod(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<Response> forgetUserId(
                UserForgetUserIdRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getForgetUserIdMethod(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<Response> forgetPin(
                UserForgetPinRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getForgetPinMethod(), getCallOptions()), request);
        }
    }

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final UserCustomerLoginImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(UserCustomerLoginImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @Override
        @SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_LOGIN_REQ:
                    serviceImpl.loginReq((UserLoginReqRequest) request,
                            (io.grpc.stub.StreamObserver<Response>) responseObserver);
                    break;
                case METHODID_LOGIN:
                    serviceImpl.login((UserLoginRequest) request,
                            (io.grpc.stub.StreamObserver<Response>) responseObserver);
                    break;
                case METHODID_APPLY_NEW_ACCOUNT:
                    serviceImpl.applyNewAccount((UserApplyNewAccountRequest) request,
                            (io.grpc.stub.StreamObserver<Response>) responseObserver);
                    break;
                case METHODID_FORGET_USER_ID:
                    serviceImpl.forgetUserId((UserForgetUserIdRequest) request,
                            (io.grpc.stub.StreamObserver<Response>) responseObserver);
                    break;
                case METHODID_FORGET_PIN:
                    serviceImpl.forgetPin((UserForgetPinRequest) request,
                            (io.grpc.stub.StreamObserver<Response>) responseObserver);
                    break;
                default:
                    throw new AssertionError();
            }
        }

        @Override
        @SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(
                io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new AssertionError();
            }
        }
    }

    private static abstract class UserCustomerLoginBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        UserCustomerLoginBaseDescriptorSupplier() {
        }

        @Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return BankProto.getDescriptor();
        }

        @Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("UserCustomerLogin");
        }
    }

    private static final class UserCustomerLoginFileDescriptorSupplier
            extends UserCustomerLoginBaseDescriptorSupplier {
        UserCustomerLoginFileDescriptorSupplier() {
        }
    }

    private static final class UserCustomerLoginMethodDescriptorSupplier
            extends UserCustomerLoginBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final String methodName;

        UserCustomerLoginMethodDescriptorSupplier(String methodName) {
            this.methodName = methodName;
        }

        @Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }
}
