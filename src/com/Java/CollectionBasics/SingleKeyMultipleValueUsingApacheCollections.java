
package com.Java.CollectionBasics;

import java.util.Set;

import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;
 
/**
 * HashMap - Single Key and Multiple Values using Apache Commons Collections
 *
 * @author Jagadeesh Motamarri
 * @version 1.0
 */
public class SingleKeyMultipleValueUsingApacheCollections {
 
    public static void main(String[] args) {
 
        // create multimap to store key and values
        MultiMap multiMap = new MultiValueMap();
 
        // put values into map for A
        multiMap.put("A", "Apple");
        multiMap.put("A", "Aeroplane");
 
        // put values into map for B
        multiMap.put("B", "Bat");
        multiMap.put("B", "Banana");
 
        // put values into map for C
        multiMap.put("C", "Cat");
        multiMap.put("C", "Car");
 
        // retrieve and display values
        System.out.println("Fetching Keys and corresponding [Multiple] Values n");
 
        // get all the set of keys
        Set<String> keys = multiMap.keySet();
 
        // iterate through the key set and display key and values
        for (String key : keys) {
            System.out.println("Key = " + key);
            System.out.println("Values = " + multiMap.get(key) + "n");
        }
 
    }
}