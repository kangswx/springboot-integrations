package com.swkang.springboot.springbootintegration;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.Queue;
import javax.jms.Topic;

@SpringBootApplication
@EnableScheduling        //扫描定时任务
@EnableAsync             //开启异步任务
@EnableJms               //开启jms
public class SpringbootIntegrationApplication {

	/**
	 * 添加默认消息队列
	 * @return
	 */
	@Bean                //将消息队列添加到spring容器，方便后续进行注入
	public Queue queue(){
		return new ActiveMQQueue("common.queue");
	}

	/**
	 * 添加默认主题
	 * @return
	 */
	@Bean
	public Topic topic(){
		return new ActiveMQTopic("video.topic");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootIntegrationApplication.class, args);
	}

}
