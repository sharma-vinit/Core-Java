/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java.Multithreading.ThreadDemo;
class MyThread implements Runnable {
  Thread thrd;
  boolean suspended;
  boolean stopped;

  MyThread(String name) {
    thrd = new Thread(this, name);
    suspended = false;
    stopped = false;
    thrd.start();
  }

    @Override
  public void run() {
    try {
      for (int i = 1; i < 10; i++) {
        System.out.print(".");
        Thread.sleep(50);
        synchronized (this) {
          while (suspended){
            System.out.println("\n" + thrd.getName() + " suspended. Now going to wait ...");
            wait();
          }
          if (stopped){
              System.out.println("\n" + thrd.getName() + " stopped.");
            break;
          }
        }
      }
    } catch (InterruptedException exc) {
      System.out.println(thrd.getName() + " interrupted.");
    }
    System.out.println("\n" + thrd.getName() + " exiting.");
  }

  synchronized void stop() {
    stopped = true;
    suspended = false;
    notify();
  }

  synchronized void suspend() {
    suspended = true;
  }

  synchronized void resume() {
    System.out.println("Resumed.");
    suspended = false;
    notify();
  }
}

