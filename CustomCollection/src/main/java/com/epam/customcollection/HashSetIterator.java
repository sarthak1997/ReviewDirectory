package com.epam.customcollection;

import java.util.Iterator;

public class HashSetIterator<E> implements Iterator<E> {

  private LinkedListNode<E>[] hashTable;
  private int currentIndex;
  private LinkedListNode<E> tempIterator;

  public HashSetIterator(LinkedListNode<E>[] hashTable) {
    this.hashTable = hashTable;
    currentIndex = 0;
    tempIterator = hashTable[currentIndex];
  }

  public boolean hasNext() {
    while (hashTable.length > currentIndex) {
      if (null == tempIterator) {
        currentIndex++;
        if (hashTable.length > currentIndex) {
          tempIterator = hashTable[currentIndex];
        } else {
          return false;
        }
      } else {
        return true;
      }
    }
    return false;
  }

  public E next() {

    E result = tempIterator.getElement();
    if (null == tempIterator.getNext()) {
      currentIndex++;
      tempIterator = hashTable[currentIndex];
    } else {
      tempIterator = tempIterator.getNext();
    }
    return result;
  }

}
