package com.epam.customcollection.graph;

import java.util.ArrayList;
import java.util.HashMap;

import com.epam.exceptions.ElementNotFoundException;
import com.epam.exceptions.NullNotAllowedException;

public class UndirectedWeightedGraph<E> implements Graph<E> {

  ArrayList<HashMap<Integer, Integer>> adjList;
  HashMap<E, Integer> nodeMap;
  int currentIndex;
  private final int defaultWeight;

  public UndirectedWeightedGraph() {
    adjList = new ArrayList<>();
    nodeMap = new HashMap<>();
    currentIndex = 0;
    defaultWeight = 0;
  }

  @Override
  public boolean add(E element) {

    if (null == element) {
      throw new NullNotAllowedException("Null elements not allowed in graph");
    }

    if (nodeMap.containsKey(element)) {
      return false;
    }
    nodeMap.put(element, currentIndex);
    adjList.add(new HashMap<>());
    currentIndex += 1;

    return true;
  }

  @Override
  public boolean addEdge(E element1, E element2) throws ElementNotFoundException {

    if (null == element1 || null == element2) {
      throw new NullNotAllowedException("Null elements not present in graph");
    }

    Integer index1 = nodeMap.get(element1);
    Integer index2 = nodeMap.get(element2);

    if (null == index1 || null == index2) {
      throw new ElementNotFoundException("Elements not present in graph");
    }

    if (adjList.get(index1).containsKey(index2)) {
      return false;
    }

    adjList.get(index1).put(index2, defaultWeight);
    adjList.get(index2).put(index1, defaultWeight);

    return true;
  }

  @Override
  public void remove(E element) throws ElementNotFoundException {
    if (null == element) {
      throw new NullNotAllowedException("Null elements not present in graph");
    }

    Integer index = nodeMap.get(element);

    if (null == index) {
      throw new ElementNotFoundException("Elements not present in graph");
    }

    HashMap<Integer, Integer> temp = adjList.get(index);

    for (Integer tempIndex : temp.keySet()) {
      adjList.get(tempIndex).remove(index);
    }

    adjList.remove(adjList.get(index));
    currentIndex -= 1;
  }

  @Override
  public boolean removeEdge(E element1, E element2) throws ElementNotFoundException {
    if (null == element1 || null == element2) {
      throw new NullNotAllowedException("Null elements not present in graph");
    }

    Integer index1 = nodeMap.get(element1);
    Integer index2 = nodeMap.get(element2);

    if (null == index1 || null == index2) {
      throw new ElementNotFoundException("Elements not present in graph");
    }

    if (!adjList.get(index1).containsKey(index2)) {
      return false;
    }

    adjList.get(index1).remove(index2);
    adjList.get(index2).remove(index1);

    return true;
  }

  public void updateWeight(E element1, E element2, int weight) throws ElementNotFoundException {
    if (null == element1 || null == element2) {
      throw new NullNotAllowedException("Null elements not present in graph");
    }

    Integer index1 = nodeMap.get(element1);
    Integer index2 = nodeMap.get(element2);

    if (null == index1 || null == index2) {
      throw new ElementNotFoundException("Elements not present in graph");
    }

    adjList.get(index1).put(index2, weight);
    adjList.get(index2).put(index1, weight);
  }

}
