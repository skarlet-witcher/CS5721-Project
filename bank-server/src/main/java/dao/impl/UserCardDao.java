package dao.impl;

import dao.IUserCardDao;
import entity.UserCardEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtils;

public class UserCardDao implements IUserCardDao {
    private static IUserCardDao userCardDao = null;
    Session session = HibernateUtils.getSessionFactory().openSession();

    private UserCardDao() {

    }

    public static IUserCardDao getInstance() {
        if(userCardDao == null) {
            userCardDao = new UserCardDao();
        }
        return userCardDao;
    }

    @Override
    public UserCardEntity getCardByAccountId(Long accountId) {
        try {
            session.getTransaction().begin();

            String hql = "from UserCardEntity where accountId=?1";
            Query query = session.createQuery(hql);
            query.setParameter(1, accountId);
            UserCardEntity result = (UserCardEntity) query.uniqueResult();
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
