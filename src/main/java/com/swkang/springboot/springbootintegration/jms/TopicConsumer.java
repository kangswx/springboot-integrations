package com.swkang.springboot.springbootintegration.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消息主题订阅
 */
@Component
public class TopicConsumer {

    @JmsListener(destination = "video.topic")
    public void receive(String text){
        System.out.println("TopicConsumer1收到订阅: "+text);
    }

    @JmsListener(destination = "video.topic")
    public void receive2(String text){
        System.out.println("TopicConsumer2收到订阅: "+text);
    }

    @JmsListener(destination = "video.topic")
    public void receive3(String text){
        System.out.println("TopicConsumer3收到订阅: "+text);
    }

}
