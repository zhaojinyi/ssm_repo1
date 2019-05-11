package com.zjy.demo;////////////////////////////////////////////////////////////////////
//                          _ooOoo_                               //
//                         o8888888o                              //
//                         88" . "88                              //
//                         (| ^_^ |)                              //
//                         O\  =  /O                              //
//                      ____/`---'\____                           //
//                    .'  \\|     |//  `.                         //
//                   /  \\|||  :  |||//  \                        //
//                  /  _||||| -:- |||||-  \                       //
//                  |   | \\\  -  /// |   |                       //
//                  | \_|  ''\---/''  |   |                       //
//                  \  .-\__  `-`  ___/-. /                       //
//                ___`. .'  /--.--\  `. . ___                     //
//              ."" '<  `.___\_<|>_/___.'  >'"".                  //
//            | | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
//            \  \ `-.   \_ __\ /__ _/   .-` /  /                 //
//      ========`-.____`-.___\_____/___.-`____.-'========         //
//                           `=---='                              //
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
//            佛祖保佑       永不宕机     永无BUG                    	  //
////////////////////////////////////////////////////////////////////

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Auther: 无聊的人
 * @Date: 2019/5/11
 * @Description: com.zjy.demo
 */
public class QuartzMain {

    public static void main(String[] args) throws SchedulerException {

        // 创建Job对象，你要做什么是
        JobDetail job = JobBuilder.newJob(QuartzDemo.class).build();

        /**
         * 简单的trigger触发时间，通过quartz提供一个方法来完成重复调用cron
         * triggerL按照cron的表达式来给定触发时间
         */

        //  创建trigger对象： 在什么时间做
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();

        //  创建schedular对象  在什么时间做什么事情
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(job, trigger);

        // 启动
        scheduler.start();
    }

}
