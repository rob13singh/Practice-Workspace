package org.test.spring;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements Shape {

	private Point pointA;
	private Point pointB;
	private Point pointC;
	private ApplicationContext context = null;

	public Point getPointA() {
		return pointA;
	}


	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}


	public Point getPointB() {
		return pointB;
	}


	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}


	public Point getPointC() {
		return pointC;
	}


	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}


	public void draw()
	{
		
		System.out.println("pointA(" + getPointA().getX() + "," + getPointA().getY() + ")");
		System.out.println("pointB(" + getPointB().getX() + "," + getPointB().getY() + ")");
		System.out.println("pointC(" + getPointC().getX() + "," + getPointC().getY() + ")");
		
	}





/*	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Init interface");
		
	}


	@Override
	public void destroy() throws Exception {
		System.out.println("Destroyed interface");
		
	}*/
	
	public void myInit() {
		System.out.println("Init");
	}
	
	public void myDestroy() {
		System.out.println("Destroyed");
	}
}
