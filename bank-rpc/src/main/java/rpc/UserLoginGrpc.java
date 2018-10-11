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
public final class UserLoginGrpc {

  public static final String SERVICE_NAME = "rpc.UserLogin";
  private static final int METHODID_LOGIN = 0;
  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<UserLoginRequest,
          Response> getLoginMethod;
  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  private UserLoginGrpc() {
  }

  @io.grpc.stub.annotations.RpcMethod(
          fullMethodName = SERVICE_NAME + '/' + "Login",
          requestType = UserLoginRequest.class,
          responseType = Response.class,
          methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UserLoginRequest,
          Response> getLoginMethod() {
    io.grpc.MethodDescriptor<UserLoginRequest, Response> getLoginMethod;
    if ((getLoginMethod = UserLoginGrpc.getLoginMethod) == null) {
      synchronized (UserLoginGrpc.class) {
        if ((getLoginMethod = UserLoginGrpc.getLoginMethod) == null) {
          UserLoginGrpc.getLoginMethod = getLoginMethod =
                  io.grpc.MethodDescriptor.<UserLoginRequest, Response>newBuilder()
                          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                          .setFullMethodName(generateFullMethodName(
                                  "rpc.UserLogin", "Login"))
                          .setSampledToLocalTracing(true)
                          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  UserLoginRequest.getDefaultInstance()))
                          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  Response.getDefaultInstance()))
                          .setSchemaDescriptor(new UserLoginMethodDescriptorSupplier("Login"))
                          .build();
        }
      }
    }
    return getLoginMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserLoginStub newStub(io.grpc.Channel channel) {
    return new UserLoginStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserLoginBlockingStub newBlockingStub(
          io.grpc.Channel channel) {
    return new UserLoginBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserLoginFutureStub newFutureStub(
          io.grpc.Channel channel) {
    return new UserLoginFutureStub(channel);
  }

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserLoginGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                  .setSchemaDescriptor(new UserLoginFileDescriptorSupplier())
                  .addMethod(getLoginMethod())
                  .build();
        }
      }
    }
    return result;
  }

  /**
   */
  public static abstract class UserLoginImplBase implements io.grpc.BindableService {

    /**
     */
    public void login(UserLoginRequest request,
                      io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    @Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
              .addMethod(
                      getLoginMethod(),
                      asyncUnaryCall(
                              new MethodHandlers<
                                      UserLoginRequest,
                                      Response>(
                                      this, METHODID_LOGIN)))
              .build();
    }
  }

  /**
   */
  public static final class UserLoginStub extends io.grpc.stub.AbstractStub<UserLoginStub> {
    private UserLoginStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserLoginStub(io.grpc.Channel channel,
                          io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UserLoginStub build(io.grpc.Channel channel,
                                  io.grpc.CallOptions callOptions) {
      return new UserLoginStub(channel, callOptions);
    }

    /**
     */
    public void login(UserLoginRequest request,
                      io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
              getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserLoginBlockingStub extends io.grpc.stub.AbstractStub<UserLoginBlockingStub> {
    private UserLoginBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserLoginBlockingStub(io.grpc.Channel channel,
                                  io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UserLoginBlockingStub build(io.grpc.Channel channel,
                                          io.grpc.CallOptions callOptions) {
      return new UserLoginBlockingStub(channel, callOptions);
    }

    /**
     */
    public Response login(UserLoginRequest request) {
      return blockingUnaryCall(
              getChannel(), getLoginMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserLoginFutureStub extends io.grpc.stub.AbstractStub<UserLoginFutureStub> {
    private UserLoginFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserLoginFutureStub(io.grpc.Channel channel,
                                io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UserLoginFutureStub build(io.grpc.Channel channel,
                                        io.grpc.CallOptions callOptions) {
      return new UserLoginFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> login(
            UserLoginRequest request) {
      return futureUnaryCall(
              getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }
  }

  private static final class MethodHandlers<Req, Resp> implements
          io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserLoginImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserLoginImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((UserLoginRequest) request,
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

  private static abstract class UserLoginBaseDescriptorSupplier
          implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserLoginBaseDescriptorSupplier() {
    }

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return BankProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserLogin");
    }
  }

  private static final class UserLoginFileDescriptorSupplier
          extends UserLoginBaseDescriptorSupplier {
    UserLoginFileDescriptorSupplier() {
    }
  }

  private static final class UserLoginMethodDescriptorSupplier
          extends UserLoginBaseDescriptorSupplier
          implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserLoginMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }
}
