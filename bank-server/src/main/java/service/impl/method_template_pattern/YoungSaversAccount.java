package service.impl.method_template_pattern;

import java.sql.Timestamp;


public class YoungSaversAccount extends FeesTemplate implements IAccounts {
    public boolean checkAgeValidity(Timestamp dob){

        Timestamp curdate=new Timestamp(System.currentTimeMillis());
        String curYear=curdate.toString().substring(0,4);
        String birthYear=dob.toString().substring(0,4);
        Integer curInt= Integer.valueOf(curYear);
        Integer birInt=Integer.valueOf(birthYear);

        return (curInt - birInt) > 6 && (curInt - birInt) < 18;

    }

    double calculateQuarterlyMaintenanceFee(){
        return 1.25;
    }

    double calculateOverdraftFee(){
        return 0;
    }
}
