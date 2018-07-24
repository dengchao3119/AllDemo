package com.bsoft.rabbitmq.tx;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.bsoft.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class TxSend {

	private static final String QUEUE_NAME = "test_queue_tx";

	public static void main(String[] args) throws IOException, TimeoutException {

		// 获取连接
		Connection connection = ConnectionUtils.getConnection();
		// 从连接中获取一个通道
		Channel channel = connection.createChannel();
		// 创建队列声明
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		String msg = "hello tx";
		
		
		try {
			channel.txSelect();
			channel.basicPublish("", QUEUE_NAME, null,msg.getBytes());
			int aa = 1/0;
			System.out.println("send tx"+msg);
			channel.txCommit();
		} catch (Exception e) {
			channel.txRollback();
			System.out.println("send msg rollback!!!");
		}
		
		channel.close();
		connection.close();
	}

}
