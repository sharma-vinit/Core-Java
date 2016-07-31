package com.Java.File.ReadWrite;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *  JDK 7+. 
 *  http://www.javapractices.com/topic/TopicAction.do;jsessionid=D56AF43F07B7D07656552FED276467D1?Id=245
 */
public class SmallBinaryFilesAboveJDK7 {
  
  public static void main(String... aArgs) throws IOException{
	  SmallBinaryFilesAboveJDK7 binary = new SmallBinaryFilesAboveJDK7();
    byte[] bytes = binary.readSmallBinaryFile(FILE_NAME);
    log("Small - size of file read in:" + bytes.length);
    binary.writeSmallBinaryFile(bytes, OUTPUT_FILE_NAME);
  }

  final static String FILE_NAME = "C:\\Temp\\cottage.jpg";
  final static String OUTPUT_FILE_NAME = "C:\\Temp\\cottage_output.jpg";
  
  byte[] readSmallBinaryFile(String aFileName) throws IOException {
    Path path = Paths.get(aFileName);
    return Files.readAllBytes(path);
  }
  
  void writeSmallBinaryFile(byte[] aBytes, String aFileName) throws IOException {
    Path path = Paths.get(aFileName);
    Files.write(path, aBytes); //creates, overwrites
  }
  
  private static void log(Object aMsg){
    System.out.println(String.valueOf(aMsg));
  }
  
}