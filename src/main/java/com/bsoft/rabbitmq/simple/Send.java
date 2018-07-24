package com.bsoft.rabbitmq.simple;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.bsoft.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {
	
	private static final String QUEUE_NAME = "test_simple_queue";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		//获取连接
		Connection connection = ConnectionUtils.getConnection();
		//从连接中获取一个通道
		Channel channel = connection.createChannel();
		//创建队列声明
		channel.queueDeclare(QUEUE_NAME, false,false, false,null);
		
		String msg = "hello world";
		
		channel.basicPublish("", QUEUE_NAME, null,msg.getBytes());
		
		System.out.println("send message successs");
		
		channel.close();
		
		connection.close();
		
	}

}
