package com.lty.component.kafka.nativeapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

/**
 * 
 * @描述: 接收数据 接收到: message: 10 接收到: message: 11 接收到: message: 12 接收到: message: 13
 *      接收到: message: 14
 * @作者: Kevin Xie
 * @创建时间: 2016年10月8日
 * @版本: 1.0
 */
public class kafkaConsumer extends Thread {
	
	public static final String ZOOKEERP_ADDRESS = "10.1.10.80:2181";

	private String topic;

	/**
	 * 
	 * @param topic
	 */
	public kafkaConsumer(String topic) {
		
		super();
		this.topic = topic;
	}

	@Override
	public void run() {
		
		ConsumerConnector consumer = createConsumer();
		Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
		topicCountMap.put(topic, 1); // 一次从主题中获取一个数据
		Map<String, List<KafkaStream<byte[], byte[]>>> messageStreams = consumer.createMessageStreams(topicCountMap);
		KafkaStream<byte[], byte[]> stream = messageStreams.get(topic).get(0);// 获取每次接收到的这个数据
		ConsumerIterator<byte[], byte[]> iterator = stream.iterator();
		
		while (iterator.hasNext()) {
			
			String message = new String(iterator.next().message());
			System.out.println("接收到: " + message);
		}
	}

	private ConsumerConnector createConsumer() {
		
		Properties properties = new Properties();
		properties.put("zookeeper.connect", ZOOKEERP_ADDRESS);// 声明zk
		properties.put("group.id", "group1");
		
		return Consumer.createJavaConsumerConnector(new ConsumerConfig(properties));
	}

	/**
	 * 
	 * @Title: main @Description: TODO(这里用一句话描述这个方法的作用) @param @param args
	 * 设定文件 @return void 返回类型 @throws
	 */
	public static void main(String[] args) {
		
		new kafkaConsumer("test").start();// 使用kafka集群中创建好的主题 test
		test();
	}

	/**
	 * 
	 * @功能：
	 * 
	 * @param context
	 *
	 * @返回：void
	 */
	private static void test() {

	}

}
