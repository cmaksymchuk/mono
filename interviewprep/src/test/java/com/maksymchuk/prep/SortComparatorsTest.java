package com.maksymchuk.prep;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.maksymchuk.prep.SortComparators.Employee;

class SortComparatorsTest {
	SortComparators sc = new SortComparators();
	@Test
	void test() {
		SortComparators.Employee e1 = new SortComparators.Employee("bill", 10);
		SortComparators.Employee e2 = new SortComparators.Employee("sam", 44);
		SortComparators.Employee e3 = new SortComparators.Employee("jim", 30);
		

		List<SortComparators.Employee> l = new ArrayList<SortComparators.Employee>();
		l.add(e1);
		l.add(e2);
		l.add(e3);
		
		// comparators
		Comparator<Employee> compareByAge = (Employee o1, Employee o2) ->
			o1.getAge() - o2.getAge();
		

		Comparator<Employee> compareByName = (Employee o1, Employee o2) ->
			o1.getName().compareTo(o2.getName());
	

		
		// initial list
		System.out.println(l.toString());
				
		
		// compare by age sort
		Collections.sort(l, compareByAge);
		System.out.println(l.toString());

		// compare by name sort
		Collections.sort(l, compareByName);
		System.out.println(l.toString());
	}
}
