package org.aspect.test;

import org.aspect.test.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	@Before("allGetters()")
	public void loggingAdvice(JoinPoint joinpoint) {
		System.out.println(joinpoint.getTarget());
		
		Circle circle = (Circle) joinpoint.getTarget();
	}
	
	@Before("args(name)")
	public void argeTest(String name) {
		System.out.println("Arge pointcut is called: " +name);
	}
	
	@Pointcut("within(org.aspect.test.model.Circle)")
	public void allGetters() {}
}
