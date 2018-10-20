package com.epam.training.solidimplementation.units.converter;

public class InchToFeetConverter implements UnitConverter {

  Double value;
  final Double inchToFeetFactor = 0.0834;

  public InchToFeetConverter() {
    value = 0d;
  }

  public InchToFeetConverter(Double value) {
    super();
    this.value = value;
  }

  public Double convert() {
    return value * inchToFeetFactor;
  }

}
