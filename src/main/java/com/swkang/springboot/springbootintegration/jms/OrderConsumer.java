package com.swkang.springboot.springbootintegration.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消息队列消费者
 */
@Component
public class OrderConsumer {

    @JmsListener(destination = "order.queue")
    public void receivQueue(String text){
        System.out.println("OrderConsumer收到的报文为： "+text);
    }
}
