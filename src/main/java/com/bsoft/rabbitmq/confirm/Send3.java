package com.bsoft.rabbitmq.confirm;

import java.io.IOException;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeoutException;

import com.bsoft.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;

/**
 * 
 * @ClassName: Send3
 * @Description: 异步模式
 * @author DENGCHAO
 * @date 2018年6月12日 下午3:05:30
 *
 */
public class Send3 {
	private static final String QUEUE_NAME = "test_queue_confirm3";

	public static void main(String[] args) throws IOException, TimeoutException {

		// 获取连接
		Connection connection = ConnectionUtils.getConnection();
		// 从连接中获取一个通道
		Channel channel = connection.createChannel();
		// 创建队列声明
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		
		channel.confirmSelect();
		final SortedSet<Long> confirmSet = Collections.synchronizedSortedSet(new TreeSet<Long>());
		channel.addConfirmListener(new ConfirmListener() {
			
			public void handleNack(long deliverTag, boolean multiple) throws IOException {
				if (multiple) {
					System.out.println("--------handleNack--------multiple");
					confirmSet.headSet(deliverTag+1).clear();
				}
				else {
					System.out.println("--------handleNack--------multiple false");
					confirmSet.remove(deliverTag);
				}
				
			}
			
			//没有问题的handleAck
			public void handleAck(long deliverTag, boolean multiple) throws IOException {
				if (multiple) {
					System.out.println("--------handleAck--------multiple");
					confirmSet.headSet(deliverTag+1).clear();
				}
				else {
					System.out.println("--------handleAck--------multiple false");
					confirmSet.remove(deliverTag);
				}
				
			}
		});
		String mString = "sssssss";
		while (true) {
			long seqNo = channel.getNextPublishSeqNo();
			channel.basicPublish("", QUEUE_NAME, null, mString.getBytes());
			confirmSet.add(seqNo);
		}

	}

}
