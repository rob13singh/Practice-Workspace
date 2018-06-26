package com.misc.test;
import java.math.BigDecimal;

public class BigDecimalCompare {

	public static void main(String[] args) {

		Double d1 = new Double("2.0");
		Double d2 = new Double("2.00");
		
		BigDecimal bd1 = new BigDecimal("2.0");
		BigDecimal bd2 = new BigDecimal("2.00");
		
		//true false
		System.out.println(d1.equals(d2) + " " + bd1.equals(bd2));
		

	}

}
