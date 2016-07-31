package com.Java.Reflection;

public class ClassThree {

	public void substraction(int a, int b) {
		int c = a - b;
		System.out.println("ClassName:" + this.getClass().toString());
		System.out.println(" argument received are: a=" + a + ", b=" + b);
		System.out.println(" Addition of these values gives int:" + c);
	}
	
	public void substraction(Integer a, Integer b) {
		Integer c = a - b;
		System.out.println("ClassName:" + this.getClass().toString());
		System.out.println(" argument received are: a=" + a + ", b=" + b);
		System.out.println(" Addition of these values gives Integer:" + c);
	}
	
	public void substraction(long a, long b) {
		long c = a - b;
		System.out.println("ClassName:" + this.getClass().toString());
		System.out.println(" argument received are: a=" + a + ", b=" + b);
		System.out.println(" Addition of these values gives long:" + c);
	}
	
	public void substraction(Long a, Long b) {
		Long c = a - b;
		System.out.println("ClassName:" + this.getClass().toString());
		System.out.println(" argument received are: a=" + a + ", b=" + b);
		System.out.println(" Addition of these values gives Long:" + c);
	}
}
