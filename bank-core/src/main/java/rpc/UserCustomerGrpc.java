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
public final class UserCustomerGrpc {

  private UserCustomerGrpc() {}

  public static final String SERVICE_NAME = "rpc.UserCustomer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<UserCustomerGetAccountsRequest,
      Response> getGetAccountsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccounts",
      requestType = UserCustomerGetAccountsRequest.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UserCustomerGetAccountsRequest,
      Response> getGetAccountsMethod() {
    io.grpc.MethodDescriptor<UserCustomerGetAccountsRequest, Response> getGetAccountsMethod;
    if ((getGetAccountsMethod = UserCustomerGrpc.getGetAccountsMethod) == null) {
      synchronized (UserCustomerGrpc.class) {
        if ((getGetAccountsMethod = UserCustomerGrpc.getGetAccountsMethod) == null) {
          UserCustomerGrpc.getGetAccountsMethod = getGetAccountsMethod =
              io.grpc.MethodDescriptor.<UserCustomerGetAccountsRequest, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "rpc.UserCustomer", "GetAccounts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UserCustomerGetAccountsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new UserCustomerMethodDescriptorSupplier("GetAccounts"))
                  .build();
          }
        }
     }
     return getGetAccountsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<UserCustomerGetProfileRequest,
      Response> getGetProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProfile",
      requestType = UserCustomerGetProfileRequest.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UserCustomerGetProfileRequest,
      Response> getGetProfileMethod() {
    io.grpc.MethodDescriptor<UserCustomerGetProfileRequest, Response> getGetProfileMethod;
    if ((getGetProfileMethod = UserCustomerGrpc.getGetProfileMethod) == null) {
      synchronized (UserCustomerGrpc.class) {
        if ((getGetProfileMethod = UserCustomerGrpc.getGetProfileMethod) == null) {
          UserCustomerGrpc.getGetProfileMethod = getGetProfileMethod =
              io.grpc.MethodDescriptor.<UserCustomerGetProfileRequest, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "rpc.UserCustomer", "GetProfile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UserCustomerGetProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new UserCustomerMethodDescriptorSupplier("GetProfile"))
                  .build();
          }
        }
     }
     return getGetProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<UserCustomerEditProfileRequest,
      Response> getEditProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EditProfile",
      requestType = UserCustomerEditProfileRequest.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UserCustomerEditProfileRequest,
      Response> getEditProfileMethod() {
    io.grpc.MethodDescriptor<UserCustomerEditProfileRequest, Response> getEditProfileMethod;
    if ((getEditProfileMethod = UserCustomerGrpc.getEditProfileMethod) == null) {
      synchronized (UserCustomerGrpc.class) {
        if ((getEditProfileMethod = UserCustomerGrpc.getEditProfileMethod) == null) {
          UserCustomerGrpc.getEditProfileMethod = getEditProfileMethod =
              io.grpc.MethodDescriptor.<UserCustomerEditProfileRequest, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "rpc.UserCustomer", "EditProfile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UserCustomerEditProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new UserCustomerMethodDescriptorSupplier("EditProfile"))
                  .build();
          }
        }
     }
     return getEditProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<UserCustomerGetTransactionsRequest,
      Response> getGetTransactionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTransactions",
      requestType = UserCustomerGetTransactionsRequest.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UserCustomerGetTransactionsRequest,
      Response> getGetTransactionsMethod() {
    io.grpc.MethodDescriptor<UserCustomerGetTransactionsRequest, Response> getGetTransactionsMethod;
    if ((getGetTransactionsMethod = UserCustomerGrpc.getGetTransactionsMethod) == null) {
      synchronized (UserCustomerGrpc.class) {
        if ((getGetTransactionsMethod = UserCustomerGrpc.getGetTransactionsMethod) == null) {
          UserCustomerGrpc.getGetTransactionsMethod = getGetTransactionsMethod =
              io.grpc.MethodDescriptor.<UserCustomerGetTransactionsRequest, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "rpc.UserCustomer", "GetTransactions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UserCustomerGetTransactionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new UserCustomerMethodDescriptorSupplier("GetTransactions"))
                  .build();
          }
        }
     }
     return getGetTransactionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<UserCustomerGetPayeesRequest,
      Response> getGetPayeesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPayees",
      requestType = UserCustomerGetPayeesRequest.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UserCustomerGetPayeesRequest,
      Response> getGetPayeesMethod() {
    io.grpc.MethodDescriptor<UserCustomerGetPayeesRequest, Response> getGetPayeesMethod;
    if ((getGetPayeesMethod = UserCustomerGrpc.getGetPayeesMethod) == null) {
      synchronized (UserCustomerGrpc.class) {
        if ((getGetPayeesMethod = UserCustomerGrpc.getGetPayeesMethod) == null) {
          UserCustomerGrpc.getGetPayeesMethod = getGetPayeesMethod =
              io.grpc.MethodDescriptor.<UserCustomerGetPayeesRequest, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "rpc.UserCustomer", "GetPayees"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UserCustomerGetPayeesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new UserCustomerMethodDescriptorSupplier("GetPayees"))
                  .build();
          }
        }
     }
     return getGetPayeesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<UserCustomerAddPayeeRequest,
      Response> getAddPayeeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddPayee",
      requestType = UserCustomerAddPayeeRequest.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UserCustomerAddPayeeRequest,
      Response> getAddPayeeMethod() {
    io.grpc.MethodDescriptor<UserCustomerAddPayeeRequest, Response> getAddPayeeMethod;
    if ((getAddPayeeMethod = UserCustomerGrpc.getAddPayeeMethod) == null) {
      synchronized (UserCustomerGrpc.class) {
        if ((getAddPayeeMethod = UserCustomerGrpc.getAddPayeeMethod) == null) {
          UserCustomerGrpc.getAddPayeeMethod = getAddPayeeMethod =
              io.grpc.MethodDescriptor.<UserCustomerAddPayeeRequest, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "rpc.UserCustomer", "AddPayee"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UserCustomerAddPayeeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new UserCustomerMethodDescriptorSupplier("AddPayee"))
                  .build();
          }
        }
     }
     return getAddPayeeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<UserCustomerRemovePayeeRequest,
      Response> getRemovePayeeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemovePayee",
      requestType = UserCustomerRemovePayeeRequest.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UserCustomerRemovePayeeRequest,
      Response> getRemovePayeeMethod() {
    io.grpc.MethodDescriptor<UserCustomerRemovePayeeRequest, Response> getRemovePayeeMethod;
    if ((getRemovePayeeMethod = UserCustomerGrpc.getRemovePayeeMethod) == null) {
      synchronized (UserCustomerGrpc.class) {
        if ((getRemovePayeeMethod = UserCustomerGrpc.getRemovePayeeMethod) == null) {
          UserCustomerGrpc.getRemovePayeeMethod = getRemovePayeeMethod =
              io.grpc.MethodDescriptor.<UserCustomerRemovePayeeRequest, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "rpc.UserCustomer", "RemovePayee"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UserCustomerRemovePayeeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new UserCustomerMethodDescriptorSupplier("RemovePayee"))
                  .build();
          }
        }
     }
     return getRemovePayeeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<UserCustomerTransferRequest,
      Response> getTransferMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Transfer",
      requestType = UserCustomerTransferRequest.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UserCustomerTransferRequest,
      Response> getTransferMethod() {
    io.grpc.MethodDescriptor<UserCustomerTransferRequest, Response> getTransferMethod;
    if ((getTransferMethod = UserCustomerGrpc.getTransferMethod) == null) {
      synchronized (UserCustomerGrpc.class) {
        if ((getTransferMethod = UserCustomerGrpc.getTransferMethod) == null) {
          UserCustomerGrpc.getTransferMethod = getTransferMethod =
              io.grpc.MethodDescriptor.<UserCustomerTransferRequest, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "rpc.UserCustomer", "Transfer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UserCustomerTransferRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new UserCustomerMethodDescriptorSupplier("Transfer"))
                  .build();
          }
        }
     }
     return getTransferMethod;
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

  /**
   */
  public static abstract class UserCustomerImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAccounts(UserCustomerGetAccountsRequest request,
                            io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAccountsMethod(), responseObserver);
    }

    /**
     */
    public void getProfile(UserCustomerGetProfileRequest request,
                           io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getGetProfileMethod(), responseObserver);
    }

    /**
     */
    public void editProfile(UserCustomerEditProfileRequest request,
                            io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getEditProfileMethod(), responseObserver);
    }

    /**
     */
    public void getTransactions(UserCustomerGetTransactionsRequest request,
                                io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTransactionsMethod(), responseObserver);
    }

    /**
     * <pre>
     *    rpc ApplyForStatement (UserCustomerApplyForStatementRequest) returns (Response);
     * </pre>
     */
    public void getPayees(UserCustomerGetPayeesRequest request,
                          io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPayeesMethod(), responseObserver);
    }

