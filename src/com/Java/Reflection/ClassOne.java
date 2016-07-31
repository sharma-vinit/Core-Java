package com.Java.Reflection;

public class ClassOne {

	public void addition(Integer a, Integer b) {
		Integer c = a + b;
		System.out.println("ClassName:" + this.getClass().toString());
		System.out.println(" argument received are: a=" + a + ", b=" + b);
		System.out.println(" Addition of these values gives Integer:" + c);
	}
	
	public void addition(int a, int b) {
		int c = a + b;
		System.out.println("ClassName:" + this.getClass().toString());
		System.out.println(" argument received are: a=" + a + ", b=" + b);
		System.out.println(" Addition of these values gives int:" + c);
	}
	
	public void addition(Double a, Double b) {
		Double c = a + b;
		System.out.println("ClassName:" + this.getClass().toString());
		System.out.println(" argument received are: a=" + a + ", b=" + b);
		System.out.println(" Addition of these values gives Double:" + c);
	}
}
