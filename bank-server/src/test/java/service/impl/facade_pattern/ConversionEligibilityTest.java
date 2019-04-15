package service.impl.facade_pattern;

import entity.UserApplyArchiveEntity;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static Const.UserAccountType.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by user on 4/15/2019.
 */
class ConversionEligibilityTest {
    @Test
    void checkConversionEligibility() {
        UserApplyArchiveEntity userApplyArchiveEntity = new UserApplyArchiveEntity();
        userApplyArchiveEntity.setBirthDate(Timestamp.valueOf("1966-01-01 01:00:00"));
        userApplyArchiveEntity.setGraduateDate(Timestamp.valueOf("2022-01-01 01:00:00"));
        userApplyArchiveEntity.setApplyTime(Timestamp.valueOf("2018-11-22 12:17:55"));
        userApplyArchiveEntity.setAccountType(STUDENT_ACCOUNT);
        ConversionEligibility c = new ConversionEligibility(userApplyArchiveEntity);
        assertDoesNotThrow(()-> {
            System.out.println("Student to Personal");

        }
        );
        try {


            
            assertTrue(c.checkConversionEligibility(STUDENT_ACCOUNT, PERSONAL_ACCOUNT), "Successful Student->Personal");
            assertTrue(c.checkConversionEligibility(YOUNG_SAVER_ACCOUNT,PERSONAL_ACCOUNT),"Successful Young Savers->Personal");
            assertFalse(c.checkConversionEligibility(PERSONAL_ACCOUNT,STUDENT_ACCOUNT),"Not allowed Personal-> Student");
            assertFalse(c.checkConversionEligibility(PERSONAL_ACCOUNT,YOUNG_SAVER_ACCOUNT),"Not allowed Personal-> Young Saver");
            assertTrue(c.checkConversionEligibility(PERSONAL_ACCOUNT, GOLDEN_ACCOUNT));





        }
        catch(NotEligibleException e){
            e.printStackTrace();
        }
    }

}