package com.swkang.springboot.springbootintegration.controller;

import com.swkang.springboot.springbootintegration.async.AsyncTask;
import com.swkang.springboot.springbootintegration.domain.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private AsyncTask asyncTask;

    @GetMapping("async_task")
    public Object execTask() throws InterruptedException {
        long begin = System.currentTimeMillis();
        asyncTask.task1();
        asyncTask.task2();
        asyncTask.task3();
        long end = System.currentTimeMillis();
        System.out.println("task执行总耗时： "+(end - begin));
        return JsonData.buildSuccess((end - begin));
    }

    @GetMapping("async_future")
    public Object execFuture() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Future<String> task4 = asyncTask.task4();
        Future<String> task5 = asyncTask.task5();
        Future<String> task6 = asyncTask.task6();
        for(;;){
            if(task4.isDone() && task5.isDone() && task6.isDone()){
                break;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("future执行总耗时： "+(end - begin));
        return JsonData.buildSuccess((end - begin));
    }


}
