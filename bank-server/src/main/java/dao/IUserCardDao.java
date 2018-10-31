package dao;

import entity.UserCardEntity;

public interface IUserCardDao {
    UserCardEntity getCardByAccountId(Long accountId);
}
