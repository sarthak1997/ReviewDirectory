package com.epam.training.dailyhandson.perfectnumbers;

public class PerfectNumberChecker {

  /**
   * method to check whether a number is perfect or not
   * in terms of algebra.
   * 
   * @param value - 
   *                the number needed to be checked for perfect.
   *                
   * @return {@code boolean} true if the number is perfect and false if not.
   * */
  public boolean checkPerfect(int value) {
    int low = 1;
    int high = value;
    int factorsSum = low;

    while (low < high) {
      low = low + 1;
      if (value % low == 0) {
        factorsSum += low;
        high = value / low;
      }
    }

    if (factorsSum == value) {
      return true;
    }

    return false;
  }

}
