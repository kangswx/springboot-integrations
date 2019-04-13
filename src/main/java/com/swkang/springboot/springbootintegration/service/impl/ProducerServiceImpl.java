package com.swkang.springboot.springbootintegration.service.impl;

import com.swkang.springboot.springbootintegration.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * 消息队列生产者
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;  //发送消息到broker的模板
    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;

    @Override
    public void sendMessage(Destination destination, String message) {
        this.jmsTemplate.convertAndSend(destination, message);
    }

    @Override
    public void sendMessage(String message) {
        this.jmsTemplate.convertAndSend(this.queue, message);
    }

    /**
     * 发布订阅
     * @param msg
     */
    @Override
    public void publish(String msg) {
        this.jmsTemplate.convertAndSend(this.topic, msg);
    }
}
