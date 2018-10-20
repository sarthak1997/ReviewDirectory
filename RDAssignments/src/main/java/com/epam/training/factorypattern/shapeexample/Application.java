package com.epam.training.factorypattern.shapeexample;

import java.lang.reflect.InvocationTargetException;

/**
 * Driver class for testing of the implemented factory pattern through shape example.
 * */
public class Application {

  static {
    ShapeFactoryWithoutReflection.getInstance().registerShape("1", new Circle());
    ShapeFactoryWithoutReflection.getInstance().registerShape("2", new Rectangle());
    ShapeFactoryWithoutReflection.getInstance().registerShape("3", new Square());

    ShapeFactoryWithReflection.getInstance().registerShape("1", Circle.class);
    ShapeFactoryWithReflection.getInstance().registerShape("2", Rectangle.class);
    ShapeFactoryWithReflection.getInstance().registerShape("3", Square.class);
  }

  /**
   * Driver method to test the product example
   * implementation of factory pattern.
   * */
  public static void main(String[] args) throws NoSuchMethodException,
      SecurityException, InstantiationException,
      IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Shape s = ShapeFactoryWithoutReflection.getInstance().createShape("1");
    s.draw();
    s = ShapeFactoryWithoutReflection.getInstance().createShape("2");
    s.draw();
    s = ShapeFactoryWithoutReflection.getInstance().createShape("3");
    s.draw();

    s = ShapeFactoryWithReflection.getInstance().createShape("1");
    s.draw();
    s = ShapeFactoryWithReflection.getInstance().createShape("2");
    s.draw();
    s = ShapeFactoryWithReflection.getInstance().createShape("3");
    s.draw();
  }

}
