package service.impl;

import Const.SysMailTemplateType;
import dao.IUserAccountDao;
import dao.IUserAccountTypeDao;
import dao.impl.UserAccountDao;
import entity.UserAccountEntity;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import service.ISysScheduleService;
import service.impl.method_template_pattern.FeesTemplate;

import java.text.MessageFormat;

import static service.impl.method_template_pattern.IAccounts.allAccounts;


public class SysScheduleService implements Job {
    private IUserAccountTypeDao userAccountTypeDao;
    private IUserAccountDao userAccountDao = UserAccountDao.getInstance();

    public static void applyFeesToAllAccounts() {
        JobDetail job = JobBuilder.newJob(SysScheduleService.class).build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("1 0 1 3,6,9,12 * ?");
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(scheduleBuilder).build();
        try {
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }

    public void execute(JobExecutionContext context) throws JobExecutionException {

        double feesToReduce = 0;
        double balance;
        FeesTemplate account;
        Long typeId;
        System.out.println("My First Quartz Scheduler");
        //run this
        //I should call calculateFees ,it will return fees should be reduced
        //have to fetch each user accounts and apply it
        try {
            for (String eachAccount : allAccounts) {
                account = (FeesTemplate) Class.forName(eachAccount).newInstance();
                //fetch id of account type
                typeId = userAccountTypeDao.getUserAccountTypeId(eachAccount);

                //fetch all accounts of id type

                for (UserAccountEntity userAccountEntity : userAccountDao.getAccountsByAccountType(typeId)) {
                    //apply fees for all
                    feesToReduce = account.calculateFees();

                    balance = userAccountEntity.getBalance() - feesToReduce;
                    if (balance > 0)
                        userAccountEntity.setBalance(balance);
                    else {
                        String mailTemplate = SysEmailService.getInstance().getMailTemplate(SysMailTemplateType.FORGET_USER_ID);
                        String formatEmail = MessageFormat.format(mailTemplate, "dummy", 0);
                        SysEmailService.getInstance().send("empathytxk@hotmail.com", "Nuclear Bank - Your Balance", formatEmail);
                    }

                }

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException r) {
            r.printStackTrace();
        } catch (IllegalAccessException i) {
            i.printStackTrace();
        }

    }

}
