package rpc.impl;

import io.grpc.stub.StreamObserver;
import rpc.Response;
import rpc.UserRequest;
import rpc.UserStaffAddAccountRequest;
import rpc.UserStaffGrpc;

public class UserStaffRpcImpl extends UserStaffGrpc.UserStaffImplBase {
    @Override
    public void addNewAccount(UserStaffAddAccountRequest request, StreamObserver<Response> responseObserver) {
        super.addNewAccount(request, responseObserver);
    }

    @Override
    public void removeAccount(UserRequest request, StreamObserver<Response> responseObserver) {
        super.removeAccount(request, responseObserver);
    }
}
