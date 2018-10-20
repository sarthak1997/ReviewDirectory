package com.epam.training.dailyhandson.multidimensionalarray;

import com.epam.training.dailyhandson.exceptions.AsymmetricMatrixException;
import com.epam.training.dailyhandson.exceptions.InvalidSizeException;

import java.util.Scanner;


/**
 * Driver class for {@link TwoDimensionalArrays} operations testing.
 * */
public class TwoDimensionalArraysTestApp {

  /**
   * driver method to test the operations present in {@link TwoDimensionalArrays} class.
   * */
  public static void main(String[] args) throws InvalidSizeException, AsymmetricMatrixException {

    int rows = 0;
    int cols = 0;
    Scanner scanner = new Scanner(System.in);
    Double[][] arr = null;
    try {
      if (args.length == 0) {
        System.out.println("Enter number of rows");
        rows = scanner.nextInt();
        if (rows < 0) {
          scanner.close();
          throw new InvalidSizeException("Rows size in 2-d array cannot be negative");
        }
        System.out.println("Enter number of columns");
        cols = scanner.nextInt();
        if (cols < 0) {
          scanner.close();
          throw new InvalidSizeException("Columns size in 2-d array cannot be negative");
        }

        arr = new Double[rows][cols];

        System.out.println("Enter elements of two-dimensional array");

        for (int i = 0; i < rows; i++) {
          for (int j = 0; j < cols; j++) {
            arr[i][j] = scanner.nextDouble();
          }
        }
      } else if (args.length == 1) {
        rows = Integer.parseInt(args[0]);
        if (rows < 0) {
          scanner.close();
          throw new InvalidSizeException("Rows size in 2-d array cannot be negative");
        }
        System.out.println("Enter number of columns");
        cols = scanner.nextInt();
        if (cols < 0) {
          scanner.close();
          throw new InvalidSizeException("Columns size in 2-d array cannot be negative");
        }

        arr = new Double[rows][cols];

        System.out.println("Enter elements of two-dimensional array");

        for (int i = 0; i < rows; i++) {
          for (int j = 0; j < cols; j++) {
            arr[i][j] = scanner.nextDouble();
          }
        }
      } else if (args.length == 2) {
        rows = Integer.parseInt(args[0]);
        if (rows < 0) {
          scanner.close();
          throw new InvalidSizeException("Rows size in 2-d array cannot be negative");
        }
        cols = Integer.parseInt(args[1]);
        if (cols < 0) {
          scanner.close();
          throw new InvalidSizeException("Columns size in 2-d array cannot be negative");
        }

        arr = new Double[rows][cols];
        System.out.println("Enter elements of two-dimensional array");

        for (int i = 0; i < rows; i++) {
          for (int j = 0; j < cols; j++) {
            arr[i][j] = scanner.nextDouble();
          }
        }
      } else {
        rows = Integer.parseInt(args[0]);
        if (rows < 0) {
          scanner.close();
          throw new InvalidSizeException("Rows size in 2-d array cannot be negative");
        }

        cols = Integer.parseInt(args[1]);
        if (cols < 0) {
          scanner.close();
          throw new InvalidSizeException("Columns size in 2-d array cannot be negative");
        }

        arr = new Double[rows][cols];

        for (int i = 0; i < rows; i++) {
          for (int j = 0; j < cols; j++) {
            int index = i * (cols - 1) + j;
            if (index < args.length - 2) {
              arr[i][j] = Double.parseDouble(args[index + 2]);
            } else if (index == args.length - 2) {
              System.out.println("Enter the remaining elements of 2-d array");
              arr[i][j] = scanner.nextDouble();
            } else {
              arr[i][j] = scanner.nextDouble();
            }
          }
        }

      }
    } catch (NumberFormatException exc) {
      System.out.println(exc.getMessage());
    }

    TwoDimensionalArrays<Double> testObj = new TwoDimensionalArrays<>(arr, rows, cols);

    System.out.println(testObj.asMatrix());
    testObj.printSumRowColumnDiagonal();

    scanner.close();
  }

}
