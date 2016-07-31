package com.Java.XML.DOM;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


/**
 * Validate XML document specified via DTD using DOM Parser
 */
public class DOMDTDValidation {
   public static void main(String args[]) {
      try {
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         // Enable the document validation as the document is being parsed.
         factory.setValidating(true);
         DocumentBuilder builder = factory.newDocumentBuilder();
   
         builder.setErrorHandler(new ErrorHandler() {  // anonymous inner class
            //Ignore the fatal errors
            @Override
            public void fatalError(SAXParseException exception) throws SAXException {}
   
            // Report validation errors
            @Override
            public void error(SAXParseException e) throws SAXParseException {
               System.out.print("Error at line " + e.getLineNumber() + ": ");
               System.out.println(e.getMessage());
            }
   
            // Report warnings
            @Override
            public void warning(SAXParseException e) throws SAXParseException {
               System.out.print("Warning at line " + e.getLineNumber() + ": ");
               System.out.println(e.getMessage());
            }
         });

         // External DTD validation
         Document xmlDocument = builder.parse(new File("bookstore-externalDTD.xml"));
         DOMSource source = new DOMSource(xmlDocument);
         StreamResult result = new StreamResult(System.out);
         TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer();
         transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "bookstore.dtd");
         transformer.transform(source, result);
   
         // Internal DTD validation
         xmlDocument = builder.parse(new File("bookstore-inlineDTD.xml"));
         source = new DOMSource(xmlDocument);
         result = new StreamResult(System.out);
         transformer.transform(source, result);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
