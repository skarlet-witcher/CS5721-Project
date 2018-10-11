package rpc.impl;

import io.grpc.stub.StreamObserver;
import model.UserEntity;
import rpc.Response;
import rpc.UserLoginGrpc;
import rpc.UserLoginReply;
import rpc.UserLoginRequest;
import service.impl.LoginService;
import util.ResponseBuilder;

public class LoginRpcImpl extends UserLoginGrpc.UserLoginImplBase {
    @Override
    public void login(UserLoginRequest request, StreamObserver<Response> responseObserver) {
        UserEntity user = LoginService.getInstance().LoginByUsername(request.getUsername(), request.getPassword(), request.getRole());

        Response response;
        if (user != null) {
            response = ResponseBuilder.ResponseSuccessBuilder()
                    .setUserLogin(UserLoginReply.newBuilder()
                            .setUserId(user.getId())
                            .setFirstName(user.getFirstName())
                            .setLastName(user.getLastName())
                            .setPhone(user.getPhone())
                            .setAddress(user.getAddress())
                            .setUsername(user.getUsername())
                            .setEmail(user.getEmail()).build())
                    .build();
        } else {
            response = ResponseBuilder.ResponseFailBuilder("username or password error").build();
        }

        responseObserver.onNext(response);
        responseObserver.onCompleted();
//        super.login(request, responseObserver);
    }

}