    /**
     */
    public void addPayee(UserCustomerAddPayeeRequest request,
                         io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getAddPayeeMethod(), responseObserver);
    }

    /**
     */
    public void removePayee(UserCustomerRemovePayeeRequest request,
                            io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getRemovePayeeMethod(), responseObserver);
    }

    /**
     */
    public void transfer(UserCustomerTransferRequest request,
                         io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getTransferMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAccountsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                UserCustomerGetAccountsRequest,
                Response>(
                  this, METHODID_GET_ACCOUNTS)))
          .addMethod(
            getGetProfileMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                UserCustomerGetProfileRequest,
                Response>(
                  this, METHODID_GET_PROFILE)))
          .addMethod(
            getEditProfileMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                UserCustomerEditProfileRequest,
                Response>(
                  this, METHODID_EDIT_PROFILE)))
          .addMethod(
            getGetTransactionsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                UserCustomerGetTransactionsRequest,
                Response>(
                  this, METHODID_GET_TRANSACTIONS)))
          .addMethod(
            getGetPayeesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                UserCustomerGetPayeesRequest,
                Response>(
                  this, METHODID_GET_PAYEES)))
          .addMethod(
            getAddPayeeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                UserCustomerAddPayeeRequest,
                Response>(
                  this, METHODID_ADD_PAYEE)))
          .addMethod(
            getRemovePayeeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                UserCustomerRemovePayeeRequest,
                Response>(
                  this, METHODID_REMOVE_PAYEE)))
          .addMethod(
            getTransferMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                UserCustomerTransferRequest,
                Response>(
                  this, METHODID_TRANSFER)))
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
    public void getAccounts(UserCustomerGetAccountsRequest request,
                            io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAccountsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getProfile(UserCustomerGetProfileRequest request,
                           io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetProfileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void editProfile(UserCustomerEditProfileRequest request,
                            io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEditProfileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTransactions(UserCustomerGetTransactionsRequest request,
                                io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTransactionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *    rpc ApplyForStatement (UserCustomerApplyForStatementRequest) returns (Response);
     * </pre>
     */
    public void getPayees(UserCustomerGetPayeesRequest request,
                          io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPayeesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addPayee(UserCustomerAddPayeeRequest request,
                         io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddPayeeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removePayee(UserCustomerRemovePayeeRequest request,
                            io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemovePayeeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void transfer(UserCustomerTransferRequest request,
                         io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTransferMethod(), getCallOptions()), request, responseObserver);
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
    public Response getAccounts(UserCustomerGetAccountsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAccountsMethod(), getCallOptions(), request);
    }

    /**
     */
    public Response getProfile(UserCustomerGetProfileRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetProfileMethod(), getCallOptions(), request);
    }

    /**
     */
    public Response editProfile(UserCustomerEditProfileRequest request) {
      return blockingUnaryCall(
          getChannel(), getEditProfileMethod(), getCallOptions(), request);
    }

    /**
     */
    public Response getTransactions(UserCustomerGetTransactionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTransactionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *    rpc ApplyForStatement (UserCustomerApplyForStatementRequest) returns (Response);
     * </pre>
     */
    public Response getPayees(UserCustomerGetPayeesRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetPayeesMethod(), getCallOptions(), request);
    }

    /**
     */
    public Response addPayee(UserCustomerAddPayeeRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddPayeeMethod(), getCallOptions(), request);
    }

    /**
     */
    public Response removePayee(UserCustomerRemovePayeeRequest request) {
      return blockingUnaryCall(
          getChannel(), getRemovePayeeMethod(), getCallOptions(), request);
    }

    /**
     */
    public Response transfer(UserCustomerTransferRequest request) {
      return blockingUnaryCall(
          getChannel(), getTransferMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<Response> getAccounts(
        UserCustomerGetAccountsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAccountsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> getProfile(
        UserCustomerGetProfileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetProfileMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> editProfile(
        UserCustomerEditProfileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getEditProfileMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> getTransactions(
        UserCustomerGetTransactionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTransactionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *    rpc ApplyForStatement (UserCustomerApplyForStatementRequest) returns (Response);
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> getPayees(
        UserCustomerGetPayeesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPayeesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> addPayee(
        UserCustomerAddPayeeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddPayeeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> removePayee(
        UserCustomerRemovePayeeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRemovePayeeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> transfer(
        UserCustomerTransferRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTransferMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ACCOUNTS = 0;
  private static final int METHODID_GET_PROFILE = 1;
  private static final int METHODID_EDIT_PROFILE = 2;
  private static final int METHODID_GET_TRANSACTIONS = 3;
  private static final int METHODID_GET_PAYEES = 4;
  private static final int METHODID_ADD_PAYEE = 5;
  private static final int METHODID_REMOVE_PAYEE = 6;
  private static final int METHODID_TRANSFER = 7;

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

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ACCOUNTS:
          serviceImpl.getAccounts((UserCustomerGetAccountsRequest) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_GET_PROFILE:
          serviceImpl.getProfile((UserCustomerGetProfileRequest) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_EDIT_PROFILE:
          serviceImpl.editProfile((UserCustomerEditProfileRequest) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_GET_TRANSACTIONS:
          serviceImpl.getTransactions((UserCustomerGetTransactionsRequest) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_GET_PAYEES:
          serviceImpl.getPayees((UserCustomerGetPayeesRequest) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_ADD_PAYEE:
          serviceImpl.addPayee((UserCustomerAddPayeeRequest) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_REMOVE_PAYEE:
          serviceImpl.removePayee((UserCustomerRemovePayeeRequest) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_TRANSFER:
          serviceImpl.transfer((UserCustomerTransferRequest) request,
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

  private static abstract class UserCustomerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserCustomerBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return BankProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserCustomer");
    }
  }

  private static final class UserCustomerFileDescriptorSupplier
      extends UserCustomerBaseDescriptorSupplier {
    UserCustomerFileDescriptorSupplier() {}
  }

  private static final class UserCustomerMethodDescriptorSupplier
      extends UserCustomerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserCustomerMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserCustomerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserCustomerFileDescriptorSupplier())
              .addMethod(getGetAccountsMethod())
              .addMethod(getGetProfileMethod())
              .addMethod(getEditProfileMethod())
              .addMethod(getGetTransactionsMethod())
              .addMethod(getGetPayeesMethod())
              .addMethod(getAddPayeeMethod())
              .addMethod(getRemovePayeeMethod())
              .addMethod(getTransferMethod())
              .build();
        }
      }
    }
    return result;
  }
}
