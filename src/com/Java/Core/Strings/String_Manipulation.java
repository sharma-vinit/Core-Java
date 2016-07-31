/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Java.Core.Strings;

/**
 *
 * @author vinit.sharma
 */
public class String_Manipulation {
    
    
    public void StringComp(){
        String string1 = "Hello String !";
        //value in String constant pool
        String string2 = string1;
 
        if (string1 == string2) //compare the references, NOT the values
        {
            System.out.println("EQUAL");
        } else {
            System.out.println("NOT equal");
        }
 
        String string3 = new String("Hello String !");  //value in Heap
 
        if (string1 == string3) //compare the references, NOT the values
        {
            System.out.println("EQUAL");
        } else {
            System.out.println("NOT equal");
        }
 
        if (string1.equals(string3)) //compare the values
        {
            System.out.println("EQUAL");
        } else {
            System.out.println("NOT equal");
        }
    }
    
    public void stringPresentation(){
        String dateInspected = "(Grafted KPI,L2)HELPDESK";
            
            String[] temp;
            String dd = null;
            String mm = null;
            String yyyy = null;
            String InspectedDateFormatted;

            /* delimiter */
            //String delimiter = 41;
            int i = 41;
            String delimiter = new Character((char)i).toString();
            System.out.println(delimiter);

            
            System.out.println(dateInspected.indexOf(delimiter));
            
            System.out.println(dateInspected.substring((dateInspected.indexOf(delimiter)+1), dateInspected.length()));

            /* given string will be split by the argument delimiter provided. */
           // temp = dateInspected.split(delimiter);

            /* print substrings */
           // yyyy = temp[0];
            //mm = temp[1];
            //dd = temp[2];


            //InspectedDateFormatted = dd + "-------" + mm + "-------" + yyyy;
    }
    
    public void StringTrim(){
        String w = " Hello World ";
        System.out.println("hh"+w.trim()+"hh");              
        System.out.println(trim(w));
        System.out.println(ltrim(w));
        System.out.println(rtrim(w));
        System.out.println(itrim(w));
        
    }
     /* remove all superfluous whitespaces in source string */
    public static String trim(String source) {
        return itrim(ltrim(rtrim(source)));
    }
    
    /* remove leading whitespace */
    public static String ltrim(String source) {
        return source.replaceAll("^\\s+", "");
    }

    /* remove trailing whitespace */
    public static String rtrim(String source) {
        return source.replaceAll("\\s+$", "");
    }

    /* replace multiple whitespaces between words with single blank */
    public static String itrim(String source) {
        return source.replaceAll("\\b\\s{2,}\\b", " ");
    }

}
