package service.impl.facade_pattern;

import Const.UserAccountType;
import entity.*;
import service.impl.command_pattern.*;
import service.impl.method_template_pattern.*;
import service.impl.method_template_pattern.PersonalAccount;

import java.sql.Timestamp;

import static Const.UserAccountType.PERSONAL_ACCOUNT;
import static Const.UserAccountType.STUDENT_ACCOUNT;
import static Const.UserAccountType.YOUNG_SAVER_ACCOUNT;
import static Const.UserAccountType.GOLDEN_ACCOUNT;

/**
 * Created by user on 3/1/2019.
 * Facacde pattern is used in here to provide a common inerface to check conversion
 * eligibility for different accounts
 */

/*
    Intent: Provide a unified interface to a set of interfaces in a subsystem. Facade defines
            a higher-level interface that makes the subsystem easier to use.

     Participants:
     · Facade (Compiler)
        o knows which subsystem classes are responsible for a request.
        o delegates client requests to appropriate subsystem objects.
     · subsystem classes (Scanner, Parser, ProgramNode, etc.)
        o implement subsystem functionality.
        o handle work assigned by the Facade object.
        o have no knowledge of the facade; that is, they keep no references to it.
 */

public class ConversionEligibility {   // facade class
    //PersonalAccount personalAccount;
    //GoldenAccount goldenAccount;
    IAccounts newAccount;   // sub classes
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

    public boolean checkConversionEligibility(Integer currentAccountType, Integer newAccountType) throws NotEligibleException{
        curdate=new Timestamp(System.currentTimeMillis());
        if (currentAccountType == STUDENT_ACCOUNT && newAccountType ==PERSONAL_ACCOUNT ) {
            newAccount= new PersonalAccount();
            invoker.setCommand(new StudentAccCalculateExpiry(expiryChecker));

        }
        else if (currentAccountType == YOUNG_SAVER_ACCOUNT && newAccountType ==PERSONAL_ACCOUNT){
            newAccount= new PersonalAccount();
            invoker.setCommand(new YoungSaverAccCalculateExpiry(expiryChecker));

        }
        else if(currentAccountType == PERSONAL_ACCOUNT && newAccountType ==GOLDEN_ACCOUNT){
            newAccount= new GoldenAccount();
            invoker.setCommand(new PersonalAccCalculateExpiry(expiryChecker));
        }
        else{
            throw new NotEligibleException(1);//request.getAccountType());
        }
        expiredate = invoker.executeCommand();

        // 1.check if the account has expired 2. check if user is eligible for newAccount
        if(expiredate.before(curdate) && newAccount.checkAgeValidity(user.getBirthDate())){
            //perform some complex calculations to check eligibility
            return true;
        }
        return false;
    }
}


class NotEligibleException extends Exception{

    public NotEligibleException(int exceptionTypeAccount){
        System.out.println("Staff can convert only to Personal or Golden Savers account .Recieved "+ UserAccountType.getTypeName(exceptionTypeAccount));  //NeedLoggerInstead
    }

}


