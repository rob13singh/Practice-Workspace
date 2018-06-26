package org.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Circle implements Shape {

	private Point center;
	
	public Point getCenter() {
		return center;
	}

	@Autowired
	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	@Qualifier("circleRelated")
	public void draw() {
		System.out.println("Circle. Point is "+ center.getX() +", "+ center.getY());
		
	}
	
	

}
