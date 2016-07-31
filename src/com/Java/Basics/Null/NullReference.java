package com.Java.Basics.Null;

public class NullReference {
	private static String staticVariable = "staticVariable";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NullReference refVar = null;
		//Calling static members using refVar of Type NullReference
		refVar.staticMethod();
		System.out.println(refVar.staticVariable);
		
		//Calling static members using null, whose type is obviously null.	
		//System.out.println(null.staticVariable);	// compiler error: staticVariable cannot be resolved or is not a field
		//null.staticMethod(); //Cannot invoke staticMethod() on type null
	}

	public static void staticMethod() {
		System.out.println("Static Method");
	}
}
