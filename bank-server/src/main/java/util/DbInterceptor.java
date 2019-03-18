package util;

import entity.UserAccountEntity;
import entity.UserHistoryEntity;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.logging.Logger;

public class DbInterceptor extends EmptyInterceptor {
    private static final Logger logger = Logger.getLogger(DbInterceptor.class.getName());

    public boolean onSave(Object entity, Serializable id,
                          Object[] state, String[] propertyNames, Type[] types) {
        if (entity instanceof UserAccountEntity) {
            logger.info("Interceptor: A new account record will be created.");
        } else if (entity instanceof UserHistoryEntity) {
            logger.info("Interceptor: An user history record will be created.");
        }
        return false;
    }
}
