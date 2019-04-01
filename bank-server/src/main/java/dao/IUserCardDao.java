package dao;

import entity.UserCardEntity;

public interface IUserCardDao {
    UserCardEntity getCardByAccountId(Long accountId);
    UserCardEntity getCardByCardNumber(Long cardNumber);

    void createUserCard(UserCardEntity userCardEntity);

}
