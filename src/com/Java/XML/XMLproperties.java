/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Java.XML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class XMLproperties {

    // The java.util.Properties class come with a storeToXML() method to store all the properties detail into a XML file easily.
    public static void storePropertiesInXML() throws FileNotFoundException, IOException{
        Properties props = new Properties();
        props.setProperty("user.info", "Developer");
        props.setProperty("user.field", "Java");

        //where to store?
        OutputStream os = new FileOutputStream("XMLResources"+File.separator+"properties.xml");

        //store the properties detail into a pre-defined XML file
        props.storeToXML(os, "Vinit","UTF-8");
       
        System.out.println("Done");
    }
    
    
    // Method to load the above XML file into properties format, and get the key â€œuser.addressâ€� value via getProperty() method. 
    public static void LoadXMLproperties() throws FileNotFoundException, IOException{
        Properties props = new Properties();
 
    	InputStream is = new FileInputStream("XMLResources"+File.separator+"properties.xml");
    	//load the xml file into properties format
    	props.loadFromXML(is);
 
    	String address = props.getProperty("user.info");
 
    	System.out.println(address);
    	System.out.println(props.getProperty("user.field"));
    }

}
