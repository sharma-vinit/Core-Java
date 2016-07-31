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

/*
    The Thread class itself implements Runnable, though its run method does nothing. 
    An application can subclass Thread, providing its own implementation of run
*/
public class HelloThread extends Thread {
    public void run() {
        System.out.println("Hello from a thread!");
    }
    public static void main(String args[]) {
        (new HelloThread()).start();
    }
}
