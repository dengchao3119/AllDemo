package com.bsoft.rabbitmq.simple;

import java.awt.TexturePaint;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.bsoft.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;

/**
 * 
* @ClassName: Receive  
* @Description:  接收消息
* @author DENGCHAO
* @date 2018年6月8日 下午4:44:23  
*
 */
public class Receive {
	
	private static final String QUEUE_NAME = "test_simple_queue";
	public static void main(String[] args) throws IOException, TimeoutException {
		//获取连接
		Connection connection = ConnectionUtils.getConnection();
		//创建通道
		Channel channel = connection.createChannel();
		
        DefaultConsumer consumer = new DefaultConsumer(channel){
        	@Override
        	public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
        			throws IOException {
        		String msg = new String(body,"utf-8");
        		System.out.println("receiver msg:"+msg);
        	}
        };
        //监听队列
        channel.basicConsume(QUEUE_NAME, true, consumer);
       
	}

}
