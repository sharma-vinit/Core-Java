package com.Java.Multithreading.ThreadGroup;

class Main {
  public static void main(String[] args) throws Exception {
    ThreadGroup tg = Thread.currentThread().getThreadGroup();

    MyThread mt1 = new MyThread(tg, "first");
    MyThread mt2 = new MyThread(tg, "second");

    mt1.start();
    mt2.start();

    ThreadGroup parent = tg.getParent();
    int size = parent.activeCount();      
    Thread[] list = new Thread[size];
    int count = parent.enumerate(list, true);
    String[] thdinfo = new String[count];
    for (int i = 0; i < count; i++)
      thdinfo[i] = list[i].toString();

    mt1.join();
    mt2.join();

    for (int i = 0; i < count; i++)
      System.out.println(thdinfo[i]);
  }
}

class MyThread extends Thread {
  MyThread(ThreadGroup tg, String name) {
    super(tg, name);
  }

  public void run() {
    for (char c = 'A'; c <= 'Z'; c++)
      System.out.println(c);

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
    }
  }
}