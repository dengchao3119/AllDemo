package com.bsoft.rabbitmq.routing;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.bsoft.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;

public class Receive2 {
	
	private static final String QUEUE_NAME = "test_queue_direct2";
	private static final String EXCHANGE_NAME = "test_exchange_direct";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		
		Connection connection = ConnectionUtils.getConnection();

		final Channel channel = connection.createChannel();
		
		channel.queueDeclare(QUEUE_NAME, false,false, false, null);
		
		channel.queueBind(QUEUE_NAME, EXCHANGE_NAME,"error");
		channel.queueBind(QUEUE_NAME, EXCHANGE_NAME,"info");
		channel.queueBind(QUEUE_NAME, EXCHANGE_NAME,"warning");
		
		channel.basicQos(1);
		
		DefaultConsumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
					throws IOException {
				String msg = new String(body);
				System.out.println("[receive 2]:" + msg);

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					System.out.println("finish done");
					channel.basicAck(envelope.getDeliveryTag(), false);
				}
			}
		};

		// 监听队列
		channel.basicConsume(QUEUE_NAME, false, consumer);
	}

}
