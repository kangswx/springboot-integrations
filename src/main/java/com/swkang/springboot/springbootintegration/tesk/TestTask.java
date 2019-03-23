package com.swkang.springboot.springbootintegration.tesk;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务业务类
 */
@Component
public class TestTask {

    /**
     * cron  定时任务表达式
     * fixedRate  定时多久执行一次
     * fixedDelay 上一次执行结束时间点后xx秒再次执行
     * fixedDelayString  字符串形式，可以通过配置文件指定
     */
    //@Scheduled(fixedRate = 2000)  //每隔两秒钟执行一次
    //@Scheduled(fixedDelay = 2000)
    //@Scheduled(fixedDelayString = "2000")
    //@Scheduled(cron = "0/2 * * * * *")
    public void sum() throws InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前时间： "+ sdf.format(new Date()));
        Thread.sleep(5000L);
    }
}
