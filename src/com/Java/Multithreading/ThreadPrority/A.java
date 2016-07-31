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
class A extends Thread {

    public void run() {
        System.out.println("ThreadA strated");
        for (int i = 1; i <= 5; i++) {
            System.out.println("\t From ThreadA i = " + i);
        }
        System.out.println("Exit from A");
    }
}


