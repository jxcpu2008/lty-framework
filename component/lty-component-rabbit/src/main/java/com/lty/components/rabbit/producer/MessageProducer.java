package com.lty.components.rabbit.producer;

import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

	@Resource(name="amqpTemplate")
	private AmqpTemplate amqpTemplate;
	
	public void sendMessage(Object msg) {
		// send direct message
//		amqpTemplate.convertAndSend("cn.muchinfo.queue..key.A", "key=cn.muchinfo.queue.key.A" + msg);
//		amqpTemplate.convertAndSend("cn.muchinfo.queue..key.B", "key=cn.muchinfo.queue.key.B" + msg);
		
		// send topic message
//		amqpTemplate.convertAndSend("Jerry.Wang@JX", "key=Jerry.Wang@JX" + msg);
//		amqpTemplate.convertAndSend("Jerry.Wang.JX", "key=Jerry.Wang.JX" + msg);
//		amqpTemplate.convertAndSend("JX.Wang.Jerry", "key=JX.Wang.Jerry" + msg);
//		amqpTemplate.convertAndSend("Wang.Jerry", "key=Wang.Jerry" + msg);
		
		// send fanout message
		for (int i = 1; i < 10; i++) {
			amqpTemplate.convertAndSend("第" + i + "条：" + msg);
		}
	}
}
