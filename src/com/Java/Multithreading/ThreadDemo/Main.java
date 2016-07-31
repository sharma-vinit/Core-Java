/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java.Multithreading.ThreadDemo;

public class Main {
  public static void main(String args[]) throws Exception {
    MyThread mt = new MyThread("MyThread");
    Thread.sleep(100);
    mt.suspend();
    Thread.sleep(100);

    mt.resume();
    Thread.sleep(100);

    mt.stop();
  }
}
