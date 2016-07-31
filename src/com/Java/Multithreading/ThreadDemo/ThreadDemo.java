/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java.Multithreading.ThreadDemo;

class ThreadDemo {
  public static void main(String args[]) {    
    Thread t = new Thread(new Runnable(){
        int i = 0;
            @Override
            public void run() {
                System.out.println("Within 'Child Thread' @ "+System.currentTimeMillis());
                //System.out.println(Thread.currentThread()+" thread is alive:"+Thread.currentThread().isAlive());
            }        
    }, "Child Thread"); 

    System.out.println("Starting Thread: " + t);
    System.out.println("This displays, in order: [the name of the thread, its priority, and the name of its group].\nBy default, the name of the main thread is main.\nIts priority is 5, which is the default value, and main is also the name of the group of threads to which this thread belongs.\nA thread group is a data structure that controls the state of a collection of threads as a whole.");

    t.setDaemon(false);
    t.start();

    System.out.println(Thread.currentThread()+" thread is alive:"+Thread.currentThread().isAlive());
    System.out.println(t+" thread is alive:"+t.isAlive());

    System.out.println("'Main' thread exiting @ "+System.currentTimeMillis());
    /*
     * Most of the times output to this program is 
     * 'Main' thread exiting @ 1406971862950
     * Within 'Child Thread' @ 1406971862952
     * 
     * Does this mean that main thread exits before child thread? if yes, then why is this happening ?
     */    
  }
}