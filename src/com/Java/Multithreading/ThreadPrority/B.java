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
class B extends Thread {

    public void run() {
        System.out.println("ThreadB strated");
        for (int j = 1; j <= 5; j++) {
            System.out.println("\t From ThreadB j = " + j);
        }
        System.out.println("Exit from B");
    }
}
