package service.impl.method_template_pattern;

import java.sql.Timestamp;


public class PersonalAccount extends FeesTemplate implements IAccounts {

    boolean isOverDraft=false;

    public boolean checkAgeValidity(Timestamp dob){

        Timestamp curdate=new Timestamp(System.currentTimeMillis());
        String curYear=curdate.toString().substring(0,4);
        String birthYear=dob.toString().substring(0,4);
        Integer curInt= Integer.valueOf(curYear);
        Integer birInt=Integer.valueOf(birthYear);

        return (curInt - birInt) > 18;

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
