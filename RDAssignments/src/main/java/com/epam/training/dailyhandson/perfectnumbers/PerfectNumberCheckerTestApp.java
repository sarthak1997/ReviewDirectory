package com.epam.training.dailyhandson.perfectnumbers;

import java.util.Scanner;

public class PerfectNumberCheckerTestApp {

  /**
   * Driver method to test the operation of {@link PerfectNumberChecker} class.
   * */
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Enter the number to check for perfect");
    
    int value = scanner.nextInt();
    
    PerfectNumberChecker pnc = new PerfectNumberChecker();
    
    if (pnc.checkPerfect(value)) {
      System.out.println("Perfect!");
    } else {
      System.out.println("Imperfection is bliss!");
    }
    
    scanner.close();
  }

}
