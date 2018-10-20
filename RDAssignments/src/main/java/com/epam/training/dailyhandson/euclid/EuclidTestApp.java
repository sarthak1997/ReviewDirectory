package com.epam.training.dailyhandson.euclid;

import java.util.Scanner;

/**
 * Driver class for {@link Euclid} operations testing.
 */
public class EuclidTestApp {

  /**
   * Driver method to find greatest common divisor of two integers. If command
   * arguments are not provided, scanner is used for the remaining inputs.
   * 
   * @param args
   *          command line arguments as {@code String[]}
   */
  public static void main(String[] args) {

    int a;
    int b;
    Scanner scanner = new Scanner(System.in);
    try {
      if (2 > args.length) {
        if (0 == args.length) {
          System.out.println("Enter first number for finding greatest common divisor");
          a = scanner.nextInt();
          System.out.println("Enter second number for finding greatest common divisor");
          b = scanner.nextInt();
        } else {
          a = Integer.parseInt(args[0]);
          System.out.println("Enter second number for finding greatest common divisor");
          b = scanner.nextInt();
        }
      } else {
        a = Integer.parseInt(args[0]);
        b = Integer.parseInt(args[1]);
      }
      scanner.close();
    } catch (NumberFormatException exc) {
      System.out.println("Please enter valid arguments");
      scanner.close();
      return;
    }

    Euclid euclidObj = new Euclid();

    int result = euclidObj.greatestCommonDivisorRecursive(a, b);
    System.out.println("Greatest common divisor - " + result);
  }

}
