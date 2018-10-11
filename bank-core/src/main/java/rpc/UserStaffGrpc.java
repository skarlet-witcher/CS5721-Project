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

  public static final String SERVICE_NAME = "rpc.UserStaff";
  private static final int METHODID_ADD_NEW_ACCOUNT = 0;
  private static final int METHODID_REMOVE_ACCOUNT = 1;
  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<UserStaffAddAccountRequest,
          Response> getAddNewAccountMethod;
  private static volatile io.grpc.MethodDescriptor<UserRequest,
          Response> getRemoveAccountMethod;
  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  private UserStaffGrpc() {
  }

  @io.grpc.stub.annotations.RpcMethod(
          fullMethodName = SERVICE_NAME + '/' + "AddNewAccount",
          requestType = UserStaffAddAccountRequest.class,
          responseType = Response.class,
          methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UserStaffAddAccountRequest,
          Response> getAddNewAccountMethod() {
    io.grpc.MethodDescriptor<UserStaffAddAccountRequest, Response> getAddNewAccountMethod;
    if ((getAddNewAccountMethod = UserStaffGrpc.getAddNewAccountMethod) == null) {
      synchronized (UserStaffGrpc.class) {
        if ((getAddNewAccountMethod = UserStaffGrpc.getAddNewAccountMethod) == null) {
          UserStaffGrpc.getAddNewAccountMethod = getAddNewAccountMethod =
                  io.grpc.MethodDescriptor.<UserStaffAddAccountRequest, Response>newBuilder()
                          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                          .setFullMethodName(generateFullMethodName(
                                  "rpc.UserStaff", "AddNewAccount"))
                          .setSampledToLocalTracing(true)
                          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  UserStaffAddAccountRequest.getDefaultInstance()))
                          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  Response.getDefaultInstance()))
                          .setSchemaDescriptor(new UserStaffMethodDescriptorSupplier("AddNewAccount"))
                          .build();
        }
      }
    }
    return getAddNewAccountMethod;
  }

  @io.grpc.stub.annotations.RpcMethod(
          fullMethodName = SERVICE_NAME + '/' + "RemoveAccount",
          requestType = UserRequest.class,
          responseType = Response.class,
          methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UserRequest,
          Response> getRemoveAccountMethod() {
    io.grpc.MethodDescriptor<UserRequest, Response> getRemoveAccountMethod;
    if ((getRemoveAccountMethod = UserStaffGrpc.getRemoveAccountMethod) == null) {
      synchronized (UserStaffGrpc.class) {
        if ((getRemoveAccountMethod = UserStaffGrpc.getRemoveAccountMethod) == null) {
          UserStaffGrpc.getRemoveAccountMethod = getRemoveAccountMethod =
                  io.grpc.MethodDescriptor.<UserRequest, Response>newBuilder()
                          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                          .setFullMethodName(generateFullMethodName(
                                  "rpc.UserStaff", "RemoveAccount"))
                          .setSampledToLocalTracing(true)
                          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  UserRequest.getDefaultInstance()))
                          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  Response.getDefaultInstance()))
                          .setSchemaDescriptor(new UserStaffMethodDescriptorSupplier("RemoveAccount"))
                          .build();
        }
      }
    }
    return getRemoveAccountMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserStaffStub newStub(io.grpc.Channel channel) {
    return new UserStaffStub(channel);
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
                  .addMethod(getAddNewAccountMethod())
                  .addMethod(getRemoveAccountMethod())
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
    public void addNewAccount(UserStaffAddAccountRequest request,
                              io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getAddNewAccountMethod(), responseObserver);
    }

    /**
     */
    public void removeAccount(UserRequest request,
                              io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveAccountMethod(), responseObserver);
    }

    @Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
              .addMethod(
                      getAddNewAccountMethod(),
                      asyncUnaryCall(
                              new MethodHandlers<
                                      UserStaffAddAccountRequest,
                                      Response>(
                                      this, METHODID_ADD_NEW_ACCOUNT)))
              .addMethod(
                      getRemoveAccountMethod(),
                      asyncUnaryCall(
                              new MethodHandlers<
                                      UserRequest,
                                      Response>(
                                      this, METHODID_REMOVE_ACCOUNT)))
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
    public void addNewAccount(UserStaffAddAccountRequest request,
                              io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
              getChannel().newCall(getAddNewAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeAccount(UserRequest request,
                              io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
              getChannel().newCall(getRemoveAccountMethod(), getCallOptions()), request, responseObserver);
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
    public Response addNewAccount(UserStaffAddAccountRequest request) {
      return blockingUnaryCall(
              getChannel(), getAddNewAccountMethod(), getCallOptions(), request);
    }

    /**
     */
    public Response removeAccount(UserRequest request) {
      return blockingUnaryCall(
              getChannel(), getRemoveAccountMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<Response> addNewAccount(
            UserStaffAddAccountRequest request) {
      return futureUnaryCall(
              getChannel().newCall(getAddNewAccountMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> removeAccount(
            UserRequest request) {
      return futureUnaryCall(
              getChannel().newCall(getRemoveAccountMethod(), getCallOptions()), request);
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
        case METHODID_ADD_NEW_ACCOUNT:
          serviceImpl.addNewAccount((UserStaffAddAccountRequest) request,
                  (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_REMOVE_ACCOUNT:
          serviceImpl.removeAccount((UserRequest) request,
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
    UserStaffBaseDescriptorSupplier() {
    }

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
    UserStaffFileDescriptorSupplier() {
    }
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
