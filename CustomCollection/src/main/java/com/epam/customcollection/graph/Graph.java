package com.epam.customcollection.graph;

import com.epam.exceptions.ElementNotFoundException;

public interface Graph<E> {

  public boolean add(E element);

  public boolean addEdge(E element1, E element2) throws ElementNotFoundException;

  public void remove(E element) throws ElementNotFoundException;

  public boolean removeEdge(E element1, E element2) throws ElementNotFoundException;

}
