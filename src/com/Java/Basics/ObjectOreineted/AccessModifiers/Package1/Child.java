package com.Java.Basics.ObjectOreineted.AccessModifiers.Package1;

public class Child extends Parent {

	public static void main(String[] args) {
		Child child = new Child();
		child.method();
	}

	void method() {
		System.out.println("In Child class of Package 1, having Parent in Package 1.");
		getIntegerValue();
	}
}
