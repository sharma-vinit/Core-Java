package com.Java.File.RecursiveFileListing;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/** 
 * http://www.javapractices.com/topic/TopicAction.do?Id=68
 * Recursive listing with SimpleFileVisitor in JDK 7. 
 */
public final class FileListingVisitorJDK7AndAbove {
  
  public static void main(String... aArgs) throws IOException{
    String ROOT = "E:\\Songs";
    FileVisitor<Path> fileProcessor = new ProcessFile();
    Files.walkFileTree(Paths.get(ROOT), fileProcessor);
  }

  private static final class ProcessFile extends SimpleFileVisitor<Path> {
    @Override public FileVisitResult visitFile(
      Path aFile, BasicFileAttributes aAttrs
    ) throws IOException {
      System.out.println("Processing file:" + aFile);
      return FileVisitResult.CONTINUE;
    }
    
    @Override  public FileVisitResult preVisitDirectory(
      Path aDir, BasicFileAttributes aAttrs
    ) throws IOException {
      System.out.println("Processing directory:" + aDir);
      return FileVisitResult.CONTINUE;
    }
  }
} 