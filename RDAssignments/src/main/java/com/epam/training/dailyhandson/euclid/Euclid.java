package com.epam.training.dailyhandson.euclid;

/**
 * This class is intended to contain all the euclid operations.
 */
public class Euclid {

  /**
   * This method finds the greatest common divisor between two integers using
   * recursive approach.
   * 
   * @param a
   *          - First argument as an {@code int}
   * @param b
   *          - Second argument as an {@code int}
   * @return {@code int} which is greatest common divisor of the two arguments
   */
  public int greatestCommonDivisorRecursive(int a, int b) {
    if (0 == a || a == b) {
      return b;
    } else if (0 == b) {
      return a;
    } else if (0 == a % 2 && 0 == b % 2) {
      return 2 * greatestCommonDivisorRecursive(a / 2, b / 2);
    } else if (0 == a % 2) {
      return greatestCommonDivisorRecursive(a / 2, b);
    } else if (0 == b % 2) {
      return greatestCommonDivisorRecursive(a, b / 2);
    } else {
      return greatestCommonDivisorRecursive((Math.abs(a - b)) / 2, a);
    }
  }

}