package com.lty.app.web.auth.test.message.producer;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "classpath:mq/mq-config.xml" })
public class SendMessageTest {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private ActiveMQQueue queueDestination;
	
	@Test
	public void sendMessage() {
		jmsTemplate.send(queueDestination, new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				BytesMessage msg = session.createBytesMessage();
				msg.setIntProperty("funCode", 20000);
				msg.setIntProperty("sessionId", 2);
				byte[] data = "0123456789".getBytes();
				msg.writeBytes(data);
				
				return msg;
			}
			
		});
	}
	
}
