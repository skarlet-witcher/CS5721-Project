package dao.impl;

import dao.IUserApplyDao;
import entity.UserApplyArchiveEntity;
import org.hibernate.Session;
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
}
