
package com.epam.training.dailyhandson.array;

/**
 * This class contains all the basic operations with respect to a 1-d array of {@code Number} type.
 */
public class Array<T extends Number> {

  private int size;
  private T[] arr;

  public Array(T[] arr) {
    this.arr = arr;
    this.size = arr.length;
  }

  /**
   * Method to find sum of the array.
   *
   * @return {@code T} type value as a result
   */
  public T sum() {
    Number sum = 0;
    for (int i = 0; i < size; i++) {
      sum = this.add(sum,arr[i]);
    }
    return (T)sum;
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

  /**
   * Method to find average of values in array.
   *
   * @return {@code T} type value as a result
   */
  public T avg() {
    return (T)this.divide(this.sum(),size);
  }

  private Number divide(T number1, Number number2) {
    if (number1 instanceof Integer) {
      return number1.intValue() / number2.intValue();
    } else if (number1 instanceof Float) {
      return number1.floatValue() / number2.floatValue();
    } else if (number1 instanceof Double) {
      return number1.doubleValue() / number2.doubleValue();
    } else if (number1 instanceof Long) {
      return number1.longValue() / number2.longValue();
    } else if (number1 instanceof Short) {
      return number1.shortValue() / number2.shortValue();
    } else {
      return number1.byteValue() / number2.byteValue();
    }
  }

  /**
   * Normalizes the values present in the array just like a vector normalization,
   * such that magnitude of the result is 1.
   */
  public void norm() {
    T sum = this.sum();
    for (int i = 0; i < size; i++) {
      arr[i] = (T) this.divide(arr[i], sum);
    }
  }

  /**
   * method to join the elements of the array as a {@code String} with a default
   * separator ',' i.e comma.
   * 
   * @return {@code String} as a result
   */
  public String join() {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < size - 1; i++) {
      builder.append(arr[i] + ", ");
    }
    builder.append(arr[size - 1]);
    return builder.toString();
  }

  /**
   * overloaded method to join the elements of the array as a {@code String} with
   * a separator provided by the user.
   * 
   * @param separator which is used to separate array
   *        elements while joining
   * 
   * @return {@code String} as a result
   */
  public String join(final String separator) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < size - 1; i++) {
      builder.append(arr[i] + separator + " ");
    }
    builder.append(arr[size - 1]);
    return builder.toString();
  }

}
