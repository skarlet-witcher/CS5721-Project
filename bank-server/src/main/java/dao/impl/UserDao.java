package dao.impl;

import dao.IUserDao;
import model.UserEntity;
import model.UserStaffEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtils;

public class UserDao implements IUserDao {
    private static UserDao instance = null;

    public static UserDao getInstance() {
        if (instance == null) {
            return new UserDao();
        }
        return instance;
    }

    public UserEntity LoginCustomerByUsername(String username, String password) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from UserEntity where username=? and password=?");
        query.setParameter(0, username).setParameter(1, password);
        query.setMaxResults(1);
        UserEntity result = (UserEntity) query.uniqueResult();
        return result;
    }

    public UserStaffEntity LoginStaffByUsername(String username, String password) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from UserStaffEntity where username=? and password=?");
        query.setParameter(0, username).setParameter(1, password);
        query.setMaxResults(1);
        UserStaffEntity result = (UserStaffEntity) query.uniqueResult();
        return result;
    }
}
