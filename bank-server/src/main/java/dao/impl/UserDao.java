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
    private Session session = HibernateUtils.getSessionFactory().openSession();

    public static UserDao getInstance() {
        if (instance == null) {
            return new UserDao();
        }
        return instance;
    }

    public UserEntity LoginByUserIdAndPin(Long userId, Map<Integer, Integer> pin) {
        try {
            session.getTransaction().begin();

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

            session.getTransaction().commit();

            String truePin = result.getPin();
            if (truePin.charAt(d1 - 1) == pin.get(d1) &&
                    truePin.charAt(d2 - 1) == pin.get(d2) &&
                    truePin.charAt(d3 - 1) == pin.get(d3)) {
                return result;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    public UserEntity selectUserByUserId(Long userId) {
        try {
            session.getTransaction().begin();
            Query query = session.createQuery("from UserEntity where userId=?");
            query.setParameter(0, userId);
            query.setMaxResults(1);
            UserEntity result = (UserEntity) query.uniqueResult();
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    public Long selectTheBiggestId() {
        try {
            session.getTransaction().begin();
            Query query = session.createQuery("select id from UserEntity order by id desc ");

            Long id = (Long) query.setMaxResults(1).uniqueResult();

            session.getTransaction().commit();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    public UserEntity selectUserById(Long id) {
        try {
            session.getTransaction().begin();
            Query query = session.createQuery("from UserEntity where id=?");
            query.setParameter(0, id);
            query.setMaxResults(1);
            session.getTransaction().commit();
            UserEntity result = (UserEntity) query.uniqueResult();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    public Integer updateUserPinDigitById(Long id, String loginPinDigit) {
        try {
            session.getTransaction().begin();
            Query query = session.createQuery("update UserEntity set loginPinDigit = ? where id=?");
            query.setParameter(0, loginPinDigit).setParameter(1, id);
            int updateRows = query.executeUpdate();
            session.getTransaction().commit();
            return updateRows;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    public Integer updateUserStatusById(Long id, Integer status) {
        try {
            session.getTransaction().begin();
            Query query = session.createQuery("update UserEntity set status = ? where id=?");
            query.setParameter(0, status).setParameter(1, id);
            int updateRows = query.executeUpdate();
            session.getTransaction().commit();
            return updateRows;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
}
