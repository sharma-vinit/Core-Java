package com.Java.XML.XMLProjection;

import org.xmlbeam.XBProjector;
import org.xmlbeam.XBProjector.Flags;

/**
 * http://xmlbeam.org/tutorials.html
 * @author Vinit
 *
 */
public class CreateXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateXML.createXHTML();
		CreateXML.createXML();
	}

	public static void createXHTML() {
		XHTML xhtml = new XBProjector(Flags.TO_STRING_RENDERS_XML).projectEmptyDocument(XHTML.class);
		 
		xhtml.setRootNameSpace("http://www.w3.org/1999/xhtml").setRootLang("en");
		xhtml.setTitle("This Is My Fine Title");
		xhtml.setBody("Here some text...");
		
		System.out.println(xhtml);
	}
	
	public static void createXML() {
		XMLStructure projection = new XBProjector(Flags.TO_STRING_RENDERS_XML).projectEmptyDocument(XMLStructure.class);
		projection.createaweSome("createNow");
		projection.demo("Some value");
	    System.out.println(projection);
	 }
}
