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
    Provide a Runnable object. 
    The Runnable interface defines a single method, run, meant to contain the code executed in the thread.
    The Runnable object is passed to the Thread constructor
*/
public class HelloRunnable implements Runnable {
    public void run() {
        System.out.println("Hello from a thread!");
    }
    public static void main(String args[]) {
        (new Thread(new HelloRunnable())).start();
                //Or
        new Thread(new HelloRunnable()).start();
    }
}

