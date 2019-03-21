package service.impl.facade_pattern;

import entity.*;
import service.impl.command_pattern.*;
import service.impl.method_template_pattern.*;
import service.impl.method_template_pattern.PersonalAccount;

import java.sql.Timestamp;

import static Const.UserAccountType.PERSONAL_ACCOUNT;
import static Const.UserAccountType.STUDENT_ACCOUNT;
import static Const.UserAccountType.YOUNG_SAVER_ACCOUNT;

/**
 * Created by user on 3/1/2019.
 * Facacde pattern is used in here to provide a common inerface to check conversion
 * eligibility for different accounts
 */
public class ConversionEligibility {
    //PersonalAccount personalAccount;
    //GoldenAccount goldenAccount;
    IAccounts newAccount;
    //more accoutns might come in future
    Receiver expiryChecker;
    Invoker invoker;
    private UserApplyArchiveEntity user;
    Timestamp curdate;
    Timestamp expiredate;

    public ConversionEligibility(UserApplyArchiveEntity userApplyArchiveEntity) {
        this.user=userApplyArchiveEntity;

        invoker=new Invoker();
        expiryChecker=new Receiver(userApplyArchiveEntity);
    }

    //Student /Young savers -> Personal
    public boolean checkConversionEligibilityPersonalAccount(){
        newAccount= new PersonalAccount();
        curdate=new Timestamp(System.currentTimeMillis());
        if (user.getAccountType() == STUDENT_ACCOUNT) {
            //get the expiry date is calculated by the Receiver
            expiredate = invoker.executeCommand(new StudentAccCalculateExpiry(expiryChecker));
        }
        else if (user.getAccountType() == YOUNG_SAVER_ACCOUNT) {
            expiredate = invoker.executeCommand(new YoungSaverAccCalculateExpiry(expiryChecker));
        }
        else {
            //throw exception
        }
        // 1.check if the account has expired 2. check if user is eligible for personal account
        if(expiredate.before(curdate) && newAccount.checkAgeValidity(user.getBirthDate()) ){
            //perform some complex calculations to check eligibility
            return true;
        }
        return false;
    }

    //Personal -> Golden account
    public boolean checkConversionEligibilityGoldenAccount(){
        newAccount= new GoldenAccount();
        curdate=new Timestamp(System.currentTimeMillis());
        if (user.getAccountType() == PERSONAL_ACCOUNT) {
            expiredate = invoker.executeCommand(new PersonalAccCalculateExpiry(expiryChecker));
        }
        else{
            //throw exception
        }
        // 1.check if the account has expired 2. check if user is eligible for golden account
        if(expiredate.before(curdate) && newAccount.checkAgeValidity(user.getBirthDate())){

            //perform some complex calculations to check eligibility
            return true;
        }

        return false;
    }
}
