package dao.impl;


import entity.UserAccountEntity;
import entity.UserHistoryEntity;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import java.io.Serializable;

public class MyInterceptor extends EmptyInterceptor {


    // This method is called when an object gets created.
    public boolean onSave(Object entity, Serializable id,
                          Object[] state, String[] propertyNames, Type[] types) {
        if ( entity instanceof UserAccountEntity ) {
            System.out.println("Create Operation: A new account has been created.");
            return true;
        } else if (entity instanceof UserHistoryEntity) {
            System.out.println("Create History: An user history has been created.");
        }
        return false;
    }
}
