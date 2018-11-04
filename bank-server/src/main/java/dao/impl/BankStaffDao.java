package dao.impl;

import bankStaff_rpc.ListUserApplyArchiveEntitiesResponse;
import bankStaff_rpc.UserApplyArchiveEntitiesResponse;
import dao.IBankStaffDao;
import entity.BankStaffEntity;
import entity.UserApplyArchiveEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtils;
import util.TimestampConvertHelper;

import java.util.ArrayList;
import java.util.List;

public class BankStaffDao implements IBankStaffDao {
    private static IBankStaffDao instance = null;
    Session session = HibernateUtils.getSessionFactory().openSession();

    public static IBankStaffDao getInstance() {
        if (instance == null) {
            return new BankStaffDao();
        }
        return instance;
    }

    public Long selectTheBiggestId() {
        try {
            session.getTransaction().begin();
            Query query = session.createQuery("select id from BankStaffEntity order by id desc ");

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
    public BankStaffEntity selectStaffByIdAndPassword(Long staffId, String password) {
        try {
            session.getTransaction().begin();
            Query query = session.createQuery("from BankStaffEntity where staffId = ? and password = ? ");
            query.setParameter(0, staffId).setParameter(1,password);

            BankStaffEntity bankStaffEntity = (BankStaffEntity) query.setMaxResults(1).uniqueResult();

            session.getTransaction().commit();
            return bankStaffEntity;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public ListUserApplyArchiveEntitiesResponse selectUserApplyArchiveEntity() {
        try {
            session.getTransaction().begin();
            Query query = session.createQuery("from UserApplyArchiveEntity ");

            List<UserApplyArchiveEntity> userApplyArchiveEntity =  query.getResultList();
            List<UserApplyArchiveEntitiesResponse> insertList = new ArrayList<>();
            ListUserApplyArchiveEntitiesResponse returnlist = ListUserApplyArchiveEntitiesResponse.newBuilder().build();
            for (UserApplyArchiveEntity x: userApplyArchiveEntity) {
                UserApplyArchiveEntitiesResponse.Builder builder = UserApplyArchiveEntitiesResponse.newBuilder();
                if(x.getNewUserApply() != null ){
                    builder.setNewUserApply(x.getNewUserApply());
                }
                if(x.getApplyTime() != null){
                    builder.setApplyTime(TimestampConvertHelper.mysqlToRpc(x.getApplyTime()));
                }
                if(x.getParentUserId() != null){
                    builder.setParentUserId(x.getParentUserId());
                }
                if(x.getAccountType() != null){
                    builder.setAccountType(x.getAccountType());
                }
                if(x.getAddress() != null){
                    builder.setAddress(x.getAddress());
                }
                if(x.getBirthDate() != null){
                    builder.setBirthDate(TimestampConvertHelper.mysqlToRpc(x.getBirthDate()));
                }
                if(x.getCardType() != null){
                    builder.setCardType(x.getCardType());
                }
                if(x.getEmail() != null){
                    builder.setEmail(x.getEmail());
                }
                if(x.getFirstName() != null){
                    builder.setFirstName(x.getFirstName());
                }
                if(x.getGender() != null){
                    builder.setGender(x.getGender());
                }
                if(x.getGraduateDate() != null){
                    builder.setGraduateDate(TimestampConvertHelper.mysqlToRpc(x.getGraduateDate()));
                }
                if(x.getId() != null){
                    builder.setId(x.getId());
                }
                if(x.getIdentityId() != null){
                    builder.setIdentityId(x.getIdentityId());
                }
                if(x.getIdentityIdType() != null){
                    builder.setIdentityIdType(x.getIdentityIdType());
                }
                if(x.getLastName() != null){
                    builder.setLastName(x.getLastName());
                }
                if(x.getParentFirstName() != null){
                    builder.setParentFirstName(x.getParentFirstName());
                }
                if(x.getParentLastName() != null){
                    builder.setParentLastName(x.getParentLastName());
                }
                if(x.getPhone() != null){
                    builder.setPhone(x.getPhone());
                }
                if(x.getRemark() != null){
                    builder.setRemark(x.getRemark());
                }
                if(x.getStatus() != null){
                    builder.setStatus(x.getStatus());
                }
                if(x.getStudentId()!=null){
                    builder.setStudentId(x.getStudentId());
                }
                if(x.getUniversity() != null){
                    builder.setUniversity(x.getUniversity());
                }
                UserApplyArchiveEntitiesResponse userApplyArchiveEntitiesResponse = builder.build();
                insertList.add(userApplyArchiveEntitiesResponse);

            }
            returnlist = ListUserApplyArchiveEntitiesResponse.newBuilder().addAllListUserApplyArchiveEntitiesResponse(insertList)
                    .setStatusCode(200)
                    .build();



            session.getTransaction().commit();
            return returnlist;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
}
