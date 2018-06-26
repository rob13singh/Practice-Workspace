package com.misc.test;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person p = new Student();
		p.run();
		double x = 3.14;
		int y = (int)Math.abs(x);
		System.out.println(y);
		
		List<String> a = new ArrayList<String>();
		
		
		a.sort((c1,c2)-> c1.compareTo(c2));
	}
	
	@Override
	public void run() {
		System.out.println("Student");
	}
	


}
