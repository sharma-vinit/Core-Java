package com.Java.File.ReadWrite;

import java.io.File;
import java.io.IOException;

public class TempFile {
    public void CreateTempFile() {
        try {

            //Create a temporary file in Java. (Can be used to create any file)
            File temp = File.createTempFile("temp-file-name", ".tmp");

            System.out.println("Temp file : " + temp.getAbsolutePath());

            //Temporary file is used to store the less important and temporary data, 
            //which should always be deleted when your system is terminated. 
            //The best practice is use the File.deleteOnExit() to do it.

            //Delete temporary file when the program is exited
            temp.deleteOnExit();

        //Delete temporary file immediately (Can be used to delete any file)	
        //temp.delete();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
