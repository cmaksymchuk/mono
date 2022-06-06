package com.maksymchuk.prep;

import java.util.Comparator;

public class SortComparators {
	
	public static class Employee {
		String name;
		int age;
		public String getName() {
			return name;
		}
		public int getAge() {
			return age;
		}
		public Employee(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
		public String toString()
		{
			return name + " (" + age + ")";
		}
	}

			
			
}
