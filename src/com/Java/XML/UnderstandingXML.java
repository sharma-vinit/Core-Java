package com.Java.XML;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.Java.XML.DOM.GenerateXML;
import com.Java.XML.JDOM.CreatingXmlUsingJDOM;
import com.Java.XML.JDOM.ModifyXMLUsingJDOM;
import com.Java.XML.JDOM.ReadXmlDocumentJDOM;

public class UnderstandingXML {
	public static void main(String[] args) {
		
		//Generate XML file using DOM. -->	Address.xml
		GenerateXML.generateXmlUsingDom();
		//Generate XML file using JDOM. --> UserInfo.xml
		CreatingXmlUsingJDOM.createXMLJDOM();
		
		// Read XML using JDOM. --> UserInfoData.xml
		ReadXmlDocumentJDOM.readXMLJDOM();
		// Read XML using SAX. --> AddressBook.xml
		com.Java.XML.SAX.ReadXML.readXMLSAX();
		
		// Modify XML using JDOM. --> AddressBook.xml
		ModifyXMLUsingJDOM.modifyXmlJDOM();
		
		// Read XML using DOM. --> AddressBook.xml
		com.Java.XML.DOM.ReadXML.readXMLfileDOM();
		
		// Store Properties in XML file
		try {
			XMLproperties.storePropertiesInXML();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Load XML Properties from a xml property file
		try {
			XMLproperties.LoadXMLproperties();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
