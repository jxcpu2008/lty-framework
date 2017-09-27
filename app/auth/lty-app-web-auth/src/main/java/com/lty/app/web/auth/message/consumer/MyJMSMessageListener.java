package com.lty.app.web.auth.message.consumer;

import java.util.Map;

import javax.annotation.Resource;
import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.lty.app.web.auth.message.handler.MessageHandlerHelper;
import com.lty.app.web.auth.message.type.RequestMessage;
import com.lty.app.web.auth.util.MessageInvoker;

@Component
public class MyJMSMessageListener implements MessageListener {

	Logger logger = LoggerFactory.getLogger(MyJMSMessageListener.class);
	
	@Resource
    private Map<String, String> handlerMapping;

	@Override
	public void onMessage(Message msg) {
		if (msg == null) {
        	return;
        }
		
		logger.info(Thread.currentThread().getName() + "---------->>" + msg);
		
		if (msg instanceof BytesMessage) {
			BytesMessage message = (BytesMessage) msg;
			RequestMessage request = new RequestMessage();
			
			try {
				int funCode = message.getIntProperty("funCode");
				int sessionId = message.getIntProperty("sessionId");
				request.setFunCode(funCode);
				request.setSessionId(sessionId);
				
				long bodyLen = message.getBodyLength();
				byte[] data = new byte[(int) bodyLen];
				message.readBytes(data);
				request.setData(data);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("消息消费遇到异常！", e);
				return;
			}
			
			MessageHandlerHelper.getInstance().addTask(new MessageInvoker(request, handlerMapping));
		} else {
			logger.info("消息{}，消息类型不是BytesMessage，请检查！", msg);
		}
	}
}
