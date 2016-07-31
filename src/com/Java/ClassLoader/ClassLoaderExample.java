package com.Java.ClassLoader;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Java program to demonstrate How ClassLoader works in Java, in particular
 * about visibility principle of ClassLoader.
 */

public class ClassLoaderExample {

	public static void main(String args[]) {
		try {
			// printing ClassLoader of this class
			System.out.println("ClassLoaderExample.getClass().getClassLoader() : "
					+ ClassLoaderExample.class.getClassLoader());

			// trying to explicitly load this class again using Extension class loader
			Class.forName("com.Java.ClassLoader.ClassLoaderExample", true,
					ClassLoaderExample.class.getClassLoader().getParent());
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ClassLoaderExample.class.getName()).log(
					Level.SEVERE, null, ex);
		}
	}
    
}