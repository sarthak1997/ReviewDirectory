package com.epam.training.singletonpattern;

/**
 * Driver class to test the different singleton classes implemented using two threads.
 * */
public class ThreadSingletonTest extends Thread {

  SingletonSimpleSync instance;

  /**
   * Driver method to test the different synchronization implemented in 
   * getInstance() methods of singleton classes.
   * */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ThreadSingletonTest t1 = new ThreadSingletonTest();
    t1.start();
    ThreadSingletonTest t2 = new ThreadSingletonTest();
    t2.start();
  }

  @Override
  public void run() {
    while (true) {
      /*SingletonClass name can be changed to SingletonSimpleSync, 
        SingletonLazy or SingletonEarly based upon the testing of them*/
      instance = SingletonSimpleSync.getInstance();
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

}
