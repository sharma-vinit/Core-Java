package com.Java.Reflection;

public class ClassTwo {

	public void concatination(String a, String b, String c) {
		String d = a + b +c;
		System.out.println("ClassName:" + this.getClass().toString());
		System.out.println(" argument received are: a=" + a + ", b=" + b);
		System.out.println(" Addition of these values gives:" + d);
	}
}
