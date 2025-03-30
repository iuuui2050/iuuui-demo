package com.iuuui;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author iuuui
 * @time 2024/02/04 1400
 */
public class HelloJob implements Job {

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("================ start ====================");
        JobDetail job = jobExecutionContext.getJobDetail();
        System.out.println("job key：" + job.getKey());
        System.out.println("job description：" + job.getDescription());
        System.out.println("job jobClass：" + job.getJobClass().getName());

        System.out.println("job runTime：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(jobExecutionContext.getJobRunTime())));

        Trigger trigger = jobExecutionContext.getTrigger();
        System.out.println("trigger description：" + trigger.getDescription());
        System.out.println("trigger next Time：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(trigger.getNextFireTime()));
        System.out.println("================ end ====================");

    }

}
