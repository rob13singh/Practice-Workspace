package com.misc.test;

public class IntegerCheck {
	
	public static int show() {
		return (true ? null : 0);
	}

	public static void main(String[] args) {
		
		Test2 test = new Test2("abc", 1);
		
		Test2 test2 = new Test2("abc", 2);
		
		
		
		
		
		System.out.println(test.name == test2.name);
	}
	
	public static class Test2 {
		String name;
		int id;
		public Test2(String name, int id) {
			this.name = name;
			this.id = id;
		}
		
		
	}

}
