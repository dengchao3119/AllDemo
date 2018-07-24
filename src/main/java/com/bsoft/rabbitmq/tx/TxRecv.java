package com.bsoft.rabbitmq.tx;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.bsoft.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;

public class TxRecv {
	private static final String QUEUE_NAME = "test_queue_tx";

	public static void main(String[] args) throws IOException, TimeoutException {

		// 获取连接
		Connection connection = ConnectionUtils.getConnection();
		// 从连接中获取一个通道
		Channel channel = connection.createChannel();
		
		channel.basicConsume(QUEUE_NAME, true, new DefaultConsumer(channel){
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
					throws IOException {
				System.out.println("receive msg:"+new String(body,"utf-8"));
			}
		});
		
		
	}

}
