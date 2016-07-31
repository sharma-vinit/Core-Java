package com.Java.Basics.ObjectOreineted.AccessModifiers.Package1;

import com.Java.Reflection.Application.FieldInformation;
import com.Java.Reflection.Application.MethodInformation;

public class Parent {

	public int integerValue = 10;	// Member variable with default access modifier

	int getIntegerValue() {	// Member method with default access modifier
		int localVariable = this.integerValue;	// Local variable, accessible within this method only
		// Get Field info
		FieldInformation.getFieldsInfo("com.Java.Basics.ObjectOreineted.AccessModifiers.Package1.Parent");
				
		// Get Method info
		MethodInformation.getMethodInfo("com.Java.Basics.ObjectOreineted.AccessModifiers.Package1.Parent", "getIntegerValue");
		return localVariable;
	}
}
