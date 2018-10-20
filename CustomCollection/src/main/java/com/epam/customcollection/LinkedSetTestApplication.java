package com.epam.customcollection;

import java.util.ArrayList;
import java.util.List;

import com.epam.customcollection.test.Student;
import com.epam.exceptions.DuplicateEntryException;
import com.epam.exceptions.ElementNotFoundException;

public class LinkedSetTestApplication {

  public static void main(String[] args) throws DuplicateEntryException, ElementNotFoundException {

    LinkedSet<Student> testObj = new LinkedSet<>();
    
    Student s1 = new Student(2, "John");
    Student s2 = new Student(1, "Doe");
    Student s3 = new Student(3, "Doe");
    Student s4 = new Student(6, "John");
    Student s5 = new Student(0, "John");
    Student s6 = new Student(8, "John");
    Student s7 = new Student(4, "John");
    
    //test for add
    testObj.add(s1);
    testObj.add(s2);
    testObj.add(s3);
    testObj.add(s4);
    testObj.add(s5);
    testObj.add(s6);
    testObj.add(null);
    
    //test for remove
    testObj.remove(s4);
    
    //test for update
    testObj.update(3, new Student(55,"Noob"));
    
  //test for Iterable
    for(Student s : testObj)
      System.out.println(s);
    
    System.out.println();
    
    //test for find with lambda expressions
    LinkedSet<Student> resultSet=testObj.find((Student temp) -> temp.getName().equals("John"));
    
    for(Student result : resultSet)
    {
      System.out.println(result);
    }   
    System.out.println();
    
    LinkedSet.sort(testObj, s6);
    
    //test for Iterable
    for(Student s : testObj)
      System.out.println(s);
    
  //test for overloaded constructor
    List<Integer> testList=new ArrayList<>();
    
    testList.add(1);
    testList.add(2);
    testList.add(3);
    testList.add(4);
    testList.add(5);
    
    Set<Integer> testObj1=new LinkedSet<>(testList);
    
    System.out.println(testObj1);
    
    
  }

}
