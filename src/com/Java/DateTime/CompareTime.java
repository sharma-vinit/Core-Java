package com.Java.DateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class CompareTime {
    public static void main(String[] args) {
        if(new CompareTime().compareTime24Hours("2014-08-20 04:24:14")){
            System.out.println("Greater than 24 hours");
        }
    }
	public boolean compareTime24Hours(String time){
		boolean flag = false;
		
		String currentTime = GetCurrentDateTime();
		System.out.println("currentTime:"+currentTime);
		String quoteTime = time;
		System.out.println("quoteTime:"+quoteTime);
		DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		DateTime time1 = format.parseDateTime(currentTime);
		DateTime time2 = format.parseDateTime(quoteTime);
		
		System.out.println("time2:"+time2);
		
		Hours interval = Hours.hoursBetween(time2, time1);
		
		System.out.println("Interval:"+interval);
		Hours minInterval = Hours.hours(24);
                
                System.out.println("Hours in between:"+ interval.getHours());

		if(interval.getHours()>24){
		  flag = true;
		}
		else{
		  flag = false;
		}
		          System.out.println(flag);
		return flag;
	}
	
	private String GetCurrentDateTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//2012-04-08 06:05:23
	   //get current date time with Date()
	   Date date = new Date();
	   return dateFormat.format(date);
    }
}
