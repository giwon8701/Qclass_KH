package com.test01;


import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
	
		System.out.println("-----------------------------------------------------------------------");
		
		Date today = (Date) factory.getBean("today");
		System.out.println(today.toLocaleString());
	
		
		MyClass myclass = (MyClass) factory.getBean("myclass");
		myclass.prn();
		
	}
}
