package dao.impl;

import dao.IUserDao;
import entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import rpc.UserCustomerLoginGrpc;
import util.HibernateUtils;

import java.sql.Timestamp;
import java.util.Map;
import java.util.logging.Logger;


public class UserDao implements IUserDao {
    private static final Logger logger = Logger.getLogger(UserCustomerLoginGrpc.class.getName());
    private static IUserDao instance = null;
    private Session session = HibernateUtils.getSessionFactory().openSession();

    public static IUserDao getInstance() {
        if (instance == null) {
            return new UserDao();
        }
        return instance;
    }

    @Override
    public UserEntity LoginByUserIdAndPin(Long userId, Map<Integer, Integer> pin) {
        try {

            session.getTransaction().begin();

            Query query = session.createQuery("from UserEntity where userId=?");
            query.setParameter(0, userId).setMaxResults(1);
            UserEntity user = (UserEntity) query.uniqueResult();

            String[] pinDigit = user.getLoginPinDigit().split("");
            String[] truePin = user.getPin().split("");

            int d1 = Integer.parseInt(pinDigit[0]);
            int d2 = Integer.parseInt(pinDigit[1]);
            int d3 = Integer.parseInt(pinDigit[2]);

            int truePin1 = Integer.valueOf(truePin[d1 - 1]);
            int truePin2 = Integer.valueOf(truePin[d2 - 1]);
            int truePin3 = Integer.valueOf(truePin[d3 - 1]);

            session.getTransaction().commit();

            if (truePin1 == pin.get(d1) &&
                    truePin2 == pin.get(d2) &&
                    truePin3 == pin.get(d3)) {
                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
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

    @Override
    public UserEntity selectUserByUserIdEmailDOB(Long userId, String email, Timestamp birthDate) {
        try {
            session.getTransaction().begin();
            Query query = session.createQuery("from UserEntity where userId=? and email=? and birthDate=?");
            query.setParameter(0, userId);
            query.setParameter(1, email);
            query.setParameter(2, birthDate);

            UserEntity result = (UserEntity) query.uniqueResult();
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }    }

    @Override
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

    @Override
    public UserEntity selectUserById(Long id) {
        try {
            session.getTransaction().begin();
            Query query = session.createQuery("from UserEntity where id=?");
            query.setParameter(0, id);
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

    @Override
    public UserEntity selectUserByNameDOBPhoneEmail(String firstName, String lastName, Timestamp birthDate, String phone, String email) {
        return null;
    }

    @Override
    public UserEntity selectUserByIdAndName(Long userId, String firstName, String lastName) {
        try {
            session.getTransaction().begin();
            Query query = session.createQuery("from UserEntity where userId=? and firstName=? and lastName=?");
            query.setParameter(0, userId);
            query.setParameter(1, firstName);
            query.setParameter(2, lastName);

            UserEntity result = (UserEntity) query.uniqueResult();
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public Integer updateUserPinDigitById(Long id, String loginPinDigit) {
        try {
            session.getTransaction().begin();
            Query query = session.createQuery("update UserEntity set loginPinDigit = ? where id=?");
            query.setParameter(0, loginPinDigit).setParameter(1, id);
            int updateRows = query.executeUpdate();
            session.getTransaction().commit();

            // refresh entity for updating the data in the session
            Query query2 = session.createQuery("from UserEntity where id=?");
            query2.setParameter(0, id);
            UserEntity result = (UserEntity) query2.uniqueResult();
            session.refresh(result);
            return updateRows;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public Integer updateUserPINByUserId(Long userId, String newPin) {
        try {
            session.getTransaction().begin();
            Query query = session.createQuery("update UserEntity set pin = ? where userId=?");
            query.setParameter(0, newPin).setParameter(1, userId);
            int updateRows = query.executeUpdate();
            session.getTransaction().commit();

            // refresh entity for updating the data in the session
            Query query2 = session.createQuery("from UserEntity where userId=?");
            query2.setParameter(0, userId);
            UserEntity result = (UserEntity) query2.uniqueResult();
            session.refresh(result);

            return updateRows;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
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
