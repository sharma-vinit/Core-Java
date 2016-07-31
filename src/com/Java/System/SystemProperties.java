package com.Java.System;
import java.io.FileInputStream;
import java.util.Properties;

public class SystemProperties {

	/**
	 * <p>
	 * Set System properties from a text/properties file as defined by the API
	 * developer.
	 * </p>
	 * <p>
	 * Here we are using <code>myProperties.txt</code> located in "Resources"
	 * folder of the underlying project.
	 * </p>
	 */
	public static void setSystemPropFromFile() {
		try {
			// set up new properties object from file "myProperties.txt"
			FileInputStream propFile = new FileInputStream("Resources/myProperties.properties");
			Properties p = new Properties(System.getProperties());
			p.load(propFile);

			// set the system properties
			System.setProperties(p);
			System.getProperties().list(System.out);
		} catch (java.io.FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (java.io.IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * <p>
	 * Load other necessary files at runtime as per applications requirement.
	 * </p>
	 * 
	 * @see <ul>
	 *      	<li>Link: <a href="http://www.chilkatsoft.com/java-loadLibrary-Windows.asp">Java load library in Windows</a>
	 *      	<li>Link: <a href ="http://hepunx.rl.ac.uk/~adye/javatutorial/java/system/libraries.html">Loading Dynamic Libraries</a>
	 *      	<ol type="1">
	 *      		<li><code>System.loadLibrary(String)</code> uses the default path.
	 *      		<li><code>System.load(String)</code> uses the absolute path.
	 *      	</ol>
	 *      </ul>
	 */
	public static void loadDLL() {
		System.loadLibrary("splashscreen"); // Library name splashscreen instead of splashscreen.dll
		System.out.println(System.getProperty("java.library.path"));
		System.out.println(System.getProperty("sun.boot.library.path"));
		Runtime.getRuntime().loadLibrary("splashscreen");
	}
}
