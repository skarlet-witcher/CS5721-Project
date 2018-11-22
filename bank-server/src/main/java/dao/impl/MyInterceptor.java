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
            System.out.println("Interceptor: A new account record will be created.");
            return true;
        } else if (entity instanceof UserHistoryEntity) {
            System.out.println("Interceptor: An user history record will be created.");
        }
        return false;
    }

}
