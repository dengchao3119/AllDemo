package com.bsoft.rabbitmq.utils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 
* @ClassName: ConnectionUtils  
* @Description: MQ连接工具类
* @author DENGCHAO
* @date 2018年6月8日 下午4:13:01  
*
 */
public class ConnectionUtils {
	
	/**
	 * @throws TimeoutException 
	 * @throws IOException 
	 * 
	* @Title: getConnection  
	* @Description: 获取连接  
	* @param @return    设定文件  
	* @return ConnectionUtils    返回类型  
	* @throws
	 */
	public static Connection getConnection() throws IOException, TimeoutException{
		
		ConnectionFactory factory = new ConnectionFactory();
		//设置主机
		factory.setHost("127.0.0.1");
		//设置端口
		factory.setPort(5672);
        //设置vhost
		factory.setVirtualHost("/vhost_mq");
	    //设置用户名
		factory.setUsername("user_mq");
		//设置密码
		factory.setPassword("123456");
		
		Connection conn = factory.newConnection();
		return conn;
	}

}
