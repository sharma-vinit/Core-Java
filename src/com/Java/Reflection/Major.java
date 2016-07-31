package com.Java.Reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Major {

	private static Object classRef = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Initializing .....");
		Object[] classArray = { new ClassOne(), new ClassTwo(),	new ClassThree() };
		String[] methodNames = { "addition", "concatination", "substraction" };
		Object[] argumentSet = { new int[] { 30000, 50000 },
							   new String[] { "Hello", " World", " !" }, 
							   new Integer[] { 12345, 2345 } 
							 };

		for (int i = 0; i < classArray.length; ++i) {
			try {
				load(classArray[i].getClass().getName(),methodNames[i], argumentSet[i]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Completed .....");

	}
	
	/**
	 * Call the load() method 
	 * {@link http://stackoverflow.com/questions/2725533/how-to-see-if-an-object-is-an-array-without-using-reflection}
	 * @param <T>
	 * 
	 * @param className
	 * @param methodName
	 * @param argumentSet
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private static <T> void load(String className, String methodName, Object argumentSet) throws Exception {

		int size = Array.getLength(argumentSet);
		Object[] arguments = null;
		Object param[];
		Class<?> paramTypes[];
		
		System.out.println("isArray = " + isArray(argumentSet));

		if(isArray(argumentSet)){			
			List<T> list = (List<T>) new ArrayList<Object>();
			for(int i=0; i<size; i++){
	            list.add((T) Array.get(argumentSet, i));
	        }
			arguments = toArray(list);
		}
		
		if (arguments == null || arguments.length == 0) {
			paramTypes = null;
			param = null;
		} else {
			paramTypes = new Class[size];
			for (int i = 0; i < size; i++) {
				paramTypes[i] = arguments.getClass().getComponentType();
			}
			param = new Object[size];
			for (int i = 0; i < size; i++) {
				param[i] = arguments[i];
			}
		}

		Class<?> cls = Class.forName(className);
		classRef = cls.newInstance();
		Method method = cls.getDeclaredMethod(methodName, paramTypes);
		method.invoke(classRef, param);
	}

	public static boolean isArray(final Object obj) {
		if (obj != null)
			return obj.getClass().isArray();
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[] toArray(List<T> list) {
	    Class<? extends Object> clazz = list.get(0).getClass(); // check for size and null before
	    T[] array = (T[]) java.lang.reflect.Array.newInstance(clazz, list.size());
	    return list.toArray(array);
	}

}
