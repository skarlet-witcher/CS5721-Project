package dao;

import entity.UserEntity;

import java.util.Map;

public interface IUserDao {
    UserEntity LoginByUserIdAndPin(Long userId, Map<Integer, Integer> pin);

    UserEntity selectUserByUserId(Long userId);

    UserEntity selectUserById(Long id);

    Integer updateUserPinDigitById(Long id, String loginPinDigit);

    Integer updateUserStatusById(Long id, Integer status);

    Long selectTheBiggestId();

    UserEntity selectUserByIdAndName(Long parentUserId, String parentFirstName, String parentLastName);
}
