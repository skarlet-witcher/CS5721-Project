package dao.impl;

import dao.IUserStaffDao;
import model.UserStaffEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtils;

public class UserStaffDao implements IUserStaffDao {
    private static UserStaffDao instance = null;

    public static UserStaffDao getInstance() {
        if (instance == null) {
            return new UserStaffDao();
        }
        return instance;
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
