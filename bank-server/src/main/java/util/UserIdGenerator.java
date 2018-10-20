package util;

import dao.impl.UserDao;
import entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserIdGenerator {
    private static UserIdGenerator userIdGenerator = null;

    private UserIdGenerator() {

    }

    public static UserIdGenerator getInstance() {
        if(userIdGenerator == null) {
            userIdGenerator = new UserIdGenerator();
        }
        return userIdGenerator;
    }

    public long generateUserId() { // 10 digit userId
        long currentId = 1000000000;
        List<UserEntity> list = new ArrayList<UserEntity>();
        list = UserDao.getInstance().getUser();
        for(int i = 0; i < list.size(); i++) {
            if(list.size() <= 0) {
                break;
            }
            if(currentId == list.get(i).getUserId()) {
                currentId++;
            }
        }
        return currentId;
    }

}
