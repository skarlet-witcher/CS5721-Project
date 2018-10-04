package dao;

import org.hibernate.query.Query;

import controller.Interceptor;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import dao.HibernateUtils;
import model.Module;

public class DataAccess {
	private Session session;
	private SessionFactory factory;
	private String sqlQuery;

	private DataAccess() {
		factory = HibernateUtils.getSessionFactory();
		session = factory.withOptions().interceptor(new Interceptor()).openSession();
	}

	public static DataAccess dataAccess = null;

	public static DataAccess getInstance() {
		if (dataAccess == null) {
			return new DataAccess();
		}
		return dataAccess;
	}

	public List OperationsByList(String sql) {

		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			// Equivalent to the SQL statement:
			// Select e.* from module e
			sqlQuery = sql;

			// Create Query object.
			Query<Module> query = session.createQuery(sqlQuery);

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

	public void operationsForDeleteAndUpdate(String sql, Object object) {

		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create Query object.
			Query query = session.createQuery(sql);

			// Execute query.
			query.executeUpdate();
			
			session.update(object);
			session.getTransaction().commit();

			// return 1;
		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
			// return -1;
		}
	}

}
