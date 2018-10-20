package com.epam.training.dailyhandson.quadratic;

import java.util.Scanner;

/**
 * this class is intended for containing operations regarding a quadratic equation.
 * */
public class Quadratic {

  private static final int DISCRMINANT_FACTOR = 4;
  private static double a;
  private static double b;
  private static double c;
  private static Scanner scanner;
  
  private static double[] sqroots(final double a, final double b, final double c) {
    if (a == 0) {
      return new double[0];
    }
    double discriminant = Math.pow(b,2) - DISCRMINANT_FACTOR * a * c;
    if (discriminant < 0) {
      return new double[0];
    } else if (discriminant == 0) {
      double[] result = new double[1];
      result[0] = b * (-1) / 2;
      return result;
    } else {
      double[] result = new double[2];
      result[0] = ((b * (-1)) + discriminant) / 2;
      result[1] = ((b * (-1)) - discriminant) / 2;
      return result;
    }
  }
  
  /**
    * Driver method to find square roots of a quadratic equation of the form ax^2+bx+c.
    * If command arguments are not provided, scanner is used for the remaining inputs. 
    * @param args for command line arguments as {@code String[]}
    */
  public static void main(String[] args) {
    try {
      if (args.length < 3) {
        scanner = new Scanner(System.in);
        if (args.length == 0) {
          System.out.println("Enter the value of a - ");
          a = scanner.nextDouble();
          System.out.println("Enter the value of b - ");
          b = scanner.nextDouble();
          System.out.println("Enter the value of c - ");
          c = scanner.nextDouble();
        } else if (args.length == 1) {
          a = Double.parseDouble(args[0]);
          System.out.println("Enter the value of b - ");
          b = scanner.nextDouble();
          System.out.println("Enter the value of c - ");
          c = scanner.nextDouble();
        } else {
          a = Double.parseDouble(args[0]);
          b = Double.parseDouble(args[1]);
          System.out.println("Enter the value of c - ");
          c = scanner.nextDouble();
        }
      } else {
        a = Double.parseDouble(args[0]);
        b = Double.parseDouble(args[1]);
        c = Double.parseDouble(args[2]);
      }
    } catch (NumberFormatException exc) {
      System.out.println("Please enter valid arguments");
      return;
    }
    
    double[] result = sqroots(a, b, c);
    System.out.print("The root(s) : ");
    for (double root : result) {
      System.out.print(root + " ");
    }
    
  }
}
