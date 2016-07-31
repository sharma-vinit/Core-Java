package com.Java.XML.DOM;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXML {
	/**
	 * The DOM interface is the easiest to understand. It parses an entire XML document and load it into memory, 
	 * modeling it with Object for the traversal.
	 */
	public static void readXMLfileDOM() {
		try {

			File fXmlFile = new File("XMLResources"+File.separator+"AddressBook.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			System.out.println("Root element :"+ doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("S.No.");
			System.out.println("-----------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("First Name : "+ getTagValue("firstname", eElement));
					System.out.println("Last Name : "+ getTagValue("lastname", eElement));
					System.out.println("Nick Name : "+ getTagValue("nickname", eElement));
					System.out.println("City : "+ getTagValue("city", eElement));
					System.out.println("Age : " + getTagValue("age", eElement));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    private static String getTagValue(String sTag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        return nValue.getNodeValue();
    }
}
