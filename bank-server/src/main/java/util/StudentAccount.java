package util;

import java.sql.Timestamp;

/**
 * Created by user on 11/12/2018.
 */
public class StudentAccount extends FeesTemplate implements IAccounts {
    public boolean checkAgeValidity(Timestamp dob){

        Timestamp curdate=new Timestamp(System.currentTimeMillis());
        String curYear=curdate.toString().substring(0,4);
        String birthYear=dob.toString().substring(0,4);
        Integer curInt= Integer.valueOf(curYear);
        Integer birInt=Integer.valueOf(birthYear);

        if((curInt-birInt) >16 )
            return true;

        return false;
    }

    double calculateQuarterlyMaintenanceFee(){
        return 0;
    }

    double calculateOverdraftFee(){
        return 0;
    }
}
