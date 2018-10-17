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
public final class UserStaffGrpc {

  private static final int METHODID_LOGIN = 0;

  public static final String SERVICE_NAME = "rpc.UserStaff";
  private static final int METHODID_GET_NEW_APPLY_USERS = 1;
  private static final int METHODID_GET_DELETE_ACCOUNTS = 2;
  private static final int METHODID_GET_BLOCK_USERS = 3;
  private static final int METHODID_RESPOND_APPLY = 4;
  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<UserStaffRequest,
          Response> getLoginMethod;
  private static volatile io.grpc.MethodDescriptor<UserStaffRequest,
          Response> getGetNewApplyUsersMethod;
  private static volatile io.grpc.MethodDescriptor<UserStaffRequest,
          Response> getGetDeleteAccountsMethod;
  private static volatile io.grpc.MethodDescriptor<UserStaffRequest,
          Response> getGetBlockUsersMethod;
  private static volatile io.grpc.MethodDescriptor<UserStaffRequest,
          Response> getRespondApplyMethod;
  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserStaffStub newStub(io.grpc.Channel channel) {
    return new UserStaffStub(channel);
  }

  private UserStaffGrpc() {
  }

  @io.grpc.stub.annotations.RpcMethod(
          fullMethodName = SERVICE_NAME + '/' + "Login",
          requestType = UserStaffRequest.class,
          responseType = Response.class,
          methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UserStaffRequest,
          Response> getLoginMethod() {
    io.grpc.MethodDescriptor<UserStaffRequest, Response> getLoginMethod;
    if ((getLoginMethod = UserStaffGrpc.getLoginMethod) == null) {
      synchronized (UserStaffGrpc.class) {
        if ((getLoginMethod = UserStaffGrpc.getLoginMethod) == null) {
          UserStaffGrpc.getLoginMethod = getLoginMethod =
                  io.grpc.MethodDescriptor.<UserStaffRequest, Response>newBuilder()
                          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                          .setFullMethodName(generateFullMethodName(
                                  "rpc.UserStaff", "Login"))
                          .setSampledToLocalTracing(true)
                          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  UserStaffRequest.getDefaultInstance()))
                          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  Response.getDefaultInstance()))
                          .setSchemaDescriptor(new UserStaffMethodDescriptorSupplier("Login"))
                          .build();
        }
      }
    }
    return getLoginMethod;
  }

  @io.grpc.stub.annotations.RpcMethod(
          fullMethodName = SERVICE_NAME + '/' + "GetNewApplyUsers",
          requestType = UserStaffRequest.class,
          responseType = Response.class,
          methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UserStaffRequest,
          Response> getGetNewApplyUsersMethod() {
    io.grpc.MethodDescriptor<UserStaffRequest, Response> getGetNewApplyUsersMethod;
    if ((getGetNewApplyUsersMethod = UserStaffGrpc.getGetNewApplyUsersMethod) == null) {
      synchronized (UserStaffGrpc.class) {
        if ((getGetNewApplyUsersMethod = UserStaffGrpc.getGetNewApplyUsersMethod) == null) {
          UserStaffGrpc.getGetNewApplyUsersMethod = getGetNewApplyUsersMethod =
                  io.grpc.MethodDescriptor.<UserStaffRequest, Response>newBuilder()
                          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                          .setFullMethodName(generateFullMethodName(
                                  "rpc.UserStaff", "GetNewApplyUsers"))
                          .setSampledToLocalTracing(true)
                          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  UserStaffRequest.getDefaultInstance()))
                          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  Response.getDefaultInstance()))
                          .setSchemaDescriptor(new UserStaffMethodDescriptorSupplier("GetNewApplyUsers"))
                          .build();
        }
      }
    }
    return getGetNewApplyUsersMethod;
  }

  @io.grpc.stub.annotations.RpcMethod(
          fullMethodName = SERVICE_NAME + '/' + "GetDeleteAccounts",
          requestType = UserStaffRequest.class,
          responseType = Response.class,
          methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UserStaffRequest,
          Response> getGetDeleteAccountsMethod() {
    io.grpc.MethodDescriptor<UserStaffRequest, Response> getGetDeleteAccountsMethod;
    if ((getGetDeleteAccountsMethod = UserStaffGrpc.getGetDeleteAccountsMethod) == null) {
      synchronized (UserStaffGrpc.class) {
        if ((getGetDeleteAccountsMethod = UserStaffGrpc.getGetDeleteAccountsMethod) == null) {
          UserStaffGrpc.getGetDeleteAccountsMethod = getGetDeleteAccountsMethod =
                  io.grpc.MethodDescriptor.<UserStaffRequest, Response>newBuilder()
                          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                          .setFullMethodName(generateFullMethodName(
                                  "rpc.UserStaff", "GetDeleteAccounts"))
                          .setSampledToLocalTracing(true)
                          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  UserStaffRequest.getDefaultInstance()))
                          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  Response.getDefaultInstance()))
                          .setSchemaDescriptor(new UserStaffMethodDescriptorSupplier("GetDeleteAccounts"))
                          .build();
        }
      }
    }
    return getGetDeleteAccountsMethod;
  }

  @io.grpc.stub.annotations.RpcMethod(
          fullMethodName = SERVICE_NAME + '/' + "GetBlockUsers",
          requestType = UserStaffRequest.class,
          responseType = Response.class,
          methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UserStaffRequest,
          Response> getGetBlockUsersMethod() {
    io.grpc.MethodDescriptor<UserStaffRequest, Response> getGetBlockUsersMethod;
    if ((getGetBlockUsersMethod = UserStaffGrpc.getGetBlockUsersMethod) == null) {
      synchronized (UserStaffGrpc.class) {
        if ((getGetBlockUsersMethod = UserStaffGrpc.getGetBlockUsersMethod) == null) {
          UserStaffGrpc.getGetBlockUsersMethod = getGetBlockUsersMethod =
                  io.grpc.MethodDescriptor.<UserStaffRequest, Response>newBuilder()
                          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                          .setFullMethodName(generateFullMethodName(
                                  "rpc.UserStaff", "GetBlockUsers"))
                          .setSampledToLocalTracing(true)
                          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  UserStaffRequest.getDefaultInstance()))
                          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  Response.getDefaultInstance()))
                          .setSchemaDescriptor(new UserStaffMethodDescriptorSupplier("GetBlockUsers"))
                          .build();
        }
      }
    }
    return getGetBlockUsersMethod;
  }

  @io.grpc.stub.annotations.RpcMethod(
          fullMethodName = SERVICE_NAME + '/' + "RespondApply",
          requestType = UserStaffRequest.class,
          responseType = Response.class,
          methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UserStaffRequest,
          Response> getRespondApplyMethod() {
    io.grpc.MethodDescriptor<UserStaffRequest, Response> getRespondApplyMethod;
    if ((getRespondApplyMethod = UserStaffGrpc.getRespondApplyMethod) == null) {
      synchronized (UserStaffGrpc.class) {
        if ((getRespondApplyMethod = UserStaffGrpc.getRespondApplyMethod) == null) {
          UserStaffGrpc.getRespondApplyMethod = getRespondApplyMethod =
                  io.grpc.MethodDescriptor.<UserStaffRequest, Response>newBuilder()
                          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                          .setFullMethodName(generateFullMethodName(
                                  "rpc.UserStaff", "RespondApply"))
                          .setSampledToLocalTracing(true)
                          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  UserStaffRequest.getDefaultInstance()))
                          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  Response.getDefaultInstance()))
                          .setSchemaDescriptor(new UserStaffMethodDescriptorSupplier("RespondApply"))
                          .build();
        }
      }
    }
    return getRespondApplyMethod;
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserStaffBlockingStub newBlockingStub(
          io.grpc.Channel channel) {
    return new UserStaffBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserStaffFutureStub newFutureStub(
          io.grpc.Channel channel) {
    return new UserStaffFutureStub(channel);
  }

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserStaffGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                  .setSchemaDescriptor(new UserStaffFileDescriptorSupplier())
                  .addMethod(getLoginMethod())
                  .addMethod(getGetNewApplyUsersMethod())
                  .addMethod(getGetDeleteAccountsMethod())
                  .addMethod(getGetBlockUsersMethod())
                  .addMethod(getRespondApplyMethod())
                  .build();
        }
      }
    }
    return result;
  }

  /**
   */
  public static abstract class UserStaffImplBase implements io.grpc.BindableService {

    /**
     */
    public void login(UserStaffRequest request,
                      io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public void getNewApplyUsers(UserStaffRequest request,
                                 io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getGetNewApplyUsersMethod(), responseObserver);
    }

    /**
     */
    public void getDeleteAccounts(UserStaffRequest request,
                                  io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDeleteAccountsMethod(), responseObserver);
    }

    /**
     */
    public void getBlockUsers(UserStaffRequest request,
                              io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBlockUsersMethod(), responseObserver);
    }

    /**
     * <pre>
     * approve/disapprove
     * </pre>
     */
    public void respondApply(UserStaffRequest request,
                             io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getRespondApplyMethod(), responseObserver);
    }

    @Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
              .addMethod(
                      getLoginMethod(),
                      asyncUnaryCall(
                              new MethodHandlers<
                                      UserStaffRequest,
                                      Response>(
                                      this, METHODID_LOGIN)))
              .addMethod(
                      getGetNewApplyUsersMethod(),
                      asyncUnaryCall(
                              new MethodHandlers<
                                      UserStaffRequest,
                                      Response>(
                                      this, METHODID_GET_NEW_APPLY_USERS)))
              .addMethod(
                      getGetDeleteAccountsMethod(),
                      asyncUnaryCall(
                              new MethodHandlers<
                                      UserStaffRequest,
                                      Response>(
                                      this, METHODID_GET_DELETE_ACCOUNTS)))
              .addMethod(
                      getGetBlockUsersMethod(),
                      asyncUnaryCall(
                              new MethodHandlers<
                                      UserStaffRequest,
                                      Response>(
                                      this, METHODID_GET_BLOCK_USERS)))
              .addMethod(
                      getRespondApplyMethod(),
                      asyncUnaryCall(
                              new MethodHandlers<
                                      UserStaffRequest,
                                      Response>(
                                      this, METHODID_RESPOND_APPLY)))
          .build();
    }
  }

  /**
   */
  public static final class UserStaffStub extends io.grpc.stub.AbstractStub<UserStaffStub> {
    private UserStaffStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserStaffStub(io.grpc.Channel channel,
                          io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UserStaffStub build(io.grpc.Channel channel,
                                  io.grpc.CallOptions callOptions) {
      return new UserStaffStub(channel, callOptions);
    }

    /**
     */
    public void login(UserStaffRequest request,
                      io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
              getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getNewApplyUsers(UserStaffRequest request,
                                 io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
              getChannel().newCall(getGetNewApplyUsersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDeleteAccounts(UserStaffRequest request,
                                  io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
              getChannel().newCall(getGetDeleteAccountsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBlockUsers(UserStaffRequest request,
                              io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
              getChannel().newCall(getGetBlockUsersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * approve/disapprove
     * </pre>
     */
    public void respondApply(UserStaffRequest request,
                             io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
              getChannel().newCall(getRespondApplyMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserStaffBlockingStub extends io.grpc.stub.AbstractStub<UserStaffBlockingStub> {
    private UserStaffBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserStaffBlockingStub(io.grpc.Channel channel,
                                  io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UserStaffBlockingStub build(io.grpc.Channel channel,
                                          io.grpc.CallOptions callOptions) {
      return new UserStaffBlockingStub(channel, callOptions);
    }

    /**
     */
    public Response login(UserStaffRequest request) {
      return blockingUnaryCall(
              getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public Response getNewApplyUsers(UserStaffRequest request) {
      return blockingUnaryCall(
              getChannel(), getGetNewApplyUsersMethod(), getCallOptions(), request);
    }

    /**
     */
    public Response getDeleteAccounts(UserStaffRequest request) {
      return blockingUnaryCall(
              getChannel(), getGetDeleteAccountsMethod(), getCallOptions(), request);
    }

    /**
     */
    public Response getBlockUsers(UserStaffRequest request) {
      return blockingUnaryCall(
              getChannel(), getGetBlockUsersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * approve/disapprove
     * </pre>
     */
    public Response respondApply(UserStaffRequest request) {
      return blockingUnaryCall(
              getChannel(), getRespondApplyMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserStaffFutureStub extends io.grpc.stub.AbstractStub<UserStaffFutureStub> {
    private UserStaffFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserStaffFutureStub(io.grpc.Channel channel,
                                io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UserStaffFutureStub build(io.grpc.Channel channel,
                                        io.grpc.CallOptions callOptions) {
      return new UserStaffFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> login(
            UserStaffRequest request) {
      return futureUnaryCall(
              getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> getNewApplyUsers(
        UserStaffRequest request) {
      return futureUnaryCall(
              getChannel().newCall(getGetNewApplyUsersMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> getDeleteAccounts(
        UserStaffRequest request) {
      return futureUnaryCall(
              getChannel().newCall(getGetDeleteAccountsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> getBlockUsers(
            UserStaffRequest request) {
      return futureUnaryCall(
              getChannel().newCall(getGetBlockUsersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * approve/disapprove
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> respondApply(
            UserStaffRequest request) {
      return futureUnaryCall(
              getChannel().newCall(getRespondApplyMethod(), getCallOptions()), request);
    }
  }

  private static final class MethodHandlers<Req, Resp> implements
          io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserStaffImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserStaffImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((UserStaffRequest) request,
                  (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_GET_NEW_APPLY_USERS:
          serviceImpl.getNewApplyUsers((UserStaffRequest) request,
                  (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_GET_DELETE_ACCOUNTS:
          serviceImpl.getDeleteAccounts((UserStaffRequest) request,
                  (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_GET_BLOCK_USERS:
          serviceImpl.getBlockUsers((UserStaffRequest) request,
                  (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_RESPOND_APPLY:
          serviceImpl.respondApply((UserStaffRequest) request,
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

  private static abstract class UserStaffBaseDescriptorSupplier
          implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserStaffBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return BankProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserStaff");
    }
  }

  private static final class UserStaffFileDescriptorSupplier
          extends UserStaffBaseDescriptorSupplier {
    UserStaffFileDescriptorSupplier() {}
  }

  private static final class UserStaffMethodDescriptorSupplier
          extends UserStaffBaseDescriptorSupplier
          implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserStaffMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }
}
