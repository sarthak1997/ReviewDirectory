package com.epam.training.dailyhandson.exceptions;

/**
 * It is raised when a square matrix is required and not provided.
 * */
public class AsymmetricMatrixException extends Exception {

  private static final long serialVersionUID = 1L;

  public AsymmetricMatrixException(String message) {
    super(message);
  }
  
}
