package com.swkang.springboot.springbootintegration.tesk;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务业务类
 */
@Component
public class TestTask {

    @Scheduled(fixedRate = 2000)  //每隔两秒钟执行一次
    public void sum(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前时间： "+ sdf.format(new Date()));
    }
}
