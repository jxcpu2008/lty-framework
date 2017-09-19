package com.lty.components.rabbit.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class DirectMessageConsumer implements MessageListener {
	
	private Logger logger = LoggerFactory.getLogger(DirectMessageConsumer.class);

	@Override
	public void onMessage(Message msg) {
		// TODO Auto-generated method stub
		logger.info("receive direct message------->:{}", msg);
	}
}
