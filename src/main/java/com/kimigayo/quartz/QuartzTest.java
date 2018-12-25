package com.kimigayo.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


public class QuartzTest {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        JobDetail jobDetail = JobBuilder.newJob(JobDemo.class).withIdentity("demoJob", "demoGroup").build();
        CronTrigger trigger = (CronTrigger) TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")// 定义名字和组
                .withSchedule(    //定义任务调度的时间间隔和次数
                        CronScheduleBuilder
                                .cronSchedule("0/2 * * * * ?")
                )
                .build();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
        Thread.currentThread().sleep(10000);
        CronTrigger trigger2 = (CronTrigger) TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")// 定义名字和组
                .withSchedule(    //定义任务调度的时间间隔和次数
                        CronScheduleBuilder
                                .cronSchedule("0/3 * * * * ?")
                )
                .build();
        scheduler.rescheduleJob(trigger2.getKey(), trigger2);
        Thread.currentThread().sleep(10000);
        scheduler.deleteJob(jobDetail.getKey());
        Thread.currentThread().sleep(10000);
    }
}
