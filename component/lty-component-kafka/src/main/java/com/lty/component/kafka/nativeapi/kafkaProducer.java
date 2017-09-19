package com.lty.component.kafka.nativeapi;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.serializer.StringEncoder;

/**
 * 
 * @描述:消息生产者 
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
@SuppressWarnings("deprecation")
public class kafkaProducer extends Thread {
	
	public static final String KAFKA_ADDRESS = "10.1.10.80:9092";
	public static final String ZOOKEERP_ADDRESS = "10.1.10.80:2181";
	
	private String topic;

	public kafkaProducer(String topic) {
		
		super();
		this.topic = topic;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void run() {
		
		Producer producer = createProducer();
		int i = 0;
		while (true) {
			
			producer.send(new KeyedMessage<Integer, String>(topic, "message: " + i));
			System.out.println("发送了: " + i);
			
			try {
				
				TimeUnit.SECONDS.sleep(1);
				i++;
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("rawtypes")
	private Producer createProducer() {
		
		Properties properties = new Properties();
		properties.put("zookeeper.connect", KAFKA_ADDRESS);// 声明zk
		properties.put("serializer.class", StringEncoder.class.getName());
		properties.put("metadata.broker.list", ZOOKEERP_ADDRESS);// 声明kafka
																	// broker
		return new Producer<Integer, String>(new ProducerConfig(properties));
	}

	public static void main(String[] args) {
		
		new kafkaProducer("test").start();// 使用kafka集群中创建好的主题 test

	}

}
