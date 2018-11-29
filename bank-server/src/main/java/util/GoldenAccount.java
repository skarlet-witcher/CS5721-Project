package util;

import java.sql.Timestamp;

/**
 * Created by user on 11/12/2018.
 */
public class GoldenAccount extends FeesTemplate implements IAccounts {
    boolean isOverDraft=false;
    public boolean checkAgeValidity(Timestamp dob){

        Timestamp curdate=new Timestamp(System.currentTimeMillis());
        String curYear=curdate.toString().substring(0,4);
        String birthYear=dob.toString().substring(0,4);
        Integer curInt= Integer.valueOf(curYear);
        Integer birInt=Integer.valueOf(birthYear);

        if((curInt-birInt) >66 )
            return true;

        return false;
    }


    double calculateQuarterlyMaintenanceFee(){
        return 1.25;
    }

    double calculateOverdraftFee(){
    if(isOverDraft)
            return 5;
        else
            return 0;
    }
}
