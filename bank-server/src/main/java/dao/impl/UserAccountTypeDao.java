package dao.impl;

import dao.IUserAccountTypeDao;
import entity.UserAccountTypeEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtils;

public class UserAccountTypeDao implements IUserAccountTypeDao {
    private static IUserAccountTypeDao userAccountTypeDao = null;
    Session session = HibernateUtils.getSessionFactory().openSession();

    private UserAccountTypeDao() {

    }

    public static IUserAccountTypeDao getInstance() {
        if(userAccountTypeDao == null) {
            userAccountTypeDao = new UserAccountTypeDao();
        }
        return userAccountTypeDao;
    }

    @Override
    public UserAccountTypeEntity getUserAccountType(Long accountType) {
        try {
            session.getTransaction().begin();
            String hql ="from UserAccountTypeEntity where id=?";
            Query query = session.createQuery(hql);
            query.setParameter(0, accountType);
            UserAccountTypeEntity result = (UserAccountTypeEntity)query.uniqueResult();
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
            return null;
        }
    }

    public Long getUserAccountTypeId(String accountTypeName) {
        try {
            session.getTransaction().begin();
            String hql =" Select UserAccountTypeEntity.id from UserAccountTypeEntity where name=?";
            Query query = session.createQuery(hql);
            query.setParameter(0, accountTypeName);
            Long result = (Long)query.uniqueResult();
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
