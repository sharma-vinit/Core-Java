package com.Java.Reflection.Application;

/**
 * <p>A POJO is just a plain, old Java Bean with the restrictions removed. Java Beans must meet the following requirements:</p> 
 * <ol>
 * 	<li>Follow the Bean convention of getFoo (or isFoo for booleans) and setFoo methods for a mutable attribute named foo; leave off the setFoo if foo is immutable.</li>
 * 	<li>Default no-arg constructor</li>
 * 	<li>Must implement java.io.Serializable</li>
 * </ol>
 *  <p>POJO does not mandate any of these.</p>
 * <p>It’s just what the name says: an object that compiles under JDK can be considered a Plain Old Java Object. No app server, no base classes, no interfaces required to use.</p>
 * @author Vinit
 *
 */
public class SimplePojo {
	 
	public String name;
	private String email;
	protected int age;
 
	public SimplePojo() {
		name = "POJO";
		email = "test@domain.com";
		age=30;
	}
 
	// ==========================================================
	// Create a Setters and Getters for all variables
	// ==========================================================
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}
 
	protected int getAge() {
		return age;
	}
 
	protected void setAge(int age) {
		this.age = age;
	}
 
	public void message() {
		System.out.println("- This is simple Pojo Refection API example.");
	}
 
	// ==========================================================
	// Create a String description of a Pojo, by overriding toString() method.
	// ==========================================================
 
	public String toString() {
		StringBuilder description = new StringBuilder();
		description.append("Pojo Description:[");
		description.append("Name: " + getName() + ", ");
		description.append("email: " + getEmail() + ", ");
		description.append("age: " + getAge() + "]");
		return description.toString();
	}
}