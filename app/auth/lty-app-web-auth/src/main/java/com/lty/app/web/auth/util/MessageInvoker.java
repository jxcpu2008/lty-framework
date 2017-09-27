package com.lty.app.web.auth.util;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lty.app.web.auth.message.handler.MessageHandler;
import com.lty.app.web.auth.message.type.RequestMessage;

public final class MessageInvoker implements Runnable {

	private static final Logger logger = LoggerFactory.getLogger(MessageInvoker.class);
	
	private RequestMessage request;
	
	private Map<String, String> handlerMapping;
	
	public MessageInvoker(RequestMessage request, Map<String, String> handlerMapping) {
		this.request = request;
		this.handlerMapping = handlerMapping;
	}
	
	public void run() {
		
		logger.info(handlerMapping.toString());
		
		String className = handlerMapping.get(String.valueOf(request.getFunCode()));
		if (className == null) {
			return;
		}
		
		try {
			Class<?> handlerClass = Class.forName(className);
			logger.info("消息处理对应的handler类 : =======> " + handlerClass.getSimpleName());
			
			@SuppressWarnings("rawtypes")
			MessageHandler handler = (MessageHandler) handlerClass.newInstance();
			
			handler.init(request.getData());
			handler.onRequest();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.info("无法找到消息处理对应的handler类！", e);
		} catch (Exception e) {
			logger.info("实例化消息处理对应的handler类时发生异常！", e);
		}
	}
}
