package dao.impl;

import dao.IUserAccountDao;
import entity.UserAccountEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtils;

import java.util.List;

public class UserAccountDao implements IUserAccountDao {
    private static UserAccountDao userAccountDao = null;
    Session session = HibernateUtils.getSessionFactory().openSession();

    private UserAccountDao() {

    }

    public static UserAccountDao getInstance() {
        if(userAccountDao == null) {
            userAccountDao = new UserAccountDao();
        }
        return userAccountDao;
    }


    public List<UserAccountEntity> getUserAccountList() {
        try {

            // All the action with DB via Hibernate
            // must be located in one transaction.
            // Start Transaction.
            session.getTransaction().begin();

            // Create an HQL statement, query the object.
            // Equivalent to the SQL statement:
            String hql ="from UserAccountEntity u ";

            // Create Query object.
            Query query = session.createQuery(hql);


            // Execute query.
            List list = query.getResultList();

            // Commit data.
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
            return null;
        }
    }

    public List<UserAccountEntity> getUserAccountByAccountNumber(long accountNumber) {
        try {

            // All the action with DB via Hibernate
            // must be located in one transaction.
            // Start Transaction.
            session.getTransaction().begin();

            // Create an HQL statement, query the object.
            // Equivalent to the SQL statement:
            String hql ="from UserAccountEntity u where u.accountNumber = "+ accountNumber;

            // Create Query object.
            Query query = session.createQuery(hql);


            // Execute query.
            List list = query.getResultList();

            // Commit data.
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
            return null;
        }
    }
}
