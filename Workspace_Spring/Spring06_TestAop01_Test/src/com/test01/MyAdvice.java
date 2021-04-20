package com.test01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAdvice {
	 	
	public MyAdvice() {}

	@Before("execution(public * sayName(..))")
	public void beforeSaying(JoinPoint join) {
		System.out.println("당신의 이름은 무엇입니까?");
	}
	
	@After("execution(public * sayName(..))")
	public void afterSaying(JoinPoint join) {
		System.out.println("이름이 멋지시네요.");
	}

	@AfterReturning(pointcut = "execution(public * sayName(..))", returning = "returnVal")
	public void afterReturnSaying(JoinPoint join, Object returnVal) {
		System.out.println("직업이 무엇입니까?");
	}

}
