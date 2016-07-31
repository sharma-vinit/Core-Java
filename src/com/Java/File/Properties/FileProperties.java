/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java.File.Properties;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.StringTokenizer;

/**
 *
 * @author vinit.sharma
 */
public class FileProperties {

    public void isFileHidden() {
        /*
         * Note:
         *  The isHidden() method is system dependent, 
         *  on UNIX platform, a file is considered hidden if itâ€™s name is begins with a â€œdotâ€� symbol (â€˜.â€™); 
         *  On Microsoft Windows platform, a file is considered to be hidden, if itâ€™s marked as hidden in the file properties.
         */

        File file = new File("C:\\temp");

        //  Use of java.io.File isHidden() to check if a file is hidden.
        if (file.isHidden()) {
            System.out.println("This file is hidden");
        } else {
            System.out.println("This file is not hidden");
        }
    }

    public void getFileCreationDate() {
        try {

            Process proc = Runtime.getRuntime().exec("cmd /c dir C:\\temp\\Report.csv /tc");

            BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));

            String data = "";

            //it's quite stupid but work
            //reach upto the line where our required result is present on command prompt.
            for (int i = 0; i < 6; i++) {
                data = br.readLine();
            }

            System.out.println("Extracted value : " + data);

            //split by space
            StringTokenizer st = new StringTokenizer(data);
            String date = st.nextToken();//Get date
            String time = st.nextToken();//Get time

            System.out.println("Creation Date  : " + date);
            System.out.println("Creation Time  : " + time);

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    public void renameFile() {
        File oldfile = new File("C:\\temp\\Report.csv");
        File newfile = new File("C:\\temp\\NewReport.csv");

        if (oldfile.renameTo(newfile)) {
            System.out.println("Rename succesful");
        } else {
            System.out.println("Rename failed");
        }
    }
    
    public void readLineNumber(){
        /*
            The LineNumberReader class is a useful class to handle the lines of a file, 
            you can loop the LineNumberReader.readLine() method and accumulate it as the 
            total number of lines. A line is considered a line if it ends with a line feed 
            (â€˜\nâ€™) or a carriage return (â€˜\râ€™).
         */
        
        try{
 
    		File file =new File("c:\\lineTest.txt");
 
    		if(file.exists()){
 
    		    FileReader fr = new FileReader(file);
    		    LineNumberReader lnr = new LineNumberReader(fr);
 
    		    int linenumber = 0;
 
    	            while (lnr.readLine() != null){
    	        	linenumber++;
                        if(linenumber==6){
                            System.out.println("Current number of line: " + linenumber);
                        }
    	            }
 
    	            System.out.println("Total number of lines : " + linenumber);
 
    	            lnr.close();
 
 
    		}else{
    			 System.out.println("File does not exists!");
    		}
 
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }
}
