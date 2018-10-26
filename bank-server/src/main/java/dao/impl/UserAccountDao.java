package dao.impl;

import dao.IUserAccountDao;
import entity.UserAccountEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtils;

import java.util.List;

public class UserAccountDao implements IUserAccountDao {
    private static IUserAccountDao userAccountDao = null;
    Session session = HibernateUtils.getSessionFactory().openSession();

    private UserAccountDao() {

    }

    public static IUserAccountDao getInstance() {
        if(userAccountDao == null) {
            userAccountDao = new UserAccountDao();
        }
        return userAccountDao;
    }

    @Override
    public Long getBiggestUserAccountNumber() {
        try {
            session.getTransaction().begin();
            String hql ="select accountNumber from UserAccountEntity order by accountNumber desc ";
            Query query = session.createQuery(hql);
            Long accountNumber = (Long) query.setMaxResults(1).uniqueResult();
            session.getTransaction().commit();
            return accountNumber;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public UserAccountEntity getUserAccountByAccountNumber(long accountNumber) {
        try {
            session.getTransaction().begin();
            String hql ="from UserAccountEntity where accountNumber=?";
            Query query = session.createQuery(hql);
            query.setParameter(0, accountNumber);
            UserAccountEntity result = (UserAccountEntity)query.uniqueResult();
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
            return null;
        }
    }
}
