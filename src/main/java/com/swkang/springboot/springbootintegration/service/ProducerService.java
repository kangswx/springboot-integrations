package com.swkang.springboot.springbootintegration.service;


import javax.jms.Destination;

/**
 * 消息队列生产者
 */
public interface ProducerService {

    /**
     * 指定消息队列和消息
     * @param destination
     * @param message
     */
    public void sendMessage(Destination destination, final String message);

    /**
     * 使用默认消息队列发送消息
     * @param message
     */
    public void sendMessage(final String message);

}
