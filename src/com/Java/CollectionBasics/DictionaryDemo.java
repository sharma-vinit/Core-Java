/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Java.CollectionBasics;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Vinit
 */
public class DictionaryDemo {
    /*
    Dictionary is an abstract class that represents a key/value storage repository and operates much like Map.
    Given a key and value, you can store the value in a Dictionary object. 
    Once the value is stored, you can retrieve it by using its key. 
    Thus, like a map, a dictionary can be thought of as a list of key/value pairs.
    The Dictionary class is obsolete. You should implement the Map interface to obtain key/value storage functionality.
    */
    
    public static void main(String[] args) {
      Map m1 = new HashMap(); 
      m1.put("Zara", "8");
      m1.put("Mahnaz", "31");
      m1.put("Ayan", "12");
      m1.put("Daisy", "14");
      System.out.println();
      System.out.println(" Map Elements");
      System.out.print("\t" + m1);
   }
}
