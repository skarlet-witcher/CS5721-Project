package rpc.impl;

import io.grpc.stub.StreamObserver;
import model.UserEntity;
import rpc.Response;
import rpc.UserLoginGrpc;
import rpc.UserLoginRequest;
import service.impl.LoginService;

public class LoginImpl extends UserLoginGrpc.UserLoginImplBase {
    @Override
    public void login(UserLoginRequest request, StreamObserver<Response> responseObserver) {
        UserEntity user = LoginService.getInstance().LoginByUsername(request.getUsername(), request.getPassword(), request.getRole());
        // TODO
        super.login(request, responseObserver);
    }

}
