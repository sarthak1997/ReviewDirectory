package com.epam.customcollection;

import java.util.Collection;
import java.util.Iterator;

import com.epam.exceptions.DuplicateEntryException;
import com.epam.exceptions.ElementNotFoundException;

/**
 * It's a set which implements the find operation in O(1) run time using hashing
 * concept.
 * */
public class HashSet<T> implements Set<T>, Iterable<T> {

  private final int defaultHashTableSize = 1024;

  /**
   * Array of linked list implemented as a hash table to handle collision also.
   * */
  LinkedListNode<T>[] hashTable;

  public HashSet() {
    hashTable = new LinkedListNode[defaultHashTableSize];
  }

  public HashSet(Collection<T> init) throws DuplicateEntryException {
    this();
    for(T element : init) {
      this.add(element);
    }
  }
  
  private int hashCode(T object) {
    return (object.hashCode() & (defaultHashTableSize - 1));
  }


  public void add(T object) throws DuplicateEntryException {
    int hash = this.hashCode(object);

    if (hashTable[hash] == null) {
      LinkedListNode<T> temp = new LinkedListNode<>(object, null);
      hashTable[hash] = temp;
    } else {
      LinkedListNode<T> iterator = hashTable[hash];
      if (iterator.getElement().equals(object)) {
        throw new DuplicateEntryException("DuplicateEntryException : Duplicate elements not allowed in set!");
      } else {
        while (iterator.getNext() != null) {
          iterator = iterator.getNext();
          if (iterator.getElement().equals(object)) {
            throw new DuplicateEntryException("DuplicateEntryException : Duplicate elements not allowed in set!");
          }
        }
        LinkedListNode<T> temp = new LinkedListNode<>(object, null);
        iterator.setNext(temp);
      }
    }
  }

  public void remove(T object) throws ElementNotFoundException {
    int hash = this.hashCode(object);

    if (hashTable[hash] == null)
      throw new ElementNotFoundException("ElementNotFoundException : Element not found in set to remove.");
    else {
      LinkedListNode<T> iterator = hashTable[hash];

      if (iterator.getElement().equals(object)) {
        hashTable[hash] = iterator.getNext();
        iterator.setElement(null);
        iterator.setNext(null);
      } else {
        while (iterator.getNext() != null) {
          if (iterator.getNext().getElement().equals(object)) {
            iterator.setNext(iterator.getNext().getNext());
            iterator.getNext().setElement(null);
            iterator.getNext().setNext(null);
            return;
          }
          iterator = iterator.getNext();
        }

        throw new ElementNotFoundException("ElementNotFoundException : Element not found in set to remove.");
      }
    }
  }

  /**
   * update method for updating an old object element with the new object.
   */
  public void update(T oldObject, T newObject) throws ElementNotFoundException, DuplicateEntryException {

    try {
      this.remove(oldObject);
      this.add(newObject);
    } catch (ElementNotFoundException exc) {
      throw new ElementNotFoundException("ElementNotFoundException : Element not found in set to update.");
    } catch (DuplicateEntryException exc) {
      throw new DuplicateEntryException("DuplicateEntryException : Already present element that you want to update!");
    }

  }

  public boolean find(T object) {
    int hash = this.hashCode(object);

    if (hashTable[hash] == null)
      return false;
    else {
      LinkedListNode<T> iterator = hashTable[hash];
      if (iterator.getElement().equals(object))
        return true;
      while (iterator.getNext() != null) {
        iterator = iterator.getNext();
        if (iterator.getElement().equals(object))
          return true;
      }
    }
    return false;
  }

  public Iterator<T> iterator() {
    return new HashSetIterator<T>(hashTable);
  }

}
