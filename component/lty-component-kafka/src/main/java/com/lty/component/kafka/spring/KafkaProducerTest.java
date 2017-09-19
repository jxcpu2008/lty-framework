package com.lty.component.kafka.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @描述:
 * @作者: wei.liu
 * @创建时间: 2016年10月8日
 * @版本: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:kafka-producer.xml" })
public class KafkaProducerTest {

	@Autowired
	private KafkaTemplate<Integer, String> kafkaTemplate;

	/**
	 * 
	 * @功能：
	 * 
	 * @param context
	 *
	 * @返回：void
	 */
	@Test
	public void testTemplateSend() {
		
		kafkaTemplate.sendDefault("haha111");
	}

}