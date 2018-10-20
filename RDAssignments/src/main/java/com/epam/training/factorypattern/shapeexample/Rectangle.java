package com.epam.training.factorypattern.shapeexample;

//concrete class
public class Rectangle implements Shape {

  public void draw() {
    System.out.println("Drawing Rectangle");
  }

  public Shape createShape() {
    return new Rectangle();
  }

}
