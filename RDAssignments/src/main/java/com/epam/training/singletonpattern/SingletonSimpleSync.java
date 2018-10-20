package com.epam.training.singletonpattern;

/**
 * Singleton class implementing the simple naive synchronization mechanism.
 */
public class SingletonSimpleSync {

  private static SingletonSimpleSync instance;
  private static int counter;

  private SingletonSimpleSync() {
    counter = 0;
  }

  /**
   * Instance distributor method for singleton class with normal synchronization.
   */
  public static synchronized SingletonSimpleSync getInstance() {
    if (null == instance) {
      instance = new SingletonSimpleSync();
      counter++;
    } else {
      counter++;
    }
    if (0 == counter % 2) {
      System.out.println("Even Instantiation");
    } else {
      System.out.println("Odd Instantiation");
    }
    return instance;
  }

}
