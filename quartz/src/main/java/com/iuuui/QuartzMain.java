package com.iuuui;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author iuuui
 * @time 2024/02/04 1335
 */
public class QuartzMain {

    /**
     *
     */
    private static void demoOne() {
        Scheduler scheduler = null;
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();

            scheduler.start();

            JobDetail job = JobBuilder.newJob()
                    .withIdentity("jobName", "jobGroup")
                    .ofType(HelloJob.class)
                    .withDescription("哈哈哈哈哈哈JOB备注")
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger().startNow()
                    .withSchedule(
                            SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(3)
                            .repeatForever()
                    ).forJob("jobName", "jobGroup")
                    .withDescription("呵呵呵呵呵呵呵Trigger备注")
                    .build();

            scheduler.addJob(job, true, true);
            scheduler.scheduleJob(trigger);

            Thread.sleep(6000);

        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (scheduler != null) {
                try {
                    scheduler.shutdown(true);
                } catch (SchedulerException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        demoOne();


//        try {
//            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//            scheduler.start();
//
//            JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("job1", "group1").build();
//
//            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
//                    .startNow()
//                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(40).repeatForever())
//                    .build();
//
//
//            scheduler.scheduleJob(job, trigger);
//
//            Thread.sleep(6000);
//
//            scheduler.shutdown();
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


    }

}
