package com.misc.test;
import java.io.IOException;

public class TestCases {

	int x,y;
	
	public static void main(String[] args) throws Exception  {
		
		try {
			badmethod();
			System.out.println("B");
		} catch (Exception e)
		{
			System.out.println("C");
		}
		finally {
			System.out.println("D");
		}
		System.out.println("E");
		
	}
	
	public static void badmethod() throws Exception{
		throw new Exception();
	}

}
