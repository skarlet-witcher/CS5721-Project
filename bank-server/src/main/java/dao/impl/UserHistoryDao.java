package dao.impl;

import Const.UserOperateStatusType;
import Const.UserOperateType;
import dao.IUserHistoryDao;
import entity.UserHistoryEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UserHistoryDao implements IUserHistoryDao {
    private static IUserHistoryDao instance = null;
    private Session session = HibernateUtils.getSessionFactory().openSession();

    public static IUserHistoryDao getInstance() {
        if (instance == null) {
            return new UserHistoryDao();
        }
        return instance;
    }

    @Override
    public int addOperationHistory(UserHistoryEntity operationHistory) {
        try {
            session.getTransaction().begin();
            session.save(operationHistory);
            session.getTransaction().commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return 0;
        }
    }

    @Override
    public List<UserHistoryEntity> getOperationHistoriesTodayByUserId(Long userId) {
        try {
            session.getTransaction().begin();

            Calendar calendar = Calendar.getInstance();

            Query query = session.createQuery("from UserHistoryEntity " +
                    "where userId = ? and " +
                    "year(operateTime) = ? and " +
                    "month(operateTime) = ? and " +
                    "day(operateTime) = ? order by operateTime desc");
            query.setParameter(0, userId);
            query.setParameter(1, calendar.get(Calendar.YEAR));
            query.setParameter(2, calendar.get(Calendar.MONTH) + 1);
            query.setParameter(3, calendar.get(Calendar.DAY_OF_MONTH));

            session.getTransaction().commit();

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public UserHistoryEntity getLastLoginRecordByUserId(Long userId) {
        try {

            session.getTransaction().begin();
            Query query = session.createQuery("from UserHistoryEntity " +
                    "where userId=:userId and " +
                    "operateType=:operateType and " +
                    "status=:status " +
                    "order by operateTime desc");
            query.setParameter("userId", userId);
            query.setParameter("operateType", UserOperateType.LOGIN);
            query.setParameter("status", UserOperateStatusType.SUCCESS);
            query.setMaxResults(1);
            session.getTransaction().commit();
            return (UserHistoryEntity) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public List<UserHistoryEntity> getTransactionHistory7Days(Long user_pk, Long account_pk) {
        try {
            session.getTransaction().begin();

            Calendar c = Calendar.getInstance();
            c.add(Calendar.DAY_OF_YEAR, -7);
            Date d = c.getTime();


            Query query = session.createQuery(" from UserHistoryEntity " +
                    "where userId=? and accountId=? and operateTime >= ? and operateType >=0 and operateType <= 3");
            query.setParameter(0, user_pk);
            query.setParameter(1, account_pk);
            query.setParameter(2, d);
            session.getTransaction().commit();

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public List<UserHistoryEntity> getTransactionHistory1Month(Long user_pk, Long account_pk) {
        try {
            session.getTransaction().begin();

            int month = Calendar.getInstance().get(Calendar.MONTH) - 1;
            int year = Calendar.getInstance().get(Calendar.YEAR);

            Query query = session.createQuery(" from UserHistoryEntity where userId=? and accountId=? and month(operateTime) >= ? and year(operateTime) >= ? and operateType >= 0 and operateType <= 3");
            query.setParameter(0, user_pk);
            query.setParameter(1, account_pk);
            query.setParameter(2, month);
            query.setParameter(3, year);
            session.getTransaction().commit();

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public List<UserHistoryEntity> getTransactionHistory6Month(Long user_pk, Long account_pk) {
        try {
            session.getTransaction().begin();

            int month = Calendar.getInstance().get(Calendar.MONTH) - 1 - 6;
            int year = Calendar.getInstance().get(Calendar.YEAR);

            Query query = session.createQuery(" from UserHistoryEntity where userId=? and accountId=? and month(operateTime) >= ? and year(operateTime) >= ? and operateType >= 0 and operateType <= 3");
            query.setParameter(0, user_pk);
            query.setParameter(1, account_pk);
            query.setParameter(2, month);
            query.setParameter(3, year);
            session.getTransaction().commit();

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public List<UserHistoryEntity> getTransactionHistory1Year(Long user_pk, Long account_pk) {
        try {
            session.getTransaction().begin();

            int year = Calendar.getInstance().get(Calendar.YEAR) - 1;

            Query query = session.createQuery(" from UserHistoryEntity where userId=? and accountId=? and year(operateTime) >= ?  and operateType >= 0 and operateType <= 3");
            query.setParameter(0, user_pk);
            query.setParameter(1, account_pk);
            query.setParameter(2, year);
            session.getTransaction().commit();

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
}
