package com.bsoft.rabbitmq.routing;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.bsoft.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 
 * @ClassName: Send
 * @Description: 路由模式
 * @author DENGCHAO
 * @date 2018年6月12日 上午8:47:17
 *
 */
public class Send {
	
	private static final String EXCHANGE_NAME = "test_exchange_direct";


	public static void main(String[] args) throws IOException, TimeoutException {
		
		Connection connection = ConnectionUtils.getConnection();

		Channel channel = connection.createChannel();
		
		channel.exchangeDeclare(EXCHANGE_NAME, "direct");
		
		String msg = "hello direct";
		
		String routingKey="info";
		channel.basicPublish(EXCHANGE_NAME,routingKey, null, msg.getBytes());
		
		System.out.println("send direct:"+msg);
		
		channel.close();
		
		connection.close();
		
		
	}

}
