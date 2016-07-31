package com.Java.Basics.Objects;

public class ObjectReference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectReference obj = new ObjectReference();
		obj.bar();
	}

	void bar() {
		Foo f = new Foo();
		System.out.println("doStuff With String--------");
		doStuffWithString(f);
		System.out.println("doStuff With Private Integer Value--------");
		doStuffWithPrivateIntegerValue(f);
		System.out.println("doStuff With Static Integer Value--------");
		doStuffWithStaticIntegerValue(f);
		System.out.println("doStuff With Static Integer Value Standard Way--------");
		doStuffWithStaticIntegerValueStandardWay();
	}

	void doStuffWithString(Foo g) {
		System.out.println(g.getName());
		g.setName("Boo");
		System.out.println(g.getName());
		g = new Foo();
		System.out.println(g.getName());
	}
	
	void doStuffWithPrivateIntegerValue(Foo g) {
		System.out.println(g.getPrivateIntegerValue());
		g.setPrivateIntegerValue(100);
		System.out.println(g.getPrivateIntegerValue());
		g = new Foo();
		System.out.println(g.getPrivateIntegerValue());
	}
	
	void doStuffWithStaticIntegerValue(Foo g) {
		System.out.println(g.getStaticIntegerValue());
		g.setStaticIntegerValue(100);
		System.out.println(g.getStaticIntegerValue());
		g = new Foo();
		System.out.println(g.getStaticIntegerValue());
	}
	
	void doStuffWithStaticIntegerValueStandardWay() {
		System.out.println(Foo.getStaticIntegerValue());
		Foo.setStaticIntegerValue(100);
		System.out.println(Foo.getStaticIntegerValue());
	}

}

class Foo {
	private int privateIntegerValue = 10;
	static int staticIntegerValue = 1000;
	String name = "Java";

	public int getPrivateIntegerValue() {
		return privateIntegerValue;
	}

	public void setPrivateIntegerValue(int privateIntegerValue) {
		this.privateIntegerValue = privateIntegerValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static int getStaticIntegerValue() {
		return staticIntegerValue;
	}

	public static void setStaticIntegerValue(int staticIntegerValue) {
		Foo.staticIntegerValue = staticIntegerValue;
	}

}