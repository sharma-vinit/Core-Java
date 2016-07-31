package com.Java.Reflection.Application;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.core.NamingPolicy;
import net.sf.cglib.core.Predicate;

/**
 * http://mydailyjava.blogspot.in/2013/11/cglib-missing-manual.html
 */
public class CreateBeanClass{

	public static void main(String[] args) {
		try {
		    final Map<String, Class<?>> properties = new HashMap<String, Class<?>>();
	        properties.put("foo", Integer.class);
	        properties.put("bar", String.class);
	        properties.put("baz", int[].class);

	        final Class<?> beanClass = createBeanClass("com.Java.Reflection.Application.DynamicPojoClass", properties);
	        System.out.println(beanClass);
	        for(final Method method : beanClass.getDeclaredMethods()){
	            System.out.println(method);
	        }
	        
	        System.out.println("\nGet detailed info on a class's fields --------------");
			FieldInformation.getFieldsInfo("com.Java.Reflection.Application.DynamicPojoClass");
	        
	        System.out.println("\nGet detailed info on a class's methods --------------");
			MethodInformation.allMethodsInfo("com.Java.Reflection.Application.DynamicPojoClass");
			
			// Example9: -------------- How to invoke a method using Method class?
			try {
				System.out.println("\nHow to invoke a method using Method class --------------");
				Class<?> c = Class.forName("com.Java.Reflection.Application.DynamicPojoClass");
				Object obj = c.newInstance();
				Method method = c.getDeclaredMethod("setBaz", int[].class);
				int [] arr = {1,2,3};
				method.invoke(obj, arr);
				
				method = c.getDeclaredMethod("getBaz");
				System.out.println(method.invoke(obj));
				
				for(int i=0; i<Array.getLength(method.invoke(obj)); i++){
					System.out.println(Array.get(method.invoke(obj), i));
				}
				
				
				method = c.getDeclaredMethod("setBar", String.class);
				method.invoke(obj, "Ashish");
				
				method = c.getDeclaredMethod("getBar");
				System.out.println(method.invoke(obj));
				
			} catch (Exception e) {

				System.out.println(e);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static Class<?> createBeanClass(
		    /* fully qualified class name */
		    final String className,
		    /* bean properties, name -> type */
		    final Map<String, Class<?>> properties){

		    final BeanGenerator beanGenerator = new BeanGenerator();

		    /* use our own hard coded class name instead of a real naming policy */
		    beanGenerator.setNamingPolicy(new NamingPolicy(){
		        @Override public String getClassName(final String prefix,
		            final String source, final Object key, final Predicate names){
		            return className;
		        }});
		    BeanGenerator.addProperties(beanGenerator, properties);
		    return (Class<?>) beanGenerator.createClass();
		}
	}