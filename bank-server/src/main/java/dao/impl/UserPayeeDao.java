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
            Query query = session.createQuery("from UserPayeeEntity where userId=:userId");
            query.setParameter("userId", userId);
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
    public UserPayeeEntity getPayeeByPK(Long payee_pk) {
        try {
            session.getTransaction().begin();
            Query query = session.createQuery("From UserPayeeEntity where id=:id");
            query.setParameter("id", payee_pk);

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
            Query query = session.createQuery("delete from UserPayeeEntity where id=:id and userId=:userId");
            query.setParameter("id", payee_pk);
            query.setParameter("userId", user_id);
            query.executeUpdate();
            session.getTransaction().commit();

            Query query2 = session.createQuery("from UserPayeeEntity");
            for(UserPayeeEntity userPayeeEntity: (List<UserPayeeEntity>)query2.getResultList()) {
                session.refresh(userPayeeEntity);
            }

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
            Query query = session.createQuery("From UserPayeeEntity where name=:name and iban=:iban");
            query.setParameter("name", userPayeeEntity.getName());
            query.setParameter("iban", userPayeeEntity.getIban());

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
