/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java.Multithreading.ThreadPrority;

/**
 *
 * @author Vinit
 */
public class Thread_Priority {

    public static void main(String[] args) {
        A threadA = new A();
        B threadB = new B();

        threadA.setPriority(Thread.MIN_PRIORITY);
        threadB.setPriority(threadA.getPriority() + 3);

        System.out.println("Start Thread A");
        threadA.start();

        System.out.println("Start Thread B");
        threadB.start();

        System.out.println("End of main Thread");
    }
}
