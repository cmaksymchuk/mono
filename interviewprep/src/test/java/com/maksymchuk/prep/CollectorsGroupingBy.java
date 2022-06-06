package com.maksymchuk.prep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://www.baeldung.com/java-groupingby-collector
 *
 */
public class CollectorsGroupingBy {
	public static class Student {
	    public Student(String subject, String name, String surname, String city, int age) {
			super();
			this.subject = subject;
			this.name = name;
			this.surname = surname;
			this.city = city;
			this.age = age;
		}
		String subject;
	    String name;
	    String surname;
	    String city;
	    int age;
		public String getSubject() {
			return subject;
		}
		public String getName() {
			return name;
		}
		public String getSurname() {
			return surname;
		}
		public String getCity() {
			return city;
		}
		public int getAge() {
			return age;
		}

	   // Constructors, Getters, Setters, toString()
	}
	
	public static void main(String[] args) {
		
		List<Student> students = Arrays.asList(
			    new Student("Math", "John", "Smith", "Miami", 19),
			    new Student("Programming", "Mike", "Miles", "New York", 21),
			    new Student("Math", "Michael", "Peterson", "New York", 20),
			    new Student("Math", "James", "Robertson", "Miami", 20),
			    new Student("Programming", "Kyle", "Miller", "Miami", 20)
			);
		
		Map<String, List<Student>> studentsBySubject = students
			    .stream()
			    .collect(
			        Collectors.groupingBy(Student::getSubject)
			    );
		
		System.out.println(studentsBySubject);
		
		
		// String to a list of strings
		List<String> stringList = Arrays.asList("Cory","Emma","Ava","Allison");
		Map<Integer, List<String>> gb = stringList.stream().collect(Collectors.groupingBy(String::length));
		for (java.util.Map.Entry<Integer, List<String>> entry : gb.entrySet())
		{
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		
		stringList.sort(Comparator.comparingInt(String::length));		
	}
}
