package com.epam.training.factorypattern.shapeexample;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

//Factory class
public class ShapeFactoryWithReflection {

  private static ShapeFactoryWithReflection instance = new ShapeFactoryWithReflection();
  private HashMap<String, Class> registeredShapes;

  private ShapeFactoryWithReflection() {
    registeredShapes = new HashMap<String, Class>();
  }

  public static ShapeFactoryWithReflection getInstance() {
    return instance;
  }

  public void registerShape(String id, Class shapeClass) {
    registeredShapes.put(id, shapeClass);
  }

  /**
   * Factory method that instantiates the specified concrete class object through 
   * id given in the form of {@code String}.
   * */
  public Shape createShape(String id) throws NoSuchMethodException,
      SecurityException, InstantiationException,
      IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Class<?> shapeClass = registeredShapes.get(id);
    Constructor<?> constructor = shapeClass.getDeclaredConstructor(new Class[] {});
    return (Shape) constructor.newInstance(new Object[] {});
  }

}
