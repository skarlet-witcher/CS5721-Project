package dao.impl;

import dao.IUserApplyDao;
import entity.UserApplyArchiveEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtils;

public class UserApplyDao implements IUserApplyDao {
    private static UserApplyDao userApplyDao = null;
    private Session session = HibernateUtils.getSessionFactory().openSession();

    private UserApplyDao() {

    }

    public static UserApplyDao getInstance() {
        if(userApplyDao == null) {
            userApplyDao = new UserApplyDao();
        }
        return userApplyDao;
    }

    public void requestAccountApply(UserApplyArchiveEntity UserApplyArchiveEntity) {
        try {
            session.getTransaction().begin();

            session.save(UserApplyArchiveEntity);

            session.getTransaction().commit();

        } catch (Exception E) {
            E.printStackTrace();
            session.getTransaction().rollback();

        }
    }

    public UserApplyArchiveEntity selectApplyByUserId(UserApplyArchiveEntity UserApplyArchiveEntity) {
            try {
                session.getTransaction().begin();
                Query query = session.createQuery("from UserApplyArchiveEntity where userId=? and accountType=? and cardType=?");
                query.setParameter(0, UserApplyArchiveEntity.getUserId());
                query.setParameter(1, UserApplyArchiveEntity.getAccountType());
                query.setParameter(2, UserApplyArchiveEntity.getCardType());
                session.getTransaction().commit();
                UserApplyArchiveEntity result = (UserApplyArchiveEntity) query.uniqueResult();
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                session.getTransaction().rollback();
                return null;
            }
    }
}
