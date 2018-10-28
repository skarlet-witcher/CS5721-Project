package dao.impl;

import dao.IUserDao;
import entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import rpc.UserCustomerLoginGrpc;
import util.HibernateUtils;

import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.Map;
import java.util.logging.Logger;


public class UserDao implements IUserDao {
        private static IUserDao instance = null;
        private Session session = HibernateUtils.getSessionFactory().openSession();
        private static final Logger logger = Logger.getLogger(UserCustomerLoginGrpc.class.getName());

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

                //get digits
                Query q = session.createQuery("from UserEntity where userId=?");
                q.setParameter(0, userId);
                q.setMaxResults(1);
                UserEntity e = (UserEntity) q.uniqueResult();
                String pinDigit = e.getLoginPinDigit();

                logger.info("get loginPinDigit success");
                logger.info("login pin digit: " + pinDigit);

                int d1 = Integer.parseInt(String.valueOf(pinDigit.charAt(0)));
                int d2 = Integer.parseInt(String.valueOf(pinDigit.charAt(1)));
                int d3 = Integer.parseInt(String.valueOf(pinDigit.charAt(2)));

                logger.info("digit to input: " + d1 + " " + d2 + " " + d3);

                Query query = session.createQuery("from UserEntity where userId=?");
                query.setParameter(0, userId).setMaxResults(1);
                UserEntity result = (UserEntity) query.uniqueResult();

                session.getTransaction().commit();

                String truePin = result.getPin();

                logger.info("true pin in db: " + truePin.charAt(d1 - 1) + " " + truePin.charAt(d2 - 1) + " " + truePin.charAt(d3 - 1));
                logger.info("input pin: " + pin.get(d1) + " " + pin.get(d2) + " " + pin.get(d3));

                int truePin1 = Integer.valueOf(String.valueOf(truePin.charAt(d1 - 1)));
                int truePin2 = Integer.valueOf(String.valueOf(truePin.charAt(d2 - 1)));
                int truePin3 = Integer.valueOf(String.valueOf(truePin.charAt(d3 - 1)));

                int inputPin1 = pin.get(d1);
                int inputPin2 = pin.get(d2);
                int inputPin3 = pin.get(d3);

                logger.info("true pin in db: " + truePin1 + " " + truePin2 + " " + truePin3);
                logger.info("input pin: " + inputPin1 + " " + inputPin2 + " " + inputPin3);

                if ( (truePin1 == inputPin1) &&
                        (truePin2 == inputPin2)  &&
                        (truePin3== inputPin3) ) {
                    logger.info("correct!");
                    return result;
                } else {
                    logger.info("the expression is not correct!");
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
                session.getTransaction().commit();
                UserEntity result = (UserEntity) query.uniqueResult();
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
                session.getTransaction().commit();
                UserEntity result = (UserEntity) query.uniqueResult();
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

                // refresh entity for updating the data in the session
                Query query2 = session.createQuery("from UserEntity where id=?");
                query2.setParameter(0, id);
                UserEntity result = (UserEntity) query2.uniqueResult();
                session.refresh(result);
                session.getTransaction().commit();
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
