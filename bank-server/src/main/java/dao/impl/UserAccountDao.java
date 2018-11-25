package dao.impl;

import dao.IUserAccountDao;
import entity.UserAccountEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtils;

import java.util.List;

public class UserAccountDao implements IUserAccountDao {
    private static IUserAccountDao userAccountDao = null;
    Session session = HibernateUtils.getSessionFactory().openSession();

    private UserAccountDao() {

    }

    public static IUserAccountDao getInstance() {
        if(userAccountDao == null) {
            userAccountDao = new UserAccountDao();
        }
        return userAccountDao;
    }

    @Override
    public Long getBiggestUserAccountNumber() {
        try {
            session.getTransaction().begin();
            String hql ="select accountNumber from UserAccountEntity order by accountNumber desc ";
            Query query = session.createQuery(hql);
            Long accountNumber = (Long) query.setMaxResults(1).uniqueResult();
            session.getTransaction().commit();
            return accountNumber;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public UserAccountEntity getUserAccountByAccountNumber(Long accountNumber) {
        try {
            session.getTransaction().begin();
            String hql ="from UserAccountEntity where accountNumber=:accountNumber";
            Query query = session.createQuery(hql);
            query.setParameter("accountNumber", accountNumber);
            UserAccountEntity result = (UserAccountEntity)query.uniqueResult();
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public List<UserAccountEntity> getUserAccountByUserId(Long userId) {
        try {
            session.getTransaction().begin();
            String hql = "from UserAccountEntity where userId=:userId";
            Query query = session.createQuery(hql);
            query.setParameter("userId", userId);
            List<UserAccountEntity> result = (List<UserAccountEntity>)query.getResultList();
            session.getTransaction().commit();
            return result;

        } catch (Exception E) {
            E.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public UserAccountEntity getUserAccountByIBAN(String iban) {
        try {
            session.getTransaction().begin();
            String hql ="from UserAccountEntity where iban=:iban";
            Query query = session.createQuery(hql);
            query.setParameter("iban", iban);
            UserAccountEntity result = (UserAccountEntity)query.uniqueResult();
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public UserAccountEntity getUserAccountByPK(Long id) {
        try {
            session.getTransaction().begin();
            String hql ="from UserAccountEntity where userId=:userId";
            Query query = session.createQuery(hql);
            query.setParameter("userId", id);
            UserAccountEntity result = (UserAccountEntity)query.uniqueResult();
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public Integer updateUserAccountByBalanceAndPk(Double balance, Long account_pk) {
        try {
            session.getTransaction().begin();
            Query query = session.createQuery("update UserAccountEntity set balance =:balance where id=:id");
            query.setParameter("balance", balance).setParameter("id", account_pk);
            int updateRows = query.executeUpdate();


            // refresh entity for updating the data in the session
            Query query2 = session.createQuery("from UserAccountEntity where id=:id");
            query2.setParameter("id", account_pk);
            UserAccountEntity result = (UserAccountEntity) query2.uniqueResult();
            session.update(result);
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
    public Integer updateUserAccountByBalanceAndIban(Double balance, String iban) {
        try {
            session.getTransaction().begin();
            Query query = session.createQuery("update UserAccountEntity set balance =:balance + balance where iban=:iban");
            query.setParameter("balance", balance).setParameter("iban", iban);
            int updateRows = query.executeUpdate();
            session.getTransaction().commit();

            // refresh entity for updating the data in the session
            Query query2 = session.createQuery("from UserAccountEntity where iban=:iban");
            query2.setParameter("iban", iban);
            UserAccountEntity result = (UserAccountEntity) query2.uniqueResult();
            session.update(result);
            return updateRows;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public void createUserAccount(UserAccountEntity userAccountEntity) {
        try{
            session.getTransaction().begin();
            session.save(userAccountEntity);
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return;
        }
    }

}
