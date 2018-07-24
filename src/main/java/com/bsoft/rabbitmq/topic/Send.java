package com.bsoft.rabbitmq.topic;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.bsoft.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 
* @ClassName: Send  
* @Description:主题模式 
* @author DENGCHAO
* @date 2018年6月12日 上午9:30:58  
*
 */
public class Send {

	private static final String EXCHANGE_NAME = "test_exchange_topic";
	public static void main(String[] args) throws IOException, TimeoutException {
		
		
		Connection connection = ConnectionUtils.getConnection();

		Channel channel = connection.createChannel();
		
		channel.exchangeDeclare(EXCHANGE_NAME, "topic");
		
		String msg = "商品......";
		
		
		channel.basicPublish(EXCHANGE_NAME,"goods.delete", null, msg.getBytes());
		
		System.out.println("send topic:"+msg);
		
		channel.close();
		
		connection.close();
	}
	
	
}
