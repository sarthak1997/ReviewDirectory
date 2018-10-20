package com.epam.training.solidimplementation.units.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Dedicated inputter class for the inputs required for unit converter.
 * */
public class UnitConverterInputter {

  String input;
  BufferedReader reader;
  StringTokenizer st;

  public UnitConverterInputter() {
    input = "";
    reader = new BufferedReader(new InputStreamReader(System.in));
  }

  public char readConsoleChar() throws IOException {
    return reader.readLine().charAt(0);
  }

  /**
   * It is to read Double input from console.
   * @return {@code Double} value inputted by the user
   * */
  public Double readConsoleDouble() throws IOException {

    st = new StringTokenizer(reader.readLine());

    return Double.parseDouble(st.nextToken());
  }

}
