package com.misc.test;

interface BaseB {
	
}

class BaseC implements BaseB {
	public void run() {
		System.out.println("run");
	}
}

//extends keyword to be always used before implements
public class BaseA extends BaseC implements BaseB  {

	BaseA(int qty, double cost) {
		System.out.println(qty*cost);
	}
	public static void main(String[] args) {
		
		//We need to define default constructor if making parameterized constructors
		BaseA b1 = new BaseA();
		BaseA b2 = new BaseA(10,5.5);

	}

}
