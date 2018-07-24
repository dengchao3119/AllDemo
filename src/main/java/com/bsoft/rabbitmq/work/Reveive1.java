package com.bsoft.rabbitmq.work;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.bsoft.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;

public class Reveive1 {
	
	private static final String QUEUE_NAME = "test_work_queue";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		//获取连接
		Connection connection = ConnectionUtils.getConnection();
		//获取通道
		Channel channel = connection.createChannel();
		//声明队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		
		DefaultConsumer consumer = new DefaultConsumer(channel){
		     @Override
		    public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
		    		throws IOException {
		    	String msg = new String(body);
		    	System.out.println("[receive 1]:"+msg);
		    	
		    	try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		    	finally {
					System.out.println("finish done");
				}
		    }
		};
		
		//监听队列
		channel.basicConsume(QUEUE_NAME, true, consumer);
		
	}

}
