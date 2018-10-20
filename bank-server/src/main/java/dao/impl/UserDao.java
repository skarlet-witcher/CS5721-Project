package dao.impl;

import dao.IUserDao;
import entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtils;

import java.util.Map;

public class UserDao implements IUserDao {
    private static UserDao instance = null;

    public static UserDao getInstance() {
        if (instance == null) {
            return new UserDao();
        }
        return instance;
    }

    public UserEntity LoginByUserIdAndPin(Long userId, Map<Integer, Integer> pin) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();

        //get digits
        Query q = session.createQuery("from UserEntity where userId=?");
        UserEntity e = (UserEntity) q.setParameter(0, userId).setMaxResults(1).uniqueResult();
        String pinDigit = e.getLoginPinDigit();

        int d1 = Integer.parseInt(String.valueOf(pinDigit.charAt(0)));
        int d2 = Integer.parseInt(String.valueOf(pinDigit.charAt(1)));
        int d3 = Integer.parseInt(String.valueOf(pinDigit.charAt(2)));

        Query query = session.createQuery("from UserEntity where userId=?");
        query.setParameter(0, userId).setMaxResults(1);
        UserEntity result = (UserEntity) query.uniqueResult();

        String truePin = result.getPin();
        if (truePin.charAt(d1 - 1) == pin.get(d1) &&
                truePin.charAt(d2 - 1) == pin.get(d2) &&
                truePin.charAt(d3 - 1) == pin.get(d3)) {
            return result;
        } else {
            return null;
        }

    }

    public UserEntity selectUserByUserId(Long userId) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from UserEntity where userId=?");
        query.setParameter(0, userId);
        query.setMaxResults(1);
        UserEntity result = (UserEntity) query.uniqueResult();
        return result;
    }

    public UserEntity selectUserById(Long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from UserEntity where id=?");
        query.setParameter(0, id);
        query.setMaxResults(1);
        UserEntity result = (UserEntity) query.uniqueResult();
        return result;
    }

    public Integer updateUserPinDigitById(Long id, String loginPinDigit) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update UserEntity set loginPinDigit = ? where id=?");
        query.setParameter(0, loginPinDigit).setParameter(1, id);
        int updateRows = query.executeUpdate();
        transaction.commit();
        return updateRows;
    }

    public Integer updateUserStatusById(Long id, Integer status) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update UserEntity set status = ? where id=?");
        query.setParameter(0, status).setParameter(1, id);
        int updateRows = query.executeUpdate();
        transaction.commit();
        return updateRows;
    }
}
