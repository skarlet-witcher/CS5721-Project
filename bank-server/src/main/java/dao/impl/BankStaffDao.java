package dao.impl;

import bankStaff_rpc.ListUserApplyArchiveEntitiesResponse;
import bankStaff_rpc.UserApplyArchiveEntitiesResponse;
import dao.IBankStaffDao;
import entity.BankStaffEntity;
import entity.UserApplyArchiveEntity;
import entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtils;
import util.TimestampConvertHelper;

import java.util.ArrayList;
import java.util.List;

import static Const.UserType.EXISTING_USER;

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
            session.getTransaction().commit();

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
                if(x.getUserId() != null){
                    builder.setUserId(x.getUserId());
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
                //If existing user, set these info to blank fields
                if(x.getNewUserApply() == EXISTING_USER){
//                    first name, lastname, email, phone, address, gender
                    session.getTransaction().begin();
                    Query findExistingUser = session.createQuery("from UserEntity where userId = ? ");
                    findExistingUser.setParameter(0,x.getUserId());
                    UserEntity existingUser = (UserEntity) findExistingUser.uniqueResult();

                    builder.setFirstName(existingUser.getFirstName());
                    builder.setLastName(existingUser.getLastName());
                    builder.setStatus(x.getStatus());
                    builder.setEmail(existingUser.getEmail());
                    builder.setBirthDate(TimestampConvertHelper.mysqlToRpc(existingUser.getBirthDate()));
                    builder.setPhone(existingUser.getPhone());
                    builder.setAddress(existingUser.getAddress());
                    builder.setGender(existingUser.getGender());
                    session.getTransaction().commit();

                }

                UserApplyArchiveEntitiesResponse userApplyArchiveEntitiesResponse = builder.build();
                insertList.add(userApplyArchiveEntitiesResponse);

            }
            returnlist = ListUserApplyArchiveEntitiesResponse.newBuilder().addAllListUserApplyArchiveEntitiesResponse(insertList)
                    .setStatusCode(200)
                    .build();



            return returnlist;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public UserApplyArchiveEntity selectOneApplication(Long application_id) {
        session.getTransaction().begin();
        Query query = session.createQuery("from UserApplyArchiveEntity where id=?");
        query.setParameter(0, application_id);
        UserApplyArchiveEntity userApplyArchiveEntity = (UserApplyArchiveEntity) query.uniqueResult();
        session.getTransaction().commit();

        return userApplyArchiveEntity;
    }

    @Override
    public void applyAnApplication(long application_Id) {
        session.getTransaction().begin();
        Query query2  = session.createQuery("update UserApplyArchiveEntity set status = ? where id=?");
        query2.setParameter(0, 1);
        query2.setParameter(1,application_Id);
        query2.executeUpdate();
        session.getTransaction().commit();

    }
}
