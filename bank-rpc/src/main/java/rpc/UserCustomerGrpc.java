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
        comments = "Source: customer.proto")
public final class UserCustomerGrpc {

    public static final String SERVICE_NAME = "rpc.UserCustomer";
    private static final int METHODID_EDIT_USER_PHONE = 0;
    private static final int METHODID_EDIT_USER_ADDRESS = 1;
    private static final int METHODID_GET_USER_TRANSACTION = 2;
    private static final int METHODID_GET_USER_OPERATE_LOG = 3;
    private static final int METHODID_MAKE_TRAN = 4;
    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<UserCustomerEditRequest,
            ReplyBaseOuterClass.ReplyBase> getEditUserPhoneMethod;
    private static volatile io.grpc.MethodDescriptor<UserCustomerEditRequest,
            ReplyBaseOuterClass.ReplyBase> getEditUserAddressMethod;
    private static volatile io.grpc.MethodDescriptor<UserRequestOuterClass.UserRequest,
            UserCustomerTransReply> getGetUserTransactionMethod;
    private static volatile io.grpc.MethodDescriptor<UserRequestOuterClass.UserRequest,
            UserCustomerLogsReply> getGetUserOperateLogMethod;
    private static volatile io.grpc.MethodDescriptor<UserCustomerTranRequest,
            ReplyBaseOuterClass.ReplyBase> getMakeTranMethod;
    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    private UserCustomerGrpc() {
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "EditUserPhone",
            requestType = UserCustomerEditRequest.class,
            responseType = ReplyBaseOuterClass.ReplyBase.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<UserCustomerEditRequest,
            ReplyBaseOuterClass.ReplyBase> getEditUserPhoneMethod() {
        io.grpc.MethodDescriptor<UserCustomerEditRequest, ReplyBaseOuterClass.ReplyBase> getEditUserPhoneMethod;
        if ((getEditUserPhoneMethod = UserCustomerGrpc.getEditUserPhoneMethod) == null) {
            synchronized (UserCustomerGrpc.class) {
                if ((getEditUserPhoneMethod = UserCustomerGrpc.getEditUserPhoneMethod) == null) {
                    UserCustomerGrpc.getEditUserPhoneMethod = getEditUserPhoneMethod =
                            io.grpc.MethodDescriptor.<UserCustomerEditRequest, ReplyBaseOuterClass.ReplyBase>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "rpc.UserCustomer", "EditUserPhone"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            UserCustomerEditRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            ReplyBaseOuterClass.ReplyBase.getDefaultInstance()))
                                    .setSchemaDescriptor(new UserCustomerMethodDescriptorSupplier("EditUserPhone"))
                                    .build();
                }
            }
        }
        return getEditUserPhoneMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "EditUserAddress",
            requestType = UserCustomerEditRequest.class,
            responseType = ReplyBaseOuterClass.ReplyBase.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<UserCustomerEditRequest,
            ReplyBaseOuterClass.ReplyBase> getEditUserAddressMethod() {
        io.grpc.MethodDescriptor<UserCustomerEditRequest, ReplyBaseOuterClass.ReplyBase> getEditUserAddressMethod;
        if ((getEditUserAddressMethod = UserCustomerGrpc.getEditUserAddressMethod) == null) {
            synchronized (UserCustomerGrpc.class) {
                if ((getEditUserAddressMethod = UserCustomerGrpc.getEditUserAddressMethod) == null) {
                    UserCustomerGrpc.getEditUserAddressMethod = getEditUserAddressMethod =
                            io.grpc.MethodDescriptor.<UserCustomerEditRequest, ReplyBaseOuterClass.ReplyBase>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "rpc.UserCustomer", "EditUserAddress"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            UserCustomerEditRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            ReplyBaseOuterClass.ReplyBase.getDefaultInstance()))
                                    .setSchemaDescriptor(new UserCustomerMethodDescriptorSupplier("EditUserAddress"))
                                    .build();
                }
            }
        }
        return getEditUserAddressMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "GetUserTransaction",
            requestType = UserRequestOuterClass.UserRequest.class,
            responseType = UserCustomerTransReply.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<UserRequestOuterClass.UserRequest,
            UserCustomerTransReply> getGetUserTransactionMethod() {
        io.grpc.MethodDescriptor<UserRequestOuterClass.UserRequest, UserCustomerTransReply> getGetUserTransactionMethod;
        if ((getGetUserTransactionMethod = UserCustomerGrpc.getGetUserTransactionMethod) == null) {
            synchronized (UserCustomerGrpc.class) {
                if ((getGetUserTransactionMethod = UserCustomerGrpc.getGetUserTransactionMethod) == null) {
                    UserCustomerGrpc.getGetUserTransactionMethod = getGetUserTransactionMethod =
                            io.grpc.MethodDescriptor.<UserRequestOuterClass.UserRequest, UserCustomerTransReply>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "rpc.UserCustomer", "GetUserTransaction"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            UserRequestOuterClass.UserRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            UserCustomerTransReply.getDefaultInstance()))
                                    .setSchemaDescriptor(new UserCustomerMethodDescriptorSupplier("GetUserTransaction"))
                                    .build();
                }
            }
        }
        return getGetUserTransactionMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "GetUserOperateLog",
            requestType = UserRequestOuterClass.UserRequest.class,
            responseType = UserCustomerLogsReply.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<UserRequestOuterClass.UserRequest,
            UserCustomerLogsReply> getGetUserOperateLogMethod() {
        io.grpc.MethodDescriptor<UserRequestOuterClass.UserRequest, UserCustomerLogsReply> getGetUserOperateLogMethod;
        if ((getGetUserOperateLogMethod = UserCustomerGrpc.getGetUserOperateLogMethod) == null) {
            synchronized (UserCustomerGrpc.class) {
                if ((getGetUserOperateLogMethod = UserCustomerGrpc.getGetUserOperateLogMethod) == null) {
                    UserCustomerGrpc.getGetUserOperateLogMethod = getGetUserOperateLogMethod =
                            io.grpc.MethodDescriptor.<UserRequestOuterClass.UserRequest, UserCustomerLogsReply>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "rpc.UserCustomer", "GetUserOperateLog"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            UserRequestOuterClass.UserRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            UserCustomerLogsReply.getDefaultInstance()))
                                    .setSchemaDescriptor(new UserCustomerMethodDescriptorSupplier("GetUserOperateLog"))
                                    .build();
                }
            }
        }
        return getGetUserOperateLogMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "MakeTran",
            requestType = UserCustomerTranRequest.class,
            responseType = ReplyBaseOuterClass.ReplyBase.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<UserCustomerTranRequest,
            ReplyBaseOuterClass.ReplyBase> getMakeTranMethod() {
        io.grpc.MethodDescriptor<UserCustomerTranRequest, ReplyBaseOuterClass.ReplyBase> getMakeTranMethod;
        if ((getMakeTranMethod = UserCustomerGrpc.getMakeTranMethod) == null) {
            synchronized (UserCustomerGrpc.class) {
                if ((getMakeTranMethod = UserCustomerGrpc.getMakeTranMethod) == null) {
                    UserCustomerGrpc.getMakeTranMethod = getMakeTranMethod =
                            io.grpc.MethodDescriptor.<UserCustomerTranRequest, ReplyBaseOuterClass.ReplyBase>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "rpc.UserCustomer", "MakeTran"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            UserCustomerTranRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            ReplyBaseOuterClass.ReplyBase.getDefaultInstance()))
                                    .setSchemaDescriptor(new UserCustomerMethodDescriptorSupplier("MakeTran"))
                                    .build();
                }
            }
        }
        return getMakeTranMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static UserCustomerStub newStub(io.grpc.Channel channel) {
        return new UserCustomerStub(channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static UserCustomerBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        return new UserCustomerBlockingStub(channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static UserCustomerFutureStub newFutureStub(
            io.grpc.Channel channel) {
        return new UserCustomerFutureStub(channel);
    }

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (UserCustomerGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new UserCustomerFileDescriptorSupplier())
                            .addMethod(getEditUserPhoneMethod())
                            .addMethod(getEditUserAddressMethod())
                            .addMethod(getGetUserTransactionMethod())
                            .addMethod(getGetUserOperateLogMethod())
                            .addMethod(getMakeTranMethod())
                            .build();
                }
            }
        }
        return result;
    }

    /**
     */
    public static abstract class UserCustomerImplBase implements io.grpc.BindableService {

        /**
         */
        public void editUserPhone(UserCustomerEditRequest request,
                                  io.grpc.stub.StreamObserver<ReplyBaseOuterClass.ReplyBase> responseObserver) {
            asyncUnimplementedUnaryCall(getEditUserPhoneMethod(), responseObserver);
        }

        /**
         */
        public void editUserAddress(UserCustomerEditRequest request,
                                    io.grpc.stub.StreamObserver<ReplyBaseOuterClass.ReplyBase> responseObserver) {
            asyncUnimplementedUnaryCall(getEditUserAddressMethod(), responseObserver);
        }

        /**
         */
        public void getUserTransaction(UserRequestOuterClass.UserRequest request,
                                       io.grpc.stub.StreamObserver<UserCustomerTransReply> responseObserver) {
            asyncUnimplementedUnaryCall(getGetUserTransactionMethod(), responseObserver);
        }

        /**
         */
        public void getUserOperateLog(UserRequestOuterClass.UserRequest request,
                                      io.grpc.stub.StreamObserver<UserCustomerLogsReply> responseObserver) {
            asyncUnimplementedUnaryCall(getGetUserOperateLogMethod(), responseObserver);
        }

        /**
         */
        public void makeTran(UserCustomerTranRequest request,
                             io.grpc.stub.StreamObserver<ReplyBaseOuterClass.ReplyBase> responseObserver) {
            asyncUnimplementedUnaryCall(getMakeTranMethod(), responseObserver);
        }

        public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            getEditUserPhoneMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            UserCustomerEditRequest,
                                            ReplyBaseOuterClass.ReplyBase>(
                                            this, METHODID_EDIT_USER_PHONE)))
                    .addMethod(
                            getEditUserAddressMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            UserCustomerEditRequest,
                                            ReplyBaseOuterClass.ReplyBase>(
                                            this, METHODID_EDIT_USER_ADDRESS)))
                    .addMethod(
                            getGetUserTransactionMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            UserRequestOuterClass.UserRequest,
                                            UserCustomerTransReply>(
                                            this, METHODID_GET_USER_TRANSACTION)))
                    .addMethod(
                            getGetUserOperateLogMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            UserRequestOuterClass.UserRequest,
                                            UserCustomerLogsReply>(
                                            this, METHODID_GET_USER_OPERATE_LOG)))
                    .addMethod(
                            getMakeTranMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            UserCustomerTranRequest,
                                            ReplyBaseOuterClass.ReplyBase>(
                                            this, METHODID_MAKE_TRAN)))
                    .build();
        }
    }

    /**
     */
    public static final class UserCustomerStub extends io.grpc.stub.AbstractStub<UserCustomerStub> {
        private UserCustomerStub(io.grpc.Channel channel) {
            super(channel);
        }

        private UserCustomerStub(io.grpc.Channel channel,
                                 io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override
        protected UserCustomerStub build(io.grpc.Channel channel,
                                         io.grpc.CallOptions callOptions) {
            return new UserCustomerStub(channel, callOptions);
        }

        /**
         */
        public void editUserPhone(UserCustomerEditRequest request,
                                  io.grpc.stub.StreamObserver<ReplyBaseOuterClass.ReplyBase> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getEditUserPhoneMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void editUserAddress(UserCustomerEditRequest request,
                                    io.grpc.stub.StreamObserver<ReplyBaseOuterClass.ReplyBase> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getEditUserAddressMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void getUserTransaction(UserRequestOuterClass.UserRequest request,
                                       io.grpc.stub.StreamObserver<UserCustomerTransReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getGetUserTransactionMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void getUserOperateLog(UserRequestOuterClass.UserRequest request,
                                      io.grpc.stub.StreamObserver<UserCustomerLogsReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getGetUserOperateLogMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void makeTran(UserCustomerTranRequest request,
                             io.grpc.stub.StreamObserver<ReplyBaseOuterClass.ReplyBase> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getMakeTranMethod(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     */
    public static final class UserCustomerBlockingStub extends io.grpc.stub.AbstractStub<UserCustomerBlockingStub> {
        private UserCustomerBlockingStub(io.grpc.Channel channel) {
            super(channel);
        }

        private UserCustomerBlockingStub(io.grpc.Channel channel,
                                         io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override
        protected UserCustomerBlockingStub build(io.grpc.Channel channel,
                                                 io.grpc.CallOptions callOptions) {
            return new UserCustomerBlockingStub(channel, callOptions);
        }

        /**
         */
        public ReplyBaseOuterClass.ReplyBase editUserPhone(UserCustomerEditRequest request) {
            return blockingUnaryCall(
                    getChannel(), getEditUserPhoneMethod(), getCallOptions(), request);
        }

        /**
         */
        public ReplyBaseOuterClass.ReplyBase editUserAddress(UserCustomerEditRequest request) {
            return blockingUnaryCall(
                    getChannel(), getEditUserAddressMethod(), getCallOptions(), request);
        }

        /**
         */
        public UserCustomerTransReply getUserTransaction(UserRequestOuterClass.UserRequest request) {
            return blockingUnaryCall(
                    getChannel(), getGetUserTransactionMethod(), getCallOptions(), request);
        }

        /**
         */
        public UserCustomerLogsReply getUserOperateLog(UserRequestOuterClass.UserRequest request) {
            return blockingUnaryCall(
                    getChannel(), getGetUserOperateLogMethod(), getCallOptions(), request);
        }

        /**
         */
        public ReplyBaseOuterClass.ReplyBase makeTran(UserCustomerTranRequest request) {
            return blockingUnaryCall(
                    getChannel(), getMakeTranMethod(), getCallOptions(), request);
        }
    }

    /**
     */
    public static final class UserCustomerFutureStub extends io.grpc.stub.AbstractStub<UserCustomerFutureStub> {
        private UserCustomerFutureStub(io.grpc.Channel channel) {
            super(channel);
        }

        private UserCustomerFutureStub(io.grpc.Channel channel,
                                       io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override
        protected UserCustomerFutureStub build(io.grpc.Channel channel,
                                               io.grpc.CallOptions callOptions) {
            return new UserCustomerFutureStub(channel, callOptions);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<ReplyBaseOuterClass.ReplyBase> editUserPhone(
                UserCustomerEditRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getEditUserPhoneMethod(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<ReplyBaseOuterClass.ReplyBase> editUserAddress(
                UserCustomerEditRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getEditUserAddressMethod(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<UserCustomerTransReply> getUserTransaction(
                UserRequestOuterClass.UserRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getGetUserTransactionMethod(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<UserCustomerLogsReply> getUserOperateLog(
                UserRequestOuterClass.UserRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getGetUserOperateLogMethod(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<ReplyBaseOuterClass.ReplyBase> makeTran(
                UserCustomerTranRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getMakeTranMethod(), getCallOptions()), request);
        }
    }

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final UserCustomerImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(UserCustomerImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_EDIT_USER_PHONE:
                    serviceImpl.editUserPhone((UserCustomerEditRequest) request,
                            (io.grpc.stub.StreamObserver<ReplyBaseOuterClass.ReplyBase>) responseObserver);
                    break;
                case METHODID_EDIT_USER_ADDRESS:
                    serviceImpl.editUserAddress((UserCustomerEditRequest) request,
                            (io.grpc.stub.StreamObserver<ReplyBaseOuterClass.ReplyBase>) responseObserver);
                    break;
                case METHODID_GET_USER_TRANSACTION:
                    serviceImpl.getUserTransaction((UserRequestOuterClass.UserRequest) request,
                            (io.grpc.stub.StreamObserver<UserCustomerTransReply>) responseObserver);
                    break;
                case METHODID_GET_USER_OPERATE_LOG:
                    serviceImpl.getUserOperateLog((UserRequestOuterClass.UserRequest) request,
                            (io.grpc.stub.StreamObserver<UserCustomerLogsReply>) responseObserver);
                    break;
                case METHODID_MAKE_TRAN:
                    serviceImpl.makeTran((UserCustomerTranRequest) request,
                            (io.grpc.stub.StreamObserver<ReplyBaseOuterClass.ReplyBase>) responseObserver);
                    break;
                default:
                    throw new AssertionError();
            }
        }

        @SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(
                io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new AssertionError();
            }
        }
    }

    private static abstract class UserCustomerBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        UserCustomerBaseDescriptorSupplier() {
        }


        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return UserCustomerProto.getDescriptor();
        }


        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("UserCustomer");
        }
    }

    private static final class UserCustomerFileDescriptorSupplier
            extends UserCustomerBaseDescriptorSupplier {
        UserCustomerFileDescriptorSupplier() {
        }
    }

    private static final class UserCustomerMethodDescriptorSupplier
            extends UserCustomerBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final String methodName;

        UserCustomerMethodDescriptorSupplier(String methodName) {
            this.methodName = methodName;
        }


        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }
}
