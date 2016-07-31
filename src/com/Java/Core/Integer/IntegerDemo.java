package com.Java.Core.Integer;

public class IntegerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new IntegerDemo().compareReferences();
		
	}
	
	/**
	 * <p>When you compile a number literal in Java and assign it to a Integer (capital I) the compile emits:</p>
	 * <code>Integer b2 =Integer.valueOf(127);</code>
	 * <p>This line of code is also generated when you use autoboxing.
	 * valueOf is implemented such that certain numbers are "pooled", and it returns the same instance for values smaller than 128.</p>
	 * <p>The value of high can be configured to another value, with the system property.</p>
	 * <code>-Djava.lang.Integer.IntegerCache.high=999</code>
	 * <p>If you run your program with that system property, it will output true!</p>
	 * <p>The obvious conclusion: never rely on two references being identical, always compare them with <code>.equals()</code> method.</p>
	 * <p>So <code>b2.equals(b3)</code> will print true for all logically equal values of b2,b3.</p>
	 * <p>Note that Integer cache is not there for performance reasons, but rather to comform to the JLS, section 5.1.7; 
	 * object identity must be given for values -128 to 127 inclusive.</p>
	 * 
	 * @see	Integer#valueOf(int)
	 * @see	<code>private static class IntegerCache</code>
	 * 	<p>	Which states: Cache to support the object identity semantics of autoboxing for values between -128 and 127 (inclusive) as required by JLS. 
	 * 		The cache is initialized on first usage. The size of the cache may be controlled by the -XX:AutoBoxCacheMax=<size> option. 
	 * 		During VM initialization, java.lang.Integer.IntegerCache.high property may be set and saved in the private system properties in the sun.misc.VM class.</p>
	 */
	private void compareReferences(){
		Integer a=127, x=127, y=128, z=128;
		Integer b = new Integer(127);
		Integer c = new Integer(127);
		Integer d = new Integer(128);
		Integer e = new Integer(128);
		
		
		try{
			if(a instanceof Integer){
				System.out.println("a is object of class: "+a.getClass());
			}else{
				System.out.println("a is object of class: "+a.getClass());
			}
			
			if(x instanceof Integer){
				System.out.println("x is object of class: "+x.getClass());
			}else{
				System.out.println("x is object of class: "+x.getClass());
			}
			
			
			if(y instanceof Integer){
				System.out.println("y is object of class: "+y.getClass());
			}else{
				System.out.println("y is object of class: "+y.getClass());
			}
			
			if(z instanceof Integer){
				System.out.println("z is object of class: "+z.getClass());
			}else{
				System.out.println("z is object of class: "+z.getClass());
			}
			
			System.out.println("Value of a="+a+", x="+x+", y="+y+", z="+z);
			
			if(x==a){
				System.out.println("References of both a and x are same.");
			}else{
				System.out.println("References of both a and x are different.");
			}
			
			if(x==y){
				System.out.println("References of both x and y are same.");
			}else{
				System.out.println("References of both x and y are different.");
			}
			
			if(x==z){
				System.out.println("References of both x and z are same.");
			}else{
				System.out.println("References of both x and z are different.");
			}
			
			if(y==z){
				System.out.println("References of both y and z are same.");
			}else{
				System.out.println("References of both y and z are different.");
			}
			
			if(b==c){
				System.out.println("References of both b and c are same.");
			}else{
				System.out.println("References of both b and c are different.");
			}
			
			if(d==e){
				System.out.println("References of both d and e are same.");
			}else{
				System.out.println("References of both d and e are different.");
			}
			
			
		}catch(Exception exception){
			System.out.println(exception.getStackTrace());
			System.out.println(exception.getMessage());
			System.out.println(exception);
		}
	}

}
