package com.epam.customcollection;

import java.util.ArrayList;
import java.util.List;

import com.epam.customcollection.test.Student;
import com.epam.exceptions.DuplicateEntryException;
import com.epam.exceptions.ElementNotFoundException;

public class HashSetTestApplication {

  public static void main(String[] args) throws DuplicateEntryException, ElementNotFoundException {

    HashSet<Student> testObj = new HashSet<>();
    
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
    testObj.add(s7);
    
    //test for remove
    testObj.remove(s4);
    
    //test for update
    testObj.update(s3, new Student(55,"Noob"));
    
  //test for Iterable
    for(Student s : testObj)
      System.out.println(s);
    
    System.out.println(testObj.find(s6) + " " + testObj.find(s4));
    
  //test for overloaded constructor
    List<Integer> testList=new ArrayList<>();
    
    testList.add(1);
    testList.add(2);
    testList.add(3);
    testList.add(4);
    testList.add(5);
    
    Set<Integer> testObj1=new HashSet<>(testList);
    
    for(Integer s : testObj1) {
      System.out.println(s);
    }


    
  }

}
