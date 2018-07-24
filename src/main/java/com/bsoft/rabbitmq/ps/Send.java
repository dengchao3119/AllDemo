package com.bsoft.rabbitmq.ps;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.cglib.proxy.Factory;

import com.bsoft.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 
* @ClassName: Send  
* @Description: 消息订阅  
* @author DENGCHAO
* @date 2018年6月11日 下午4:16:35  
*
 */
public class Send {
	
	private static final String EXCHANGE_NAME = "test_exchange_fanout";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		
		Connection connection = ConnectionUtils.getConnection();
		
		Channel channel = connection.createChannel();
		//声明交换机
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
		
		String msg = "hello";
		
		channel.basicPublish(EXCHANGE_NAME, "", null, msg.getBytes());
		
		System.out.println("send ps :"+msg);
		
		channel.close();
		
		connection.close();
	}

}
