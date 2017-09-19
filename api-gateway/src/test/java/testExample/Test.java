package testExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("scan/spring-scan.xml");

	}

}
