/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Java.XML.JDOM;

/**
 *
 * @author vinit.sharma
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class CreatingXmlUsingJDOM {
	
	
    public static void createXMLJDOM() {
		/* XML Structure
		 * <rows>
		 *  <row>
		 *   <firstname>Alice</firstname>
		 *   <lastname>Starbuzz</lastname>
		 *   <address>Sunset Read</address>
		 *  </row>
		 * </rows>
		 */

        Document document = new Document();
        Element root = new Element("rows");

        //Creating a child for the root element. Here we can see how to set the text of an xml element.
        Element child = new Element("row");
        child.addContent(new Element("firstname").setText("Vinit"));
        child.addContent(new Element("lastname").setText("Sharma"));
        child.addContent(new Element("address").setText("Chandigarh"));

        // Add the child to the root element and add the root element as the document content.
        root.addContent(child);
        document.setContent(root);
        
        try {
            FileWriter writer = new FileWriter("XMLResources"+File.separator+"UserInfo.xml");
            XMLOutputter outputter = new XMLOutputter();

			/* Set the XLMOutputter to pretty formatter. This formatter use the TextMode.TRIM, 
			 * which mean it will remove the trailing white-spaces of both side (left and right).
			 */
            outputter.setFormat(Format.getPrettyFormat());
            
            // Write the document to a file and also display it on the screen through System.out.
            outputter.output(document, writer);
            outputter.output(document, System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}