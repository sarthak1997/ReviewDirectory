package com.epam.training.solidimplementation.units.converter;

public class InchToMeterConverter implements UnitConverter {

  Double value;
  final Double inchToMeterFactor = 0.025;

  public InchToMeterConverter() {
    value = 0d;
  }

  public InchToMeterConverter(Double value) {
    super();
    this.value = value;
  }

  public Double convert() {
    return value * inchToMeterFactor;
  }

}
