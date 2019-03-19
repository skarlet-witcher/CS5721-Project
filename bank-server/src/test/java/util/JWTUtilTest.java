package util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import rpc.UserLoginReply;

import static org.junit.jupiter.api.Assertions.*;

class JWTUtilTest {

    @Test
    void tokenGenerate() {
        UserLoginReply userLoginReply = UserLoginReply.newBuilder().setUserId(1).build();
        assertDoesNotThrow(new Executable() {
            @Override
            public void execute() throws Throwable {
                JWTUtil.tokenGenerate(userLoginReply);
            }
        });
    }

    @Test
    void verifyJWTToken() {
        UserLoginReply userLoginReply = UserLoginReply.newBuilder().setUserId(1).build();
        String token = JWTUtil.tokenGenerate(userLoginReply);
        assertDoesNotThrow(()->{
            JWTUtil.verifyJWTToken(token);
        });

    }
}