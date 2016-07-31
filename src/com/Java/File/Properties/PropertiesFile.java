/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Java.File.Properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author vinit.sharma
 */

//  Properties file is always used to store the configuration data or settings.
public class PropertiesFile {
    
    public void createPropFile(){
        Properties prop = new Properties();
 
    	try {
    		//set the properties value
    		prop.setProperty("database", "localhost");
    		prop.setProperty("dbuser", "Vinit");
    		prop.setProperty("dbpassword", "password");
 
    		//save properties to project root folder
    		prop.store(new FileOutputStream("config.properties"), null);
 
    	} catch (IOException ex) {
    		ex.printStackTrace();
        }
    }

}
