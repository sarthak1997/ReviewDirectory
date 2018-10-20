package com.epam.customcollection;

import java.util.ArrayList;
import java.util.List;

import com.epam.customcollection.test.Student;
import com.epam.exceptions.DuplicateEntryException;
import com.epam.exceptions.ElementNotFoundException;

/**Driver class.*/
public final class ArraySetTestApplication {

    /**Utility class constructor.*/
    private ArraySetTestApplication() { }

  /**
   * @param args are the {@code String[]} i.e command line arguments
   * @throws SetElementNotFoundException in case element not found in set
   * @throws DuplicateEntryException in case of adding duplicate
   */
  public static void main(String[] args) throws DuplicateEntryException,
  ElementNotFoundException
	{
		ArraySet<Student> testObj=new ArraySet<>();
		
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
		
		//test for remove with index
		testObj.remove(2);
		
		//test for remove with element
		testObj.remove(s4);
		
		//test for indexOf
		int index= testObj.indexOf(s5);
		System.out.println(index);
		System.out.println();
		
		//test for update
		testObj.update(2, new Student(5,"Grey"));
		
		//test for Iterable
		for(Student s : testObj)
			System.out.println((Student)s);
		
		System.out.println();
		
		//test for find with lambda expressions
		ArraySet<Student> resultSet=testObj.find((Student temp) -> temp.getName().equals("John"));
		
		for(Student result : resultSet)
		{
			System.out.println(result);
		}		
		System.out.println();
		
		//test for sorting using user defined comparator
		ArraySet.sort(testObj,s1);

		//test for adding after sorting
		testObj.add(new Student(85,"Sarthak"));
		
		//test for toString
		System.out.println(testObj);
		System.out.println();
		
		//test for overloaded constructor
		List<Integer> testList=new ArrayList<>();
		
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
		
		Set<Integer> testObj1=new ArraySet<>(testList);
		
		System.out.println(testObj1);
	}
	
}
