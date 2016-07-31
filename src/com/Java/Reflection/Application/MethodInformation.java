package com.Java.Reflection.Application;

import static java.lang.System.out;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/**
 * Methods <a href="https://docs.oracle.com/javase/tutorial/reflect/member/method.html">Methods (Reflection API)</a>
 * @see <a href="https://docs.oracle.com/javase/tutorial/reflect/member/index.html">The Reflection API</a>
 * @author Vinit Sharma
 */
public class MethodInformation {
	private static final String fmt = "%24s: %s%n";
	private static int count;

	// for the morbidly curious
	<E extends RuntimeException> void genericThrow() throws E {}

    private static synchronized void inc() { count++; }
    private static synchronized int cnt() { return count; }
    
	public static void allMethodsInfo(String... args) {
		try {
			Class<?> c = Class.forName(args[0]);
			Method[] allMethods = c.getDeclaredMethods();
			for (Method m : allMethods) {

				out.format("%s%n", m.toGenericString());

				out.format(fmt, "ReturnType", m.getReturnType());
				out.format(fmt, "GenericReturnType", m.getGenericReturnType());

				Class<?>[] pType = m.getParameterTypes();
				Type[] gpType = m.getGenericParameterTypes();
				for (int i = 0; i < pType.length; i++) {
					out.format(fmt, "ParameterType", pType[i]);
					out.format(fmt, "GenericParameterType", gpType[i]);
				}
				
				out.format("  Modifiers:  %s%n", Modifier.toString(m.getModifiers()));				
				inc();
			    out.format("%d matching overload%s found%n", cnt(), (cnt() == 1 ? "" : "s"));
				
				Class<?>[] xType = m.getExceptionTypes();
				Type[] gxType = m.getGenericExceptionTypes();
				for (int i = 0; i < xType.length; i++) {
					out.format(fmt, "ExceptionType", xType[i]);
					out.format(fmt, "GenericExceptionType", gxType[i]);
				}
			}

			// production code should handle these exceptions more gracefully
		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		}
	}

	public static void getMethodInfo(String... args) {
		try {
			Class<?> c = Class.forName(args[0]);
			Method[] allMethods = c.getDeclaredMethods();
			for (Method m : allMethods) {
				if (!m.getName().equals(args[1])) {
					continue;
				}
				
				out.format("%s%n", m.toGenericString());

				out.format(fmt, "ReturnType", m.getReturnType());
				out.format(fmt, "GenericReturnType", m.getGenericReturnType());

				Class<?>[] pType = m.getParameterTypes();
				Type[] gpType = m.getGenericParameterTypes();
				for (int i = 0; i < pType.length; i++) {
					out.format(fmt, "ParameterType", pType[i]);
					out.format(fmt, "GenericParameterType", gpType[i]);
				}

				Class<?>[] xType = m.getExceptionTypes();
				Type[] gxType = m.getGenericExceptionTypes();
				for (int i = 0; i < xType.length; i++) {
					out.format(fmt, "ExceptionType", xType[i]);
					out.format(fmt, "GenericExceptionType", gxType[i]);
				}
			}

			// production code should handle these exceptions more gracefully
		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		}
	}
}
