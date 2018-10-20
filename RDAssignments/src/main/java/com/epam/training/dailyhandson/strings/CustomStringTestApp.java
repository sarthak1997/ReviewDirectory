package com.epam.training.dailyhandson.strings;

import java.util.Scanner;

/**
 * Driver class for {@link CustomString} operations testing.
 */
public class CustomStringTestApp {

  /**
   * Driver method to test the operations implemented in Strings class.
   */
  public static void main(String[] args) {

    String str = "";
    Scanner scanner = new Scanner(System.in);
    if (0 == args.length) {
      System.out.println("Enter the string for operations");
      str = scanner.nextLine();
    } else {
      str = args[0];
    }
    scanner.close();

    CustomString testObj = new CustomString(str);

    testObj.capitalize();
    System.out.println(testObj);
    testObj.encode(';');
    System.out.println(testObj);
    testObj.decode(';');
    System.out.println(testObj);
    testObj.convertHungarianToEnglish();
    System.out.println(testObj);
  }

}
