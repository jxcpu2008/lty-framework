package com.lty.components.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerLauncher {

	private static Logger log = LoggerFactory.getLogger(ConsumerLauncher.class);

	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					"classpath:spring/application-consumer-config.xml");
			context.start();
		} catch (Exception e) {
			log.error("== ConsumerLauncher context start error:", e);
		}
		synchronized (ConsumerLauncher.class) {
			while (true) {
				try {
					ConsumerLauncher.class.wait();
				} catch (InterruptedException e) {
					log.error("== synchronized error:", e);
				}
			}
		}
	}

}
