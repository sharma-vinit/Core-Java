package com.Java.Basics.ObjectOreineted.AccessModifiers.Transient;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test{
	
	public static void main(String[] args){
		Test.serialze();
		Test.deserialze();
	}
	static public void serialze(){
		try
		{
		    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("empInfo.ser"));
		    Employee emp = new Employee();
		    emp.setFirstName("Vinit");
		    emp.setLastName("Sharma");
		    emp.setConfidentialInfo("password");
		    
		    //Serialize the object
		    oos.writeObject(emp);
		    oos.close();
		} catch (Exception e)
		{
		    System.out.println(e);
		}
	}
	
	static public void deserialze(){
		try
		{
		    ObjectInputStream ooi = new ObjectInputStream(new FileInputStream("empInfo.ser"));
		    //Read the object back
		    Employee readEmpInfo = (Employee) ooi.readObject();
		    System.out.println(readEmpInfo.getFirstName());
		    System.out.println(readEmpInfo.getLastName());
		    System.out.println(readEmpInfo.getConfidentialInfo());
		    ooi.close();
		} catch (Exception e)
		{
		    System.out.println(e);
		}
	}
}


