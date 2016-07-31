package com.Java.XML.DOM;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GenerateXML {

	/**
	 * Create XML file in Java-(DOM).
	 * DOM provides many handy classes to create a XML file in Java. 
	 * Firstly, you have to create a Document with DocumentBuilder class, define all the XML content - node, attribute with
	 * Element class. In last, use Transformer class to output all the XML content in a File.
	 */

	public static void generateXmlUsingDom() {
		try {
			System.out.println("AddressBook.xml is being generated using DOM.");

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// new Document
			Document doc = docBuilder.newDocument();

			// root elements
			Element rootElement = doc.createElement("address");
			doc.appendChild(rootElement);

			// Serial No. elements
			Element SNo = doc.createElement("S.No.");
			rootElement.appendChild(SNo);

			// set attribute to Serial No. element
			Attr attr = doc.createAttribute("id");
			attr.setValue("1");
			SNo.setAttributeNode(attr);

			// shorter way
			// SNo.setAttribute("id", "1");

			// firstname elements
			Element firstname = doc.createElement("firstname");
			firstname.appendChild(doc.createTextNode("Vinit"));
			SNo.appendChild(firstname);

			// lastname elements
			Element lastname = doc.createElement("lastname");
			lastname.appendChild(doc.createTextNode("Sharma"));
			SNo.appendChild(lastname);

			// nickname elements
			Element nickname = doc.createElement("nickname");
			nickname.appendChild(doc.createTextNode("Vicky"));
			SNo.appendChild(nickname);

			// city elements
			Element city = doc.createElement("city");
			city.appendChild(doc.createTextNode("Chandigarh"));
			SNo.appendChild(city);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);

			// To output all the XML content
			StreamResult result = new StreamResult(new File("XMLResources"+File.separator+"AddressBook.xml"));
			transformer.transform(source, result);

			/*
			 * For debugging, you can change the StreamResult to output the XML content into your console. 
			 * StreamResult resultConsole = new StreamResult(System.out); 
			 * transformer.transform(source, resultConsole);
			 */

			System.out.println("AddressBook.xml is generated using DOM");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
}
