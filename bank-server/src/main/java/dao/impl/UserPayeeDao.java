package dao.impl;

import dao.IUserPayeeDao;
import entity.UserPayeeEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtils;

import java.util.List;

public class UserPayeeDao implements IUserPayeeDao {
    private static IUserPayeeDao userPayeeDao = null;
    Session session = HibernateUtils.getSessionFactory().openSession();

    private UserPayeeDao() {}

    public static IUserPayeeDao getInstance() {
        if(userPayeeDao == null) {
            userPayeeDao = new UserPayeeDao();
        }
        return userPayeeDao;
    }



    @Override
    public List<UserPayeeEntity> getPayeeListById(Long userId) {
        try {
            session.getTransaction().begin();
            Query query = session.createQuery("from UserPayeeEntity where userId=?");
            query.setParameter(0, userId);
            List<UserPayeeEntity> userPayeeEntityList = (List<UserPayeeEntity>)query.getResultList();
            session.getTransaction().commit();
            return userPayeeEntityList;
        } catch (Exception E) {
            E.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public UserPayeeEntity addPayee(Long userId, String payeeName, String iban) {
        return null;
    }

    @Override
    public Integer removePayee(Long userId, String payeeName, String iban) {
        return null;
    }
}
