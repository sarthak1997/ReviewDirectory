package com.epam.training.singletonpattern;

/**
 * This class implements the singleton pattern with lazy instantiation and double locking mechanism.
 * */
public class SingletonLazy {

  private static SingletonLazy instance = null;

  private SingletonLazy() {
  }

  /**
   * instance distributor method with lazy instantiation
   * by double locking mechanism.
   * */
  public static SingletonLazy getInstance() {
    if (instance == null) {
      synchronized (SingletonLazy.class) {
        if (instance == null) {
          instance = new SingletonLazy();
        }
      }
    }
    return instance;
  }

}
