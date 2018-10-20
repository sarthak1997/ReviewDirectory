package com.epam.training.factorypattern.shapeexample;

//concrete class
public class Circle implements Shape {

  public void draw() {
    System.out.println("Drawing Circle");
  }

  public Shape createShape() {
    return new Circle();
  }

}
