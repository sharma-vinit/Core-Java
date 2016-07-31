package com.Java.Exception.Assertion;

public class AssertionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Sum of two numbers, "+ (Integer.MAX_VALUE - 1000) + " and 1001 is: " + AssertionTest.sum( (Integer.MAX_VALUE - 1000), 1001));
	}

	public static int sum(int a, int b) {
		System.out.println(Integer.MAX_VALUE +"-"+ a + ">=" + b +": "+ (Integer.MAX_VALUE - a >= b));
		assert(Integer.MAX_VALUE - a >= b) : "Value of " + a + " + " + b + " is too large to add.";
		int result = a + b;
		//assert(result - a == b) : "Sum of " + a + " + " + b + " returned wrong sum " + result;

		return result;
	}
}

