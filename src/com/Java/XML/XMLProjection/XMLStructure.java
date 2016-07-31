package com.Java.XML.XMLProjection;

import org.xmlbeam.annotation.XBWrite;

public interface XMLStructure {
	
	@XBWrite("/create/some")
	void createaweSome(String value);
	@XBWrite("/create/some/xml/structure[@even='with Predicates']")
    void demo(String value);
}
