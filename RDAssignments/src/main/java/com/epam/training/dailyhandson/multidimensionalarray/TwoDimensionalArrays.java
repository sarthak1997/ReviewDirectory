package com.epam.training.dailyhandson.multidimensionalarray;

import com.epam.training.dailyhandson.exceptions.AsymmetricMatrixException;

/**
 * This class contains all the basic operations with respect to a 2-d array of
 * {@code Number} type.
 */
public class TwoDimensionalArrays<T extends Number> {

  private int rows;
  private int cols;
  private T[][] multiArray;

  /**
   * parameterized constructor to initialize the data members of instance.
   * 
   * @param multiArray
   *          - the two dimensional array
   * @param rows
   *          as number of rows of the matrix
   * @param cols
   *          as number of columns of the matrix
   */
  public TwoDimensionalArrays(T[][] multiArray, int rows, int cols) {
    this.multiArray = multiArray;
    this.rows = rows;
    this.cols = cols;
  }

  /**
   * method to generate a string that while printing shows the result as matrix.
   * 
   * @return {@code String} as a result
   */
  public String asMatrix() {
    StringBuilder result = new StringBuilder();
    for (int i = 0; rows > i; i++) {
      for (int j = 0; cols > j; j++) {
        result.append(String.format("%.1f", multiArray[i][j]) + " ");
      }
      result.append("\n");
    }
    return result.toString();
  }

  /**
   * method that prints the sum of rows, columns and diagonals elements in the
   * array such that rows and columns are equal.
   * 
   * @throws AsymmetricMatrixException
   *           in case of asymmetric matrix
   */
  public void printSumRowColumnDiagonal() throws AsymmetricMatrixException {

    if (rows != cols) {
      throw new AsymmetricMatrixException("Rows and Columns should be equal for this operation.");
    }

    Number[] colSums = new Number[cols];
    Number diagonalSum = 0;
    for (int i = 0; rows > i; i++) {
      Number rowSum = 0;
      Number colSum = 0;
      for (int j = 0; cols > j; j++) {
        rowSum = this.add(rowSum, multiArray[i][j]);
        colSum = this.add(colSum, multiArray[j][i]);
        if (i == j) {
          diagonalSum = this.add(diagonalSum, multiArray[i][i]);
        }
        System.out.print(multiArray[i][j] + " ");
      }
      System.out.println("| " + String.format("%.1f", rowSum));
      colSums[i] = colSum;
    }
    for (int i = 0; rows > i; i++) {
      System.out.print("--");
    }
    System.out.println("/");
    for (int i = 0; rows > i; i++) {
      System.out.print(String.format("%.1f", colSums[i]) + " ");
    }
    System.out.println("  " + String.format("%.1f", diagonalSum));
  }

  private Number add(Number sum, T number) {

    if (number instanceof Integer) {
      return sum.intValue() + number.intValue();
    } else if (number instanceof Float) {
      return sum.floatValue() + number.floatValue();
    } else if (number instanceof Double) {
      return sum.doubleValue() + number.doubleValue();
    } else if (number instanceof Long) {
      return sum.longValue() + number.longValue();
    } else if (number instanceof Short) {
      return sum.shortValue() + number.shortValue();
    } else {
      return sum.byteValue() + number.byteValue();
    }
  }

}
