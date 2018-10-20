package com.epam.training.solidimplementation.units.converter;

public class FeetToInchConverter implements UnitConverter {

  Double value;
  final Double feetToInchFactor = 12d;

  public FeetToInchConverter() {
    value = 0d;
  }

  public FeetToInchConverter(Double value) {
    super();
    this.value = value;
  }

  public Double convert() {
    return value * feetToInchFactor;
  }

}
