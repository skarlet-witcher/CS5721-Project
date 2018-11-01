package dao.impl;

import dao.IUserPayeeDao;
import entity.UserPayeeEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import rpc.UserPayeesReply;
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
    public void addPayee(UserPayeeEntity userPayeeEntity) {
        try {
            session.getTransaction().begin();

            session.save(userPayeeEntity);

            session.getTransaction().commit();
        } catch (Exception E) {
            E.printStackTrace();
            session.getTransaction().rollback();

        }
    }

    @Override
    public void removePayee(Long payee_pk, Long user_id) {
        try {
            session.getTransaction().begin();
            Query query = session.createQuery("delete from UserPayeeEntity where id=? and userId=?");
            query.setParameter(0, payee_pk);
            query.setParameter(1, user_id);
            session.getTransaction().commit();
        } catch (Exception E) {
            E.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
    }

    @Override
    public UserPayeeEntity checkDuplicatePayee(UserPayeeEntity userPayeeEntity) {
        try {
            session.getTransaction().begin();
            Query query = session.createQuery("From UserPayeeEntity where name=? or iban=?");
            query.setParameter(0, userPayeeEntity.getName());
            query.setParameter(1, userPayeeEntity.getIban());

            UserPayeeEntity result = (UserPayeeEntity)query.uniqueResult();
            session.getTransaction().commit();
            return result;
        } catch (Exception E) {
            E.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
            return null;
        }
    }
}
