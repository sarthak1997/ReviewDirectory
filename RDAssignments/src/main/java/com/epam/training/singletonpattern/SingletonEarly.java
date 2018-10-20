package com.epam.training.singletonpattern;

/**
 * This class implements the singleton pattern with early instantiation mechanism.
 * */
public class SingletonEarly {

  private static SingletonEarly instance = new SingletonEarly();

  private SingletonEarly() {
  }

  public static SingletonEarly getInstance() {
    return instance;
  }

}
