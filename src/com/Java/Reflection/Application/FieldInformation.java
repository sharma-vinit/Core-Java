package com.Java.Reflection.Application;

import static java.lang.System.out;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Fields <a href="https://docs.oracle.com/javase/tutorial/reflect/member/field.html">Fields (Reflection API)</a>
 * @see <a href="https://docs.oracle.com/javase/tutorial/reflect/member/index.html">The Reflection API</a>
 * @author Vinit Sharma
 */
public class FieldInformation {

	public static void getFieldInfo(String... args){
		try {
	        Class<?> c = Class.forName(args[0]);
	        Field f = c.getField(args[1]);
	        System.out.format("\tType: %s%n", f.getType());
	        System.out.format("\tGenericType: %s%n", f.getGenericType());
	        out.format("\tModifiers:  %s%n", Modifier.toString(f.getModifiers()));
	 
	        // production code should handle these exceptions more gracefully
	    } catch (ClassNotFoundException x) {
	        x.printStackTrace();
	    } catch (NoSuchFieldException x) {
	        x.printStackTrace();
	    }
	}
	
	public static void getFieldsInfo(String... args){
		try {
	        Class<?> c = Class.forName(args[0]);
	        Field[] fileds = c.getDeclaredFields();
	        for (Field field : fileds) {
	        	System.out.println("\t------------------------------------------------------");
		        System.out.format("\tType: %s%n", field.getType());
		        System.out.format("\tGenericType: %s%n", field.getGenericType());
		        System.out.format("\tModifiers:  %s%n", Modifier.toString(field.getModifiers()));
	        }	 
	        // production code should handle these exceptions more gracefully
	    } catch (ClassNotFoundException x) {
	        x.printStackTrace();
	    }
	}
}
