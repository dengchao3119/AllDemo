package com.bsoft.rabbitmq.spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	
	
	public static void main(String[] args) throws Exception {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationcontext.xml");
		RabbitTemplate template = context.getBean(RabbitTemplate.class);
		template.convertAndSend("hello world!!!");
		Thread.sleep(1000);
		context.destroy();
	}

}
