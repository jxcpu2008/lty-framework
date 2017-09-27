package com.lty.app.web.auth.message.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lty.app.web.auth.message.Message;
import com.lty.app.web.auth.message.biz.PersonMessage;
import com.lty.app.web.auth.message.biz.entity.PersonEntity;

public class MyMessageHandler extends MessageHandler<PersonMessage> {
	
	private static final Logger logger = LoggerFactory.getLogger(MyMessageHandler.class);
	private PersonEntity.Person person;
	
	@Override
	public void init(byte[] data) {
		// TODO Auto-generated method stub
		logger.info("子类执行init方法做一些初始化化的事情，比如下面所示的消息反序列化");

		Message<PersonEntity.Person> msg = new PersonMessage();
		person = msg.deserialize(data);
	}

	@Override
	public void onRequest() {
		// TODO Auto-generated method stub
		logger.info("开始处理PersonMessage消息！");
		logger.info("打印pojo");
		logger.info(person.toString());
	}
}
