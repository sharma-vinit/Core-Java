package com.Java.File.CopyFiles;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/** JDK 7+. */
public final class CopyFilesAboveJDK7 {
  
  public static void main(String... aArgs) throws IOException {
    Path FROM = Paths.get("C:\\Temp\\from.txt");
    Path TO = Paths.get("C:\\Temp\\to.txt");
    //overwrite existing file, if exists
    CopyOption[] options = new CopyOption[]{
      StandardCopyOption.REPLACE_EXISTING,
      StandardCopyOption.COPY_ATTRIBUTES
    }; 
    Files.copy(FROM, TO, options);
  }
} 