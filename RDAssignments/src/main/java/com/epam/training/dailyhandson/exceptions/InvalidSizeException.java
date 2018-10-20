package com.epam.training.dailyhandson.exceptions;

/**
 * It is raised when the size of an array provided in invalid.
 * */
public class InvalidSizeException extends Exception {

  private static final long serialVersionUID = 1L;

  public InvalidSizeException(String message) {
    super(message);
  }
  
}
