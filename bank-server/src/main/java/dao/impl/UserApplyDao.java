package dao.impl;

import com.google.protobuf.Timestamp;
import dao.IUserApplyDao;
import entity.BankApplyEntity;
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

    public void requestPersonalAccountApply(BankApplyEntity bankApplyEntity) {
        try {
            session.getTransaction().begin();

            session.save(bankApplyEntity);

            session.getTransaction().commit();

        } catch (Exception E) {
            E.printStackTrace();
            session.getTransaction().rollback();

        }
    }
}
