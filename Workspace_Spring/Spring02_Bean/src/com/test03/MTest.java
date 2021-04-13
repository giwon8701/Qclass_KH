package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("classpath*:com/test03/applicationContext.xml");
		
		Person bf = (Person) factory.getBean("best");
		bf.sayHello();
		
	}
}
