package com.Java.Basics.ObjectOreineted.AccessModifiers.Transient;

import java.io.Serializable;

public class Employee implements Serializable {
	
	//instance variables
	private static final long serialVersionUID = 6491183441433126769L;
	private String firstName;
	private String lastName;
	private transient String confidentialInfo;
	
	// Setters and Getters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getConfidentialInfo() {
		return confidentialInfo;
	}
	public void setConfidentialInfo(String confidentialInfo) {
		this.confidentialInfo = confidentialInfo;
	}
}

