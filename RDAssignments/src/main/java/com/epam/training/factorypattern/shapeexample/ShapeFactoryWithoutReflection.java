package com.epam.training.factorypattern.shapeexample;

import java.util.HashMap;

//Factory class
public class ShapeFactoryWithoutReflection {

  private static ShapeFactoryWithoutReflection instance = new ShapeFactoryWithoutReflection();
  private HashMap<String, Shape> registeredShapes;

  private ShapeFactoryWithoutReflection() {
    registeredShapes = new HashMap<String, Shape>();
  }

  public static ShapeFactoryWithoutReflection getInstance() {
    return instance;
  }

  public void registerShape(String id, Shape s) {
    registeredShapes.put(id, s);
  }

  public Shape createShape(String id) {
    return registeredShapes.get(id).createShape();
  }
}
