/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java.CollectionBasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Vinit
 */
public class CollectionsDemo {

    public static void main(String[] args) {

        String[] arr = {"1", "2", "3"};
        /*
        http://www.wikihow.com/Print-an-Array-in-Java
        http://stackoverflow.com/questions/3442090/java-what-is-this-ljava-lang-object#answer-3442100
        */        
        System.out.println("Print an Array "+arr + "  This is equal to arrayObject.getClass().getName() + '@' + Integer.toHexString(arrayObject.hashCode()): "+arr.getClass().getName() + '@' + Integer.toHexString(arr.hashCode()) );
        /*
        The reason why the toString() method on arrays returns String in this format is 
        because arrays do not @Override the method inherited from Object 
        whereas Collection interfaces uses @Overrided method of toString() from AbstractCollection<E>.
        */        
        System.out.println("Arrays.deepToString() method"+Arrays.deepToString(arr));
        System.out.println("Arrays.toString() method"+Arrays.toString(arr));

        List a1 = new ArrayList();
        a1.add("Zara");
        a1.add("Mahnaz");
        a1.add("Ayan");
        System.out.println(" ArrayList Elements");
        System.out.print("\t" + a1);

        List l1 = new LinkedList();
        l1.add("Zara");
        l1.add("Mahnaz");
        l1.add("Ayan");
        System.out.println();
        System.out.println(" LinkedList Elements");
        System.out.print("\t" + l1);

        Set s1 = new HashSet();
        s1.add("Zara");
        s1.add("Mahnaz");
        s1.add("Ayan");
        System.out.println();
        System.out.println(" Set Elements");
        System.out.print("\t" + s1);

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
