package com.bsoft.rabbitmq.work;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.bsoft.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {
	
	private static final String QUEUE_NAME = "test_work_queue";
	
	public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
		//获取连接
		Connection connection = ConnectionUtils.getConnection();
	    //获取通道
		Channel channel = connection.createChannel();
		//声明队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		
		for (int i = 0; i < 50; i++) {
			
			String msg = "hello"+i;
			System.out.println("[work queue]send:"+msg);
			channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
			Thread.sleep(i*20);
		}
		channel.close();
		connection.close();
	}

}
