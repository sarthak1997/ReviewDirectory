package com.epam.customcollection;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

import com.epam.exceptions.DuplicateEntryException;
import com.epam.exceptions.ElementNotFoundException;

//Custom Set Collection with generic nature
//User need to override it's equals and compare method of Comparator<Object> in case of custom object
//It uses a dynamic array by default size of 10 such that when it reaches it's capacity the capacity gets doubled and when the size reaches half if the capacity it shrinks down to half the size
public class ArraySet<T> implements Set<T>, Iterable<T> {

  private final int defaultCapacity = 10;

  // Main Dynamic Array
  private Object[] listObj;
  // Temporary array for grow and shrink of the main array
  private Object[] tempArr;
  private int capacity = defaultCapacity;
  private int size;

  // default initialization
  public ArraySet() {
    listObj = new Object[defaultCapacity];
    size = 0;
  }

  // initialization of set with a particular size
  public ArraySet(int capacity) {
    this();
    this.capacity = capacity;
    size = 0;
  }

  // initialization with a pre-built collection
  public ArraySet(Collection<T> init) throws DuplicateEntryException {
    this(init.size());

    for (T var : init) {
      this.add(var);
    }
  }

  // to get element present at an index in the set
  @SuppressWarnings("unchecked")
  public T get(int index) throws IndexOutOfBoundsException {

    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("SetIndexOutOfBoundException : Invalid Index - " + index);
    T result = (T) listObj[index];
    return result;
  }

  // to add element in the set
  public void add(T element) throws DuplicateEntryException {
    if (this.contains(element)) {

      throw new DuplicateEntryException("DuplicateEntryException : Duplicate elements are not allowed!");
    }

    if (size == capacity) {
      tempArr = new Object[2 * capacity];
      for (int i = 0; i < size; i++)
        tempArr[i] = listObj[i];
      listObj = null;
      listObj = tempArr;
      capacity = 2 * capacity;
    }

    listObj[size] = element;
    size += 1;
  }

  // to update at particular index
  public void update(int index, T element) throws DuplicateEntryException {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("SetIndexOutOfBoundException : Invalid Index - " + index);

    if (this.contains(element))
      throw new DuplicateEntryException("DuplicateEntryException : Duplicate elements are not allowed!");

    listObj[index] = element;
  }

  // to remove at particular index
  public void remove(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("SetIndexOutOfBoundException : Invalid Index - " + index);

    for (int i = index; i < size - 1; i++) {
      listObj[i] = listObj[i + 1];
    }
    size = size - 1;

    if (size < (capacity / 2)) {
      tempArr = new Object[capacity / 2];
      for (int i = 0; i < size; i++)
        tempArr[i] = listObj[i];
      listObj = null;
      listObj = tempArr;
      capacity = capacity / 2;
    }

  }

  // to remove a particular element.
  public void remove(T element) throws ElementNotFoundException {
    if (this.contains(element)) {
      for (int i = 0; i < size; i++) {
        if (listObj[i].equals(element)) {
          this.remove(i);
          return;
        }
      }
    } else
      throw new ElementNotFoundException("InvalidSetElementException : Element does not exists");
  }

  // to find index of a particular element
  public int indexOf(T element) {
    if (this.contains(element)) {
      for (int i = 0; i < size; i++) {
        if (listObj[i].equals(element)) {
          return i;
        }
      }
    }
    return -1;
  }

  // return true when an element is present in the set
  @SuppressWarnings("unchecked")
  private boolean contains(T element) {
    for (int i = 0; i < size; i++) {
      T tempVar = (T) listObj[i];

      if (tempVar.equals(element)) {
        return true;
      }
    }
    return false;
  }

  // to make it iterable
  public Iterator<T> iterator() {
    return new CustomArraySetIterator<T>(listObj, size);
  }

  // to find through nay parameter of the custom object using lambda expressions
  @SuppressWarnings("unchecked")
  public ArraySet<T> find(FindResolver<T> fr) {
    int resultIndex[] = new int[size];
    int resultSize = 0;

    for (int i = 0; i < size; i++) {
      if (fr.resolve((T) listObj[i])) {
        resultIndex[i] = i;
        resultSize = resultSize + 1;
      } else
        resultIndex[i] = -1;
    }

    ArraySet<T> resultSet = new ArraySet<>();
    
    for (int i = 0; i < size; i++) {
      if (resultIndex[i] != -1) {
         try {
         resultSet.add((T)listObj[resultIndex[i]]);
         } catch (DuplicateEntryException exc) {
           exc.printStackTrace();
         }
      }
    }
    return resultSet;
  }

  // static method to sort with the custom set object provided and the user
  // defined comparator
  // heap sort is used for sorting
  public static void sort(ArraySet<?> setObj, Comparator<Object> comp) {
    int tempSize = setObj.size;
    setObj.buildHeap(comp);
    Object temp[] = new Object[tempSize];
    for (int i = tempSize - 1; i >= 0; i--) {
      temp[i] = setObj.extractMax(comp);
    }

    for (int i = 0; i < tempSize; i++) {
      setObj.listObj[i] = temp[i];
    }

    setObj.setSize(tempSize);
  }

  // method for heap sort to reset size of the main array as during extract max
  // operation it decreases
  private void setSize(int tempSize) {
    this.size = tempSize;
  }

  // extractMax operation of Max-Heap
  private Object extractMax(Comparator<Object> comp) {
    Object result = listObj[0];
    this.swap(0, size - 1);
    size = size - 1;
    this.shiftDown(0, comp);
    return result;
  }

  // to build the heap by giving any array as an argument
  private void buildHeap(Comparator<Object> comp) {

    for (int i = (size / 2); i >= 0; i--) {
      this.shiftDown(i, comp);
    }

  }

  // method to organize the heap in case of any operation
  private void shiftDown(int index, Comparator<Object> comp) {

    int maxIndex = index;

    int left = this.leftChild(index);

    if (left < size && comp.compare(this.listObj[left], this.listObj[maxIndex]) > 0) {
      maxIndex = left;
    }

    int right = this.rightChild(index);

    if (right < size && comp.compare(this.listObj[right], this.listObj[maxIndex]) > 0) {
      maxIndex = right;
    }

    if (index != maxIndex) {
      this.swap(index, maxIndex);
      this.shiftDown(maxIndex, comp);
    }
  }

  // to get index of right child in the heap
  private int rightChild(int index) {
    return 2 * index + 2;
  }

  // to get index of left child in the heap
  private int leftChild(int index) {
    return 2 * index + 1;
  }

  // to swap two index objects
  private void swap(int index1, int index2) {

    Object temp = listObj[index1];
    listObj[index1] = listObj[index2];
    listObj[index2] = temp;
  }

  // toString to print content of the set
  @Override
  public String toString() {

    String result = "Set = [-";

    for (int i = 0; i < size; i++) {
      result += listObj[i] + "-";
    }
    result += "]";
    return result;
  }

  // to get current size of the set
  public int size() {
    return size;
  }

  public void update(T oldObject, T newObject) throws ElementNotFoundException, DuplicateEntryException {

    if (this.contains(newObject)) {
      throw new DuplicateEntryException("The new element you are putting for update is already present in the set!");
    }
    for (int i = 0; i < size; i++) {
      @SuppressWarnings("unchecked")
      T tempVar = (T) listObj[i];
      if (tempVar.equals(oldObject)) {
        listObj[i] = newObject;
        return;
      }
    }
  }

}
