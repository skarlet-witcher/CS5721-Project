package util;

import com.google.common.util.concurrent.AbstractScheduledService;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A template class to check and apply different fees needed for each type of account.
 */
public abstract class FeesTemplate {
    double fees;
    abstract double calculateQuarterlyMaintenanceFee();
    abstract double calculateOverdraftFee();

    public  final  double calculateFees(){
        fees=calculateQuarterlyMaintenanceFee();
        fees+=calculateOverdraftFee();
        return fees;
    }

}
