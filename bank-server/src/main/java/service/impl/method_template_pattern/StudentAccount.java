package service.impl.method_template_pattern;

import java.sql.Timestamp;

public class StudentAccount extends FeesTemplate implements IAccounts {
    public boolean checkAgeValidity(Timestamp dob){

        Timestamp curdate=new Timestamp(System.currentTimeMillis());
        String curYear=curdate.toString().substring(0,4);
        String birthYear=dob.toString().substring(0,4);
        Integer curInt= Integer.valueOf(curYear);
        Integer birInt=Integer.valueOf(birthYear);

        return (curInt - birInt) > 16;

    }

    double calculateQuarterlyMaintenanceFee(){
        return 0;
    }

    double calculateOverdraftFee(){
        return 0;
    }
}
