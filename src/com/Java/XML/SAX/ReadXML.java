package com.Java.XML.SAX;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadXML {
	/**
	 * DOM Parser is slow and consume a lot memory if it load a XML document which contains a lot of data. 
	 * Please consider SAX parser as solution for it, SAX is faster than DOM and use less memory. 
	 * Instead, the SAX parser use callback function (org.xml.sax.helpers.DefaultHandler) to informs clients of the XML document structure.
	 */

    public static void readXMLSAX() {
        String filePath = "XMLResources"+File.separator+"AddressBook.xml";
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            System.out.println("Reading XML file using SAX");
            DefaultHandler handler = new DefaultHandler() {

                boolean bfname = false;
                boolean blname = false;
                boolean bnname = false;
                boolean bcity = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("Start Element :" + qName);
                    if (qName.equalsIgnoreCase("FIRSTNAME")) {
                        bfname = true;
                    }
                    if (qName.equalsIgnoreCase("LASTNAME")) {
                        blname = true;
                    }
                    if (qName.equalsIgnoreCase("NICKNAME")) {
                        bnname = true;
                    }
                    if (qName.equalsIgnoreCase("CITY")) {
                        bcity = true;
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End Element :" + qName);
                }

                public void characters(char ch[], int start, int length) throws SAXException {
                    if (bfname) {
                        System.out.println("First Name : " + new String(ch, start, length));
                        bfname = false;
                    }
                    if (blname) {
                        System.out.println("Last Name : " + new String(ch, start, length));
                        blname = false;
                    }
                    if (bnname) {
                        System.out.println("Nick Name : " + new String(ch, start, length));
                        bnname = false;
                    }
                    if (bcity) {
                        System.out.println("City : " + new String(ch, start, length));
                        bcity = false;
                    }

                }
            };

            //This is normal SAX's way, does not support UTF-8.
            saxParser.parse(filePath, handler);
            
            
			/*  ********** ERRORS ********** 
			 * 1. When some special UTF-8 characters inside a XML file, and your SAX's parser is not configure to parse the UTF-8 properly, 
			 *    the following exception will be thrown. 
			 *    com.sun.org.apache.xerces.internal.impl.io.MalformedByteSequenceException: Invalid byte 1 of 1-byte UTF-8 sequence. 
			 * 2. .<?xml version="1.0"?> A small dot â€œ.â€� before the â€œ<?xml will cause the â€œorg.xml.sax.SAXParseException:
			 *    Content is not allowed in prologâ€� error message.
			 */

            //Using below commented code(override the SAXâ€™s input source) we can read file that is UTF-8 encoded.
            /*
			 * File file = new File(filePath); 
			 * InputStream inputStream= new FileInputStream(file); 
			 * Reader reader = new InputStreamReader(inputStream,"UTF-8"); 
			 * InputSource is = new InputSource(reader); 
			 * is.setEncoding("UTF-8"); saxParser.parse(is, handler);
			 */

            System.out.println("Finished reading XML file using SAX");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
