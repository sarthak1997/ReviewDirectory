package com.epam.customcollection;

import java.util.Iterator;

public class CustomArraySetIterator<E> implements Iterator<E> {

  Object[] listObj;
  int currentIndex;
  int size;

  public CustomArraySetIterator(Object[] listObj, int size) {
    this.listObj = listObj;
    currentIndex = 0;
    this.size = size;
  }

  public boolean hasNext() {

    if (currentIndex < size && listObj[currentIndex] != null) {
      return true;
    }

    return false;
  }

  public E next() {

    @SuppressWarnings("unchecked")
    E result = (E) listObj[currentIndex];
    currentIndex = currentIndex + 1;

    return result;
  }

}
