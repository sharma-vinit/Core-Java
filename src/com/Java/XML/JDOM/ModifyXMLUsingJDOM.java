package com.Java.XML.JDOM;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * A Java class using JDOM to modify the XML file.
 * @author Vinit
 */
public class ModifyXMLUsingJDOM {

	public static void modifyXmlJDOM() {

		try {
			String filepath = "XMLResources"+File.separator+"AddressBook.xml";
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);

			// Get the root element
			Node address = doc.getFirstChild();

			/* Get the SNo element , it may not work if tag has spaces, or whatever weird characters in front.
			 * It's better to use getElementsByTagName() to get it directly. 
			 * Node SNo = company.getFirstChild();
			 */

			// Get the SNo element by tag name directly
			Node SNo = doc.getElementsByTagName("S.No.").item(0);

			// update SNo attribute
			NamedNodeMap attr = SNo.getAttributes();
			Node nodeAttr = attr.getNamedItem("id");
			nodeAttr.setTextContent("2");

			// append a new node to SNo
			Element age = doc.createElement("age");
			age.appendChild(doc.createTextNode("28"));
			SNo.appendChild(age);

			// loop the SNo child node
			NodeList list = SNo.getChildNodes();

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				// get the salary element, and update the value
				if ("city".equals(node.getNodeName())) {
					node.setTextContent("Bangalore");
				}
			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.transform(source, result);

			System.out.println("AdressBook.xml is modified using JDOM");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}
	}
}
