
package com.lty.component.kafka.spring;

import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.kafka.listener.MessageListener;

/**
 * 
 * @描述:
 * @作者: wei.liu
 * @创建时间: 2016年10月8日
 * @版本: 1.0
 */
public class KafkaConsumer implements MessageListener<Integer, String> {

	@Override
	public void onMessage(ConsumerRecord<Integer, String> record) {
		
		System.out.println("*****接受到消息开始***********");
		System.out.println("整个对象:" + record);
		System.out.println("key:" + record.key());
		System.out.println("value:" + record.value());
		System.out.println("partition:" + record.partition());

		System.out.println("********接受到消息结束********");
	}

	public static void main(String[] args) throws InterruptedException {
		
		final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kafka-consumer.xml");
		ctx.start();
		
		TimeUnit.SECONDS.sleep(100000);
	}

}