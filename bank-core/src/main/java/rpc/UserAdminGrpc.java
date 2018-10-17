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
public final class UserAdminGrpc {

  private UserAdminGrpc() {}

  public static final String SERVICE_NAME = "rpc.UserAdmin";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<UserAdminRequest,
      Response> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Login",
      requestType = UserAdminRequest.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UserAdminRequest,
      Response> getLoginMethod() {
    io.grpc.MethodDescriptor<UserAdminRequest, Response> getLoginMethod;
    if ((getLoginMethod = UserAdminGrpc.getLoginMethod) == null) {
      synchronized (UserAdminGrpc.class) {
        if ((getLoginMethod = UserAdminGrpc.getLoginMethod) == null) {
          UserAdminGrpc.getLoginMethod = getLoginMethod =
              io.grpc.MethodDescriptor.<UserAdminRequest, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "rpc.UserAdmin", "Login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UserAdminRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new UserAdminMethodDescriptorSupplier("Login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<UserAdminRequest,
      Response> getGetStaffsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStaffs",
      requestType = UserAdminRequest.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UserAdminRequest,
      Response> getGetStaffsMethod() {
    io.grpc.MethodDescriptor<UserAdminRequest, Response> getGetStaffsMethod;
    if ((getGetStaffsMethod = UserAdminGrpc.getGetStaffsMethod) == null) {
      synchronized (UserAdminGrpc.class) {
        if ((getGetStaffsMethod = UserAdminGrpc.getGetStaffsMethod) == null) {
          UserAdminGrpc.getGetStaffsMethod = getGetStaffsMethod =
              io.grpc.MethodDescriptor.<UserAdminRequest, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "rpc.UserAdmin", "GetStaffs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UserAdminRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new UserAdminMethodDescriptorSupplier("GetStaffs"))
                  .build();
          }
        }
     }
     return getGetStaffsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<UserAdminRequest,
      Response> getAddNewStaffMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddNewStaff",
      requestType = UserAdminRequest.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UserAdminRequest,
      Response> getAddNewStaffMethod() {
    io.grpc.MethodDescriptor<UserAdminRequest, Response> getAddNewStaffMethod;
    if ((getAddNewStaffMethod = UserAdminGrpc.getAddNewStaffMethod) == null) {
      synchronized (UserAdminGrpc.class) {
        if ((getAddNewStaffMethod = UserAdminGrpc.getAddNewStaffMethod) == null) {
          UserAdminGrpc.getAddNewStaffMethod = getAddNewStaffMethod =
              io.grpc.MethodDescriptor.<UserAdminRequest, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "rpc.UserAdmin", "AddNewStaff"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UserAdminRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new UserAdminMethodDescriptorSupplier("AddNewStaff"))
                  .build();
          }
        }
     }
     return getAddNewStaffMethod;
  }

  private static volatile io.grpc.MethodDescriptor<UserAdminRequest,
      Response> getRemoveStaffMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveStaff",
      requestType = UserAdminRequest.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UserAdminRequest,
      Response> getRemoveStaffMethod() {
    io.grpc.MethodDescriptor<UserAdminRequest, Response> getRemoveStaffMethod;
    if ((getRemoveStaffMethod = UserAdminGrpc.getRemoveStaffMethod) == null) {
      synchronized (UserAdminGrpc.class) {
        if ((getRemoveStaffMethod = UserAdminGrpc.getRemoveStaffMethod) == null) {
          UserAdminGrpc.getRemoveStaffMethod = getRemoveStaffMethod =
              io.grpc.MethodDescriptor.<UserAdminRequest, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "rpc.UserAdmin", "RemoveStaff"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UserAdminRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new UserAdminMethodDescriptorSupplier("RemoveStaff"))
                  .build();
          }
        }
     }
     return getRemoveStaffMethod;
  }

  private static volatile io.grpc.MethodDescriptor<UserAdminRequest,
      Response> getConfigEmailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ConfigEmail",
      requestType = UserAdminRequest.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UserAdminRequest,
      Response> getConfigEmailMethod() {
    io.grpc.MethodDescriptor<UserAdminRequest, Response> getConfigEmailMethod;
    if ((getConfigEmailMethod = UserAdminGrpc.getConfigEmailMethod) == null) {
      synchronized (UserAdminGrpc.class) {
        if ((getConfigEmailMethod = UserAdminGrpc.getConfigEmailMethod) == null) {
          UserAdminGrpc.getConfigEmailMethod = getConfigEmailMethod =
              io.grpc.MethodDescriptor.<UserAdminRequest, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "rpc.UserAdmin", "ConfigEmail"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UserAdminRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new UserAdminMethodDescriptorSupplier("ConfigEmail"))
                  .build();
          }
        }
     }
     return getConfigEmailMethod;
  }

  private static volatile io.grpc.MethodDescriptor<UserAdminRequest,
      Response> getCheckEmailAvailabilityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckEmailAvailability",
      requestType = UserAdminRequest.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UserAdminRequest,
      Response> getCheckEmailAvailabilityMethod() {
    io.grpc.MethodDescriptor<UserAdminRequest, Response> getCheckEmailAvailabilityMethod;
    if ((getCheckEmailAvailabilityMethod = UserAdminGrpc.getCheckEmailAvailabilityMethod) == null) {
      synchronized (UserAdminGrpc.class) {
        if ((getCheckEmailAvailabilityMethod = UserAdminGrpc.getCheckEmailAvailabilityMethod) == null) {
          UserAdminGrpc.getCheckEmailAvailabilityMethod = getCheckEmailAvailabilityMethod =
              io.grpc.MethodDescriptor.<UserAdminRequest, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "rpc.UserAdmin", "CheckEmailAvailability"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UserAdminRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new UserAdminMethodDescriptorSupplier("CheckEmailAvailability"))
                  .build();
          }
        }
     }
     return getCheckEmailAvailabilityMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserAdminStub newStub(io.grpc.Channel channel) {
    return new UserAdminStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserAdminBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserAdminBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserAdminFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserAdminFutureStub(channel);
  }

  /**
   */
  public static abstract class UserAdminImplBase implements io.grpc.BindableService {

    /**
     */
    public void login(UserAdminRequest request,
                      io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public void getStaffs(UserAdminRequest request,
                          io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStaffsMethod(), responseObserver);
    }

    /**
     */
    public void addNewStaff(UserAdminRequest request,
                            io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getAddNewStaffMethod(), responseObserver);
    }

    /**
     */
    public void removeStaff(UserAdminRequest request,
                            io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveStaffMethod(), responseObserver);
    }

    /**
     */
    public void configEmail(UserAdminRequest request,
                            io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getConfigEmailMethod(), responseObserver);
    }

    /**
     */
    public void checkEmailAvailability(UserAdminRequest request,
                                       io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckEmailAvailabilityMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                UserAdminRequest,
                Response>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getGetStaffsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                UserAdminRequest,
                Response>(
                  this, METHODID_GET_STAFFS)))
          .addMethod(
            getAddNewStaffMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                UserAdminRequest,
                Response>(
                  this, METHODID_ADD_NEW_STAFF)))
          .addMethod(
            getRemoveStaffMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                UserAdminRequest,
                Response>(
                  this, METHODID_REMOVE_STAFF)))
          .addMethod(
            getConfigEmailMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                UserAdminRequest,
                Response>(
                  this, METHODID_CONFIG_EMAIL)))
          .addMethod(
            getCheckEmailAvailabilityMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                UserAdminRequest,
                Response>(
                  this, METHODID_CHECK_EMAIL_AVAILABILITY)))
          .build();
    }
  }

  /**
   */
  public static final class UserAdminStub extends io.grpc.stub.AbstractStub<UserAdminStub> {
    private UserAdminStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserAdminStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UserAdminStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserAdminStub(channel, callOptions);
    }

    /**
     */
    public void login(UserAdminRequest request,
                      io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStaffs(UserAdminRequest request,
                          io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetStaffsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addNewStaff(UserAdminRequest request,
                            io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddNewStaffMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeStaff(UserAdminRequest request,
                            io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveStaffMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void configEmail(UserAdminRequest request,
                            io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getConfigEmailMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void checkEmailAvailability(UserAdminRequest request,
                                       io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckEmailAvailabilityMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserAdminBlockingStub extends io.grpc.stub.AbstractStub<UserAdminBlockingStub> {
    private UserAdminBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserAdminBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UserAdminBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserAdminBlockingStub(channel, callOptions);
    }

    /**
     */
    public Response login(UserAdminRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public Response getStaffs(UserAdminRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetStaffsMethod(), getCallOptions(), request);
    }

    /**
     */
    public Response addNewStaff(UserAdminRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddNewStaffMethod(), getCallOptions(), request);
    }

    /**
     */
    public Response removeStaff(UserAdminRequest request) {
      return blockingUnaryCall(
          getChannel(), getRemoveStaffMethod(), getCallOptions(), request);
    }

    /**
     */
    public Response configEmail(UserAdminRequest request) {
      return blockingUnaryCall(
          getChannel(), getConfigEmailMethod(), getCallOptions(), request);
    }

    /**
     */
    public Response checkEmailAvailability(UserAdminRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckEmailAvailabilityMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserAdminFutureStub extends io.grpc.stub.AbstractStub<UserAdminFutureStub> {
    private UserAdminFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserAdminFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UserAdminFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserAdminFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> login(
        UserAdminRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> getStaffs(
        UserAdminRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetStaffsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> addNewStaff(
        UserAdminRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddNewStaffMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> removeStaff(
        UserAdminRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveStaffMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> configEmail(
        UserAdminRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getConfigEmailMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> checkEmailAvailability(
        UserAdminRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckEmailAvailabilityMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_GET_STAFFS = 1;
  private static final int METHODID_ADD_NEW_STAFF = 2;
  private static final int METHODID_REMOVE_STAFF = 3;
  private static final int METHODID_CONFIG_EMAIL = 4;
  private static final int METHODID_CHECK_EMAIL_AVAILABILITY = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserAdminImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserAdminImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((UserAdminRequest) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_GET_STAFFS:
          serviceImpl.getStaffs((UserAdminRequest) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_ADD_NEW_STAFF:
          serviceImpl.addNewStaff((UserAdminRequest) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_REMOVE_STAFF:
          serviceImpl.removeStaff((UserAdminRequest) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_CONFIG_EMAIL:
          serviceImpl.configEmail((UserAdminRequest) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_CHECK_EMAIL_AVAILABILITY:
          serviceImpl.checkEmailAvailability((UserAdminRequest) request,
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

  private static abstract class UserAdminBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserAdminBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return BankProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserAdmin");
    }
  }

  private static final class UserAdminFileDescriptorSupplier
      extends UserAdminBaseDescriptorSupplier {
    UserAdminFileDescriptorSupplier() {}
  }

  private static final class UserAdminMethodDescriptorSupplier
      extends UserAdminBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserAdminMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserAdminGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserAdminFileDescriptorSupplier())
              .addMethod(getLoginMethod())
              .addMethod(getGetStaffsMethod())
              .addMethod(getAddNewStaffMethod())
              .addMethod(getRemoveStaffMethod())
              .addMethod(getConfigEmailMethod())
              .addMethod(getCheckEmailAvailabilityMethod())
              .build();
        }
      }
    }
    return result;
  }
}
