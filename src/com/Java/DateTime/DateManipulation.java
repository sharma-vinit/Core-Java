/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Java.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author vinit.sharma
 */
public class DateManipulation {
    
    //  Date.compareTo()
    /*
        - Return value is 0 if both dates are equal.
        - Return value is greater than 0 , if Date is after the date argument.
        - Return value is less than 0, if Date is before the date argument.
     */
    
    public void compareDate(){
        try{
 
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        	Date date1 = sdf.parse("2009-12-31");
        	Date date2 = sdf.parse("2010-01-31");
 
        	System.out.println(sdf.format(date1));
        	System.out.println(sdf.format(date2));
 
        	if(date1.compareTo(date2)>0){
        		System.out.println("Date1 is after Date2");
        	}else if(date1.compareTo(date2)<0){
        		System.out.println("Date1 is before Date2");
        	}else if(date1.compareTo(date2)==0){
        		System.out.println("Date1 is equal to Date2");
        	}else{
        		System.out.println("How to get here?");
        	}
 
    	}catch(ParseException ex){
    		ex.printStackTrace();
    	}
    }
    
    //  Date.before(), Date.after() and Date.equals()
    //  A more user friendly method to compare two dates.
    public void compareDateEasy(){
        try{
 
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        	Date date1 = sdf.parse("2009-12-31");
        	Date date2 = sdf.parse("2010-01-31");
 
        	System.out.println(sdf.format(date1));
        	System.out.println(sdf.format(date2));
 
        	if(date1.after(date2)){
        		System.out.println("Date1 is after Date2");
        	}
 
        	if(date1.before(date2)){
        		System.out.println("Date1 is before Date2");
        	}
 
        	if(date1.equals(date2)){
        		System.out.println("Date1 is equal Date2");
        	}
 
    	}catch(ParseException ex){
    		ex.printStackTrace();
    	}
    }
    
    //  Calender.before(), Calender.after() and Calender.equals()
    //  A way to compare two dates with Calendar object.
    public void compareDateViaCAL(){
        try{
 
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        	Date date1 = sdf.parse("2009-12-31");
        	Date date2 = sdf.parse("2010-01-31");
 
        	System.out.println(sdf.format(date1));
        	System.out.println(sdf.format(date2));
 
        	Calendar cal1 = Calendar.getInstance();
        	Calendar cal2 = Calendar.getInstance();
        	cal1.setTime(date1);
        	cal2.setTime(date2);
 
        	if(cal1.after(cal2)){
        		System.out.println("Date1 is after Date2");
        	}
 
        	if(cal1.before(cal2)){
        		System.out.println("Date1 is before Date2");
        	}
 
        	if(cal1.equals(cal2)){
        		System.out.println("Date1 is equal Date2");
        	}
 
    	}catch(ParseException ex){
    		ex.printStackTrace();
    	}
    }
}
