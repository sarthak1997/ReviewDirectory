package com.epam.training.solidimplementation.units.converter;

public class FeetToMeterConverter implements UnitConverter {

  Double value;
  final Double feetToMeterFactor = 0.3;

  public FeetToMeterConverter() {
    value = 0d;
  }

  public FeetToMeterConverter(Double value) {
    super();
    this.value = value;
  }

  public Double convert() {
    return value * feetToMeterFactor;
  }

}
