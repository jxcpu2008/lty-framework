package com.lty.components.rabbit.message;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:rabbit-producer-config.xml"})
public class SendMessageTest {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void testSendMessage() {
		
	}

	

}
