package service.impl.command_pattern;

import entity.UserApplyArchiveEntity;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Receiver: the person who actually perform the execution.
 */
public class Receiver{
    /**
     * {@link UserApplyArchiveEntity}: to obtain the information of one user,
     * so as to calculate the expiry date based on that information.
     */
    private UserApplyArchiveEntity userApplyArchiveEntity;

    public Receiver(UserApplyArchiveEntity userApplyArchiveEntity) {
        this.userApplyArchiveEntity = userApplyArchiveEntity;
    }

    public Timestamp StudentAccExpire(){
        return userApplyArchiveEntity.getGraduateDate();
    }

    public Timestamp PersonalAccExpire() {
        ZonedDateTime zonedDateTime = userApplyArchiveEntity.getApplyTime().toInstant().atZone(ZoneId.of("UTC"));
        Timestamp expireTime = Timestamp.from(zonedDateTime.plus(3, ChronoUnit.YEARS).toInstant());
        return expireTime;
    }

    public Timestamp YoungSaverExpire(){
        ZonedDateTime zonedDateTime = userApplyArchiveEntity.getBirthDate().toInstant().atZone(ZoneId.of("UTC"));
        Timestamp expireTime = Timestamp.from(zonedDateTime.plus(18, ChronoUnit.YEARS).toInstant());
        return expireTime;
    }

    public Timestamp GoldenExpire() {
        ZonedDateTime zonedDateTime = userApplyArchiveEntity.getApplyTime().toInstant().atZone(ZoneId.of("UTC"));
        Timestamp expireTime = Timestamp.from(zonedDateTime.plus(100, ChronoUnit.YEARS).toInstant());
        return expireTime;
    }
}