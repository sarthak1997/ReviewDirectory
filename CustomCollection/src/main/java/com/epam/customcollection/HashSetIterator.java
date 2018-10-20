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
    while (currentIndex < hashTable.length) {
      if (tempIterator == null) {
        currentIndex++;
        if(currentIndex < hashTable.length) {
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
    if (tempIterator.getNext() == null) {
      currentIndex++;
      tempIterator = hashTable[currentIndex];
    }
    else {
      tempIterator = tempIterator.getNext();
    }
      return result;
  }

}
