package util;

import java.sql.Timestamp;

/**
 * Created by user on 11/11/2018.
 */
public class PersonalAccount extends FeesTemplate implements IAccounts {

    boolean isOverDraft=false;

    public boolean checkAgeValidity(Timestamp dob){

        Timestamp curdate=new Timestamp(System.currentTimeMillis());
        String curYear=curdate.toString().substring(0,4);
        String birthYear=dob.toString().substring(0,4);
        Integer curInt= Integer.valueOf(curYear);
        Integer birInt=Integer.valueOf(birthYear);

        if((curInt-birInt) >18 )
            return true;

        return false;
    }

     double calculateQuarterlyMaintenanceFee(){
        return 5;
    }

     double calculateOverdraftFee(){
         if(isOverDraft)
            return 10;
         else
             return 0;
    }
}
