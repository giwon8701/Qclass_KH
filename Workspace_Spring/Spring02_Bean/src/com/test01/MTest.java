package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");

		MessageBean banana = (MessageBean) factory.getBean("banana");
		MessageBean strawberry = (MessageBean) factory.getBean("strawberry");
		MessageBean kiwi = (MessageBean) factory.getBean("kiwi");
		MessageBean cherry = (MessageBean) factory.getBean("cherry");

		banana.sayHello();
		strawberry.sayHello();
		kiwi.sayHello();
		cherry.sayHello();
	}
}
