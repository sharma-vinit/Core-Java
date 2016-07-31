/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Java.Core.Array;

/**
 *
 * @author Vinit
 */
public class ArraysManipulation {
    
    public void getArrayLength(){
        // http://stackoverflow.com/questions/4910027/what-is-inside-code-for-array-length-in-java#answer-4910221
         int []a = {1,2,3,4,5};
         for(int b:a){
         System.out.println(b);
         }
         
        /*
            //Other way by misusing exception
            int i = 0;
            while (true) {
                try {
                    System.out.println(a[i++]);
                } catch (Exception e) {
                    break;
                }
            }
        */
    }

    
}
