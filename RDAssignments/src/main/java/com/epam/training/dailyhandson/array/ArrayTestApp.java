package com.epam.training.dailyhandson.array;

import java.util.Scanner;

/**
 * Driver class for {@link Array} operations testing.
 * */
public class ArrayTestApp {

  /**
   * Driver method to perform different operations on arrays present in the class.
   * If command arguments are not provided, scanner is used for the remaining
   * inputs.
   * 
   * @param args
   *          as {@code String[]} command line arguments with first argument as
   *          size of array
   */
  public static void main(final String[] args) {

    int size;
    Double[] arr;
    Scanner scanner = new Scanner(System.in);

    try {
      if (args.length != 0) {
        size = Integer.parseInt(args[0]);
        if (size < 0) {
          System.out.println("Size of the array can not be zero!");
          scanner.close();
          return;
        }
        arr = new Double[size];

        for (int i = 1; i < args.length && i <= size; i++) {
          arr[i - 1] = Double.parseDouble(args[i]);
        }
        if (args.length - 1 < size) {
          System.out.println("Please enter the remaining " + "" 
              + (size - (args.length - 1)) + " elements");
          for (int j = args.length - 1; j < size; j++) {
            arr[j] = scanner.nextDouble();
          }
        }
      } else {
        System.out.println("Please enter the size of array - ");
        size = scanner.nextInt();
        if (size < 0) {
          System.out.println("Size of the array can not be zero!");
          scanner.close();
          return;
        }
        arr = new Double[size];
        System.out.println("Enter the elemets of the array");
        for (int i = 0; i < size; i++) {
          arr[i] = scanner.nextDouble();
        }
      }
      scanner.close();
    } catch (NumberFormatException exc) {
      System.out.println(exc.getMessage());
      scanner.close();
      return;
    }

    Array<Double> arrObject = new Array<>(arr);

    System.out.println("Average=" + arrObject.avg() + " Sum=" + arrObject.sum());

  }

}
