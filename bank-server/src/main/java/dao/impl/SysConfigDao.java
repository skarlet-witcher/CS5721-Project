package dao.impl;

import dao.ISysConfigDao;
import entity.SysConfigEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtils;

public class SysConfigDao implements ISysConfigDao {
    private static ISysConfigDao instance = null;
    private Session session = HibernateUtils.getSessionFactory().openSession();

    public static ISysConfigDao getInstance() {
        if(instance == null) {
            instance = new SysConfigDao() {
            };
        }
        return instance;
    }

    @Override
    public String getValueByKey(String key) {
        try {
            session.getTransaction().begin();
            Query query = session.createQuery("select value from SysConfigEntity where confKey=?");

            query.setParameter(0, key);
            String value = (String) query.setMaxResults(1).uniqueResult();

            session.getTransaction().commit();
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public void addConfig(SysConfigEntity config) {
        try {
            session.getTransaction().begin();

            session.save(config);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    public void updateConfig(String key, String value) {
        try {
            session.getTransaction().begin();

            Query query = session.createQuery("update SysConfigEntity set value=? where confKey=?");
            query.setParameter(0, value);
            query.setParameter(1, key);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    public void deleteConfig(String key) {
        try {
            session.getTransaction().begin();

            Query query = session.createQuery("delete from SysConfigEntity where confKey=?");
            query.setParameter(0, key);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
