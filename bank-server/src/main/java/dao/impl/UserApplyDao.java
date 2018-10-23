package dao.impl;

import com.google.protobuf.Timestamp;
import dao.IUserApplyDao;
import entity.BankApplyEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtils;

public class UserApplyDao implements IUserApplyDao {
    private static UserApplyDao userApplyDao = null;
    private Session session = HibernateUtils.getSessionFactory().openSession();

    private UserApplyDao() {

    }

    public static UserApplyDao getInstance() {
        if(userApplyDao == null) {
            userApplyDao = new UserApplyDao();
        }
        return userApplyDao;
    }

    public int requestPersonalAccountApply(BankApplyEntity bankApplyEntity) {
        try {
            session.getTransaction().begin();
            String hql = String.format("insert into BankApplyEntity (firstName, lastName, identityId, identityIdType, accountType, cardType, birthDate, address, email, phone, applyTime) values (:para1, :para2, :para3, :para4, :para5, :para6, :para7, :para8, :para9, :para10, :para11)");
            Query query = session.createQuery(hql);
            query.setParameter("para1", bankApplyEntity.getFirstName());
            query.setParameter("para2", bankApplyEntity.getLastName());
            query.setParameter("para3", bankApplyEntity.getIdentityId());
            query.setParameter("para4", bankApplyEntity.getIdentityIdType());
            query.setParameter("para5", bankApplyEntity.getAccountType());
            query.setParameter("para6", bankApplyEntity.getCardType());
            query.setParameter("para7", bankApplyEntity.getBirthDate());
            query.setParameter("para8", bankApplyEntity.getAddress());
            query.setParameter("para9", bankApplyEntity.getEmail());
            query.setParameter("para10", bankApplyEntity.getPhone());
            query.setParameter("para11", bankApplyEntity.getEmail());

            query.executeUpdate();
            session.getTransaction().commit();
            return 1;

        } catch (Exception E) {
            E.printStackTrace();
            session.getTransaction().rollback();
            return -1;
        }
    }
}
