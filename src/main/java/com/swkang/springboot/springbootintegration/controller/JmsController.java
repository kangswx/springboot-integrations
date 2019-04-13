package com.swkang.springboot.springbootintegration.controller;

import com.swkang.springboot.springbootintegration.domain.JsonData;
import com.swkang.springboot.springbootintegration.service.ProducerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

@RestController
@RequestMapping("/api/v1/jms")
public class JmsController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("order")
    public Object order(String msg){
        //生成新的消息队列
        Destination destination = new ActiveMQQueue("order.queue");
        producerService.sendMessage(destination, msg);
        return JsonData.buildSuccess();
    }

    @GetMapping("common")
    public Object common(String msg){
        producerService.sendMessage(msg);
        return JsonData.buildSuccess();
    }

    /**
     * 发布消息生产者
     * @param msg
     * @return
     */
    @GetMapping("topic")
    public Object topic(String msg){
        System.out.println("msg: "+msg);
        producerService.publish(msg);
        return JsonData.buildSuccess();
    }

}
