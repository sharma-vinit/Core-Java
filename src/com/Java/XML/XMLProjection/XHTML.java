/**
 * 
 */
package com.Java.XML.XMLProjection;

import org.xmlbeam.annotation.XBWrite;

/**
 * @author Vinit
 *
 */
public interface XHTML {
    @XBWrite("/html/@xmlns")
    XHTML setRootNameSpace(String ns);
     
    @XBWrite("/html/@xml:lang")
    XHTML setRootLang(String lang);
     
    @XBWrite("/html/head/title")
    XHTML setTitle(String title);
     
    @XBWrite("/html/body")
    XHTML setBody(String body);
}
