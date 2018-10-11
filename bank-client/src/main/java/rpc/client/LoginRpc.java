package rpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.examples.helloworld.GreeterGrpc;
import model.UserEntity;
import rpc.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Const.Server.SERVER_HOST;
import static Const.Server.SERVER_PORT;

public class LoginRpc {
    private static final Logger logger = Logger.getLogger(LoginRpc.class.getName());
    private static LoginRpc instance = null;

    public static LoginRpc getInstance() {
        if (instance == null) {
            return new LoginRpc();
        }
        return instance;
    }

    public UserEntity login(String username, String password, Integer role) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVER_HOST, SERVER_PORT)
                .usePlaintext().build();
        UserLoginGrpc.UserLoginBlockingStub blockingStub = UserLoginGrpc.newBlockingStub(channel);

        logger.info(username + " is requesting to login");
        UserLoginRequest request = UserLoginRequest.newBuilder()
                .setUsername(username)
                .setPassword(password)
                .setRole(role).build();
        Response response;

        response = blockingStub.login(request);

        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);

        if (response.getStatusCode() == 200) {
            logger.info(username + " login success.");
            UserLoginReply userLoginReply = response.getUserLogin();
            UserEntity user = new UserEntity();
            user.setUsername(userLoginReply.getUsername());
            user.setPhone(userLoginReply.getPhone());
            user.setAddress(userLoginReply.getAddress());
            user.setEmail(userLoginReply.getEmail());
            user.setLastName(userLoginReply.getLastName());
            user.setFirstName(userLoginReply.getFirstName());
            user.setId(userLoginReply.getUserId());
            return user;
        } else {
            logger.info(username + " login fail due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }

    }
}
