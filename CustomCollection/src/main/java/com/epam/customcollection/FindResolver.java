package com.epam.customcollection;

//Functional Interface for lambda expression of find method in custom set
public interface FindResolver<E> {

  public boolean resolve(E listObj);

}
