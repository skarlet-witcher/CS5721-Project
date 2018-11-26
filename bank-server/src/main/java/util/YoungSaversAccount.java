package util;

import java.sql.Timestamp;

/**
 * Created by user on 11/12/2018.
 */
public class YoungSaversAccount implements IAccounts {
    public boolean checkAgeValidity(Timestamp dob){

        Timestamp curdate=new Timestamp(System.currentTimeMillis());
        String curYear=curdate.toString().substring(0,4);
        String birthYear=dob.toString().substring(0,4);
        Integer curInt= Integer.valueOf(curYear);
        Integer birInt=Integer.valueOf(birthYear);

        if((curInt-birInt) >6 && (curInt-birInt) <18)
            return true;

        return false;
    }
}
