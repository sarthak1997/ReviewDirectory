package com.epam.training.factorypattern.shapeexample;

//concrete class
public class Square implements Shape {

  public void draw() {
    System.out.println("Drawing Square");
  }

  public Shape createShape() {
    return new Square();
  }

}
