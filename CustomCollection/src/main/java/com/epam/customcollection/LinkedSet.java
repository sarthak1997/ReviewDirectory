package com.epam.customcollection;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

import com.epam.exceptions.DuplicateEntryException;
import com.epam.exceptions.ElementNotFoundException;
import com.epam.exceptions.NullNotAllowedException;

//Custom LinkedSet Collection with generic nature
//User need to override it's equals and compare method of Comparator<Object> in case of custom object
public class LinkedSet<T> implements Set<T>, Iterable<T> {

  // node as in linked list with an element and next reference
  LinkedListNode<T> node;
  private int size = 0;
  // head to refer the start of the linked list
  private LinkedListNode<T> head;

  public LinkedSet() {
    head = null;
  }

  // overloaded constructor to initialize with the collection
  public LinkedSet(Collection<T> init) throws DuplicateEntryException {
    for (T element : init)
      this.add(element);
  }

  // to add at the end of the set
  public void add(T element) throws DuplicateEntryException {

    if (null == element) {
      throw new NullNotAllowedException("Null value in the set is not allowed");
    }

    if (0 == size) {
      node = new LinkedListNode<T>(element, null);
      head = node;
      size++;
    } else {
      if (this.contains(element)) {
        throw new DuplicateEntryException("DuplicateEntryException : Duplicate entries are not allowed in set");
      } else {
        node = new LinkedListNode<T>(element, null);
        LinkedListNode<T> temp = head;

        while (null != temp.getNext()) {
          temp = temp.getNext();
        }

        temp.setNext(node);

        size++;
      }
    }
  }

  // to remove a particular element in linked set
  public void remove(T element) throws ElementNotFoundException {

    if (null == element) {
      throw new NullNotAllowedException("Null value in the set is not present");
    }

    LinkedListNode<T> temp = head;

    if (temp.getElement().equals(element)) {
      head = temp.getNext();
      temp.setNext(null);
      temp.setElement(null);
      temp = null;
      return;
    }

    while (null != temp) {
      if (null != temp.getNext() && temp.getNext().getElement().equals(element)) {
        // remove
        LinkedListNode<T> removeElementNext = temp.getNext().getNext();
        temp.getNext().setNext(null);
        temp.getNext().setElement(null);
        temp.setNext(removeElementNext);
        size--;
        return;
      }
      temp = temp.getNext();
    }

    throw new ElementNotFoundException("ElementNotFoundException : Not Found!");
  }

  // to update at particular index in set
  public void update(int index, T element) throws DuplicateEntryException {
    if (null == element) {
      throw new NullNotAllowedException("Null value in the set is not allowed");
    }

    if (this.contains(element)) {
      throw new DuplicateEntryException("DuplicateEntryException : Duplicate entry not allowed in set");
    } else {
      int tempIndex = 0;
      LinkedListNode<T> temp = head;

      while (size > tempIndex) {
        if (tempIndex == index)
          break;

        tempIndex++;
        temp = temp.getNext();
      }

      if (size <= tempIndex)
        throw new IndexOutOfBoundsException("IndexOutOfBoundsException : Invalid index for update");
      else {
        temp.setElement(element);
        ;
      }
    }

  }

  // to find index of an element in set
  public int indexOf(T element) {
    if (null == element) {
      throw new NullNotAllowedException("Null value in the set is not present");
    }

    LinkedListNode<T> temp = head;
    int tempIndex = 0;

    while (size > tempIndex) {
      if (temp.getElement().equals(element))
        return tempIndex;
      else {
        tempIndex++;
        temp = temp.getNext();
      }
    }

    return -1;
  }

  // to get an element at a particular index
  public T get(int index) {
    if (0 > index || size <= index)
      throw new IndexOutOfBoundsException("IndexOutOfBoundsException : Invalid index");
    else {
      int tempIndex = 0;
      LinkedListNode<T> temp = head;

      while (size > tempIndex) {
        if (tempIndex == index)
          break;
        tempIndex++;
        temp = temp.getNext();
      }

      if (size <= tempIndex)
        return null;
      else
        return temp.getElement();
    }
  }

  // to find through any parameter in the custom object in set through lambda
  // expressions
  public LinkedSet<T> find(FindResolver<T> fr) {
    LinkedSet<T> resultSet = new LinkedSet<T>();
    LinkedListNode<T> temp = head;

    while (null != temp) {
      if (fr.resolve(temp.getElement())) {
        try {
          resultSet.add(temp.getElement());
        } catch (DuplicateEntryException e) {
          e.printStackTrace();
        }
      }
      temp = temp.getNext();
    }

    return resultSet;
  }

  @Override
  public String toString() {
    String result = "[-";

    LinkedListNode<T> temp = head;

    while (null != temp) {
      result += temp.getElement() + "-";
      temp = temp.getNext();
    }

    return result + "]";
  }

  // to sort using the comparator defined by the user
  public static void sort(LinkedSet<?> setObj, Comparator<Object> comp) {
    LinkedListNode<?> temp = setObj.head;
    LinkedListNode<?> temp2 = temp.getNext();

    while (null != temp.getNext()) {
      while (null != temp2) {
        if (0 < comp.compare((Object) temp.getElement(), (Object) temp2.getElement())) {
          setObj.swap(temp, temp2);
        }
        temp2 = temp2.getNext();
      }
      temp = temp.getNext();
      temp2 = temp.getNext();
    }
  }

  private void swap(LinkedListNode<?> temp, LinkedListNode<?> temp2) {

    Object tempElement = temp.getElement();
    temp.setElement(temp2.getElement());
    temp2.setElement(tempElement);
  }

  private boolean contains(T element2) {

    LinkedListNode<T> temp = head;
    int tempIndex = 0;

    while (size > tempIndex) {

      if (null != temp.getElement() && temp.getElement().equals(element2))
        return true;
      else {
        temp = temp.getNext();
        tempIndex++;
      }
    }

    return false;
  }

  public Iterator<T> iterator() {
    return new CustomLinkedSetIterator<T>(head);
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  @Override
  public void update(T oldObject, T newObject) throws ElementNotFoundException, DuplicateEntryException {

  }

}
