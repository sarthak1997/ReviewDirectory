package com.epam.training.solidimplementation.units.converter;

public class MeterToInchConverter implements UnitConverter {

  Double value;
  final Double meterToInchFactor = 39.37;

  public MeterToInchConverter() {
    value = 0d;
  }

  public MeterToInchConverter(Double value) {
    super();
    this.value = value;
  }

  public Double convert() {
    return value * meterToInchFactor;
  }

}
