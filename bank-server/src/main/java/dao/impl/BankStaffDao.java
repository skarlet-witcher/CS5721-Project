package dao.impl;

import dao.IBankStaffDao;
import entity.BankStaffEntity;
import model.UserStaffEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtils;

import java.util.List;

public class BankStaffDao implements IBankStaffDao {
    private static BankStaffDao instance = null;
    Session session = HibernateUtils.getSessionFactory().openSession();

    public static BankStaffDao getInstance() {
        if (instance == null) {
            return new BankStaffDao();
        }
        return instance;
    }

    public BankStaffEntity LoginStaffByUsername(String username, String password) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from UserStaffEntity where username=? and password=?");
        query.setParameter(0, username).setParameter(1, password);
        query.setMaxResults(1);
        BankStaffEntity result = (BankStaffEntity) query.uniqueResult();
        return result;
    }

    public List<BankStaffEntity> getBankStaff() {
        try {

            // All the action with DB via Hibernate
            // must be located in one transaction.
            // Start Transaction.
            session.getTransaction().begin();

            // Create an HQL statement, query the object.
            // Equivalent to the SQL statement:
            String hql ="from BankStaffEntity b ";

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
