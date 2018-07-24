package com.bsoft.rabbitmq.confirm;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.bsoft.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send2 {
	private static final String QUEUE_NAME = "test_queue_confirm2";
	public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
		

		// 获取连接
		Connection connection = ConnectionUtils.getConnection();
		// 从连接中获取一个通道
		Channel channel = connection.createChannel();
		// 创建队列声明
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		//生产者调用confirmSelect（） 将channel设置为confirm模式
		channel.confirmSelect();
		String msString = "hello confirm!!";
		//批量发送
		for (int i = 0; i < 10; i++) {
			channel.basicPublish("", QUEUE_NAME, null, msString.getBytes());
		}
		
		if (!channel.waitForConfirms()) {
			System.out.println("send message error!");
		}
		else {
			System.out.println("send message ok!");
		}
		channel.close();
		connection.close();
		
	}

}
