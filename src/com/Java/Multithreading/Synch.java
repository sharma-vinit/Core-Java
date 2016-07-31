/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Java.Multithreading;

/**
 *
 * @author Vinit
 */
public class Synch {
   public static void main(String args[]) {
      Callme target = new Callme();
      Caller ob1 = new Caller(target, "Hello");
      Caller ob2 = new Caller(target, "Synchronized");
      Caller ob3 = new Caller(target, "World");
      Caller ob4 = new Caller(target, "war");
   
      // wait for threads to end
      try {
         ob1.t.join();
         ob2.t.join();
         ob3.t.join();
         ob4.t.join();
      } catch(InterruptedException e) {
         System.out.println("Interrupted");
      }
   }
}
