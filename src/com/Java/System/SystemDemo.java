package com.Java.System;
import java.util.Iterator;
import java.util.Map;

/**
 * <ul>
 * 	<li>How do I find out the system temporary directory in Java? 
 * 	<li>How do I find out the local machine's default file format (character encoding, line separator) in Java? 
 * 	<li>How do I find out processor information (e.g. CPU type, endianness) in Java? 
 * 	<li>How do I find out the Java VM version from a running Java program?
 * </ul>
 * <p>Information such as this can be found in two places:</p>
 * <ol type="a" start="a">
 * 	<li>Environment variables, defined and controlled by the operating system;
 * 	<li>System properties, essentially local to the Java system, which are defined by the JVM and
 * 		can potentially be specified on the command line when your Java application is run. 
 * </ol>
 * <p>
 * In general, system properties are more useful for multi-platform applications because they are more consistent across 
 * platforms.Indeed, some system properties are actually set by the VM on the basis of OS environment variables in order 
 * to provide a more consistent way of reading the relevant information. </p>
 * <p>However, we will look at both types of properties here:</p>
 * <ol type="1">	
 * <li>The "raw" environment variables, and	
 * <li value="2">Java's system properties.
 * </ol>
 * @author	Vinit
 */

public class SystemDemo implements SystemVaraiblesGlobal {

	public static void main(String[] args) {
		SystemDemo.getDefaultSystemProperties();
		SystemDemo.getOSEnvironmentVariables();
		
		SystemProperties.setSystemPropFromFile();
		SystemDemo.getDefaultSystemProperties();
		System.out.println(System.getProperty("subliminal.message"));
		
		SystemProperties.loadDLL();
	}
	
	private static void getDefaultSystemProperties(){
		/**
		 * <p>Java system properties: <code>System.getProperty()</code></p>
		 * <p>As mentioned above, system properties are conceptually similar to environment variables. But they are essentially local to, 
		 * and controlled by, the Java system, not by the operating system. On the surface, individual system properties are retrieved in 
		 * a very similar way to environment variables, but using the <code>System.getProperty()</code> method:</p>
		 * <code>String value = System.getProperty("user.dir");</code>
		 * <p>Potentially useful properties that are typically defined include the following. 
		 * In general, you can reasonably expect these properties to be defined, irrespective of the operating system 
		 * (unlike environment variables, which are OS dependent):</p>
		 * <pre>
		 * Key                     Meaning
		 * -------------------     ------------------------------
		 * "file.separator"        File separator (e.g., "/")
		 * "java.class.path"       Java classpath
		 * "java.class.version"    Java class version number
		 * "java.home"             Java installation directory
		 * "java.vendor"           Java vendor-specific string
		 * "java.vendor.url"       Java vendor URL
		 * "java.version"          Java version number
		 * "line.separator"        Line separator
		 * "os.arch"               Operating system architecture
		 * "os.name"               Operating system name
		 * "path.separator"        Path separator (e.g., ":")
		 * "user.dir"              User's current working directory
		 * "user.home"             User home directory
		 * "user.name"             User account name
		 * </pre>
		 */
		java.util.Properties properties = System.getProperties();
		System.out.println("Default System properties");
		properties.list(System.out);		
	}
	
	public static void getOSEnvironmentVariables(){
		/**
		 * <p>OS environment variables: <code>System.getenv(String variableName)</code></p>
		 * <p>Environment variables are defined and controlled by the operating system.</p>
		 * <pre>
		 * Environment-Variable	Meaning
		 * ProgramFiles		The path of the Program Files directory.
		 * OS			The name of the base Operating System type (modern versions of Windows are generally Windows_NT).
		 * SystemRoot		The base directory in which windows system files are installed (typically C:\Windows).
		 * USERNAME			The name of the currently logged in user.
		 * USERPROFILE		The user directory of the currently logged in user (e.g. C:\Users\Fred).
		 * </pre>
		 * @code String value = System.getenv("USERNAME");
		 */
		Iterator<Map.Entry<String, String>> entries = System.getenv().entrySet().iterator();
		System.out.println("\nGet OS environment variables");
		while (entries.hasNext()) {
		    Map.Entry<String, String> entry = entries.next();
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}		
	}
}