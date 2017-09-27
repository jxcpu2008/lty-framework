package com.lty.app.web.auth.message.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lty.app.web.auth.message.Message;

public abstract class MessageHandler<BizMessage extends Message<?>> {

	private static final Logger logger = LoggerFactory.getLogger(MessageHandler.class);
	
	public void init(byte[] data) {
		logger.info("基类执行init方法做一些初始化操作！");
	}
	
	public abstract void onRequest();
}
