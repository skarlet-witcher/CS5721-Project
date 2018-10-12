package rpc.impl;

import io.grpc.stub.StreamObserver;
import rpc.*;

public class UserCustomerRpcImpl extends UserCustomerGrpc.UserCustomerImplBase {
    @Override
    public void editUserPhone(UserCustomerEditRequest request, StreamObserver<Response> responseObserver) {
        super.editUserPhone(request, responseObserver);
    }

    @Override
    public void editUserAddress(UserCustomerEditRequest request, StreamObserver<Response> responseObserver) {
        super.editUserAddress(request, responseObserver);
    }

    @Override
    public void getUserTransaction(UserRequest request, StreamObserver<Response> responseObserver) {
        super.getUserTransaction(request, responseObserver);
    }

    @Override
    public void getUserOperateLog(UserRequest request, StreamObserver<Response> responseObserver) {
        super.getUserOperateLog(request, responseObserver);
    }

    @Override
    public void makeTran(UserCustomerTranRequest request, StreamObserver<Response> responseObserver) {
        super.makeTran(request, responseObserver);
    }
}
