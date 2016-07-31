package com.Java.Basics.FlowControl;

/*
 * 	switch (expression) {
 *     	case constant1: code block
 *      case constant2: code block
 *      default: code block
 *  }
 */

public class switchConditionalFlow {
	enum Color {red, green, blue}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Color c = Color.green;
        switch(c) {
            case red: System.out.print("red ");
            case green: System.out.print("green ");
            case blue: System.out.print("blue ");
            default: System.out.println("done");
        }
        
        final int a = 1;
        final int b;
        b = 2;
        int value = 0;
        switch (value) {
	        case a: // ok
	        //case b: // compiler error - case expressions must be constant expressions
        }
        
    	byte g = 2;
    	switch(g) {
    		case 23:
    		//case 128:	// compiler error - Type mismatch: cannot convert from int to byte
    	}

    	int temp = 90;
    	switch(temp) {
    		case 80 : System.out.println("80");
    		//case 80 : System.out.println("80"); // won't compile! compiler error -	Duplicate case
    		case 90 : System.out.println("90");
    		default : System.out.println("default");
    	}

    	switch(new Integer(4)) {
			case 4: System.out.println("boxing is OK");	// It is legal to leverage the power of boxing in a switch expression.
    	}
    	
    	int x = 2;
    	switch (x) {
    	    case 2: System.out.println("2");
    	    default: System.out.println("default");
    	    case 3: System.out.println("3");
    	    case 4: System.out.println("4");
    	}


	}

}
