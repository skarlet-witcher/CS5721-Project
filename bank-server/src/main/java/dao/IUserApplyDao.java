package dao;

import entity.UserApplyArchiveEntity;

public interface IUserApplyDao {
    void requestAccountApply(UserApplyArchiveEntity userApplyArchiveEntity);

    UserApplyArchiveEntity selectApplyByUserId(UserApplyArchiveEntity UserApplyArchiveEntity);
}
