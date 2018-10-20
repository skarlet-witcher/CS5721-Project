package dao.impl;

import Const.UserOperateStatusType;
import Const.UserOperateType;
import dao.IUserOperationHistoryDao;
import entity.UserOperationHistoryEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtils;

import java.util.Date;
import java.util.List;

public class UserOperationHistoryDao implements IUserOperationHistoryDao {
    private static UserOperationHistoryDao instance = null;

    public static UserOperationHistoryDao getInstance() {
        if (instance == null) {
            return new UserOperationHistoryDao();
        }
        return instance;
    }

    public void addOperationHistory(UserOperationHistoryEntity operationHistory) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(operationHistory);

        transaction.commit();
    }

    public List<UserOperationHistoryEntity> getOperationHistoriesTodayByUserId(Long userId) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from UserOperationHistoryEntity " +
                "where userId = ? and " +
                "year(operateTime) = ? and " +
                "month(operateTime) = ? and " +
                "day(operateTime) = ? order by operateTime desc");
        query.setParameter(0, userId);
        query.setParameter(1, new Date().getYear());
        query.setParameter(2, new Date().getMonth());
        query.setParameter(3, new Date().getDay());

        return query.getResultList();
    }

    public UserOperationHistoryEntity getLastLoginRecordByUserId(Long userId) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from UserOperationHistoryEntity " +
                "where userId = ? and " +
                "operateType = ? and " +
                "status = ? " +
                "order by operateTime desc");
        query.setParameter(0, userId);
        query.setParameter(1, UserOperateType.LOGIN);
        query.setParameter(2, UserOperateStatusType.SUCCESS);
        query.setMaxResults(1);
        return (UserOperationHistoryEntity) query.uniqueResult();
    }

//    public int selectUserOperationHistoriesByUserId(Long userId) {
//        Session session = HibernateUtils.getSessionFactory().openSession();
//        session.beginTransaction();
//        Query query = session.createQuery("from UserEntity where userId=?");
//        query.setParameter(0, userId);
//        query.setMaxResults(1);
//
//        return result;
//    }
}
