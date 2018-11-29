package service.impl.method_template_pattern;

import java.sql.Timestamp;


public class GoldenAccount extends FeesTemplate implements IAccounts {
    boolean isOverDraft=false;
    public boolean checkAgeValidity(Timestamp dob){

        Timestamp curdate=new Timestamp(System.currentTimeMillis());
        String curYear=curdate.toString().substring(0,4);
        String birthYear=dob.toString().substring(0,4);
        Integer curInt= Integer.valueOf(curYear);
        Integer birInt=Integer.valueOf(birthYear);

        return (curInt - birInt) > 66;

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
