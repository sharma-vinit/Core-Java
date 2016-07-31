package com.Java.System;

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

public interface SystemVaraiblesGlobal {

	public static final String PROGRAMFILES = "abc";
	/*
	public static final String PROGRAMFILES;
	public static final String OS;
	public static final String SYSTEMROOT;
	public static final String USERNAME;
	public static final String USERPROFILE;
	*/

}
