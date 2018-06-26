package com.misc.test;

class recursion {
	public int run(int n) {
		int result;
		result = run(n-1);
		return result;
	}
}

public class CompilationExample {

	public static void main(String[] args) {
		
		recursion r = new recursion();
		System.out.println((r.run(12)));

	}

}
