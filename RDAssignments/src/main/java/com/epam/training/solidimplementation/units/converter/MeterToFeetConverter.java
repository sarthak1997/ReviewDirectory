package com.epam.training.solidimplementation.units.converter;

public class MeterToFeetConverter implements UnitConverter {

  Double value;
  final Double meterToFeetFactor = 3.28;

  public MeterToFeetConverter() {
    value = 0d;
  }

  public MeterToFeetConverter(Double value) {
    super();
    this.value = value;
  }

  public Double convert() {
    return value * meterToFeetFactor;
  }

}
