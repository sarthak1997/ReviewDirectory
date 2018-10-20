package com.epam.training.solidimplementation.units.io;

/**
 * Dedicated outputter class for the different outputs depending upon the requirement.
 * */
public class UnitConverterOutputter {

  String result;

  public UnitConverterOutputter() {
    result = "--No Output--";
  }

  public UnitConverterOutputter(String result) {
    super();
    this.result = result;
  }

  public String outConsole() {
    return result;
  }

  public String outHtml() {
    // Customize result by appending HTML code around it
    return result;
  }

  public String outJson() {
    // Customize result by adding result to fields of your JSON
    return result;
  }
}
