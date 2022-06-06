package com.maksymchuk.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class SecretSantaNoFamily {
	
	class Person
	{
		int familyKey = 0;
		String name;
		public Person(int familyKey, String name)
		{
			this.familyKey = familyKey;
			this.name = name;
		}
		public String toString() 
		{
			return name;
		}
	}

	Map<String, String> secretSantas = new HashMap<String, String>();
	List<Person> personPool = new ArrayList<Person>();
	
	Set<Person> received = new HashSet<Person>();
	
	
	Random rand = new Random();
	
	public SecretSantaNoFamily(List<List<String>> nameLists)
	{
		int familyKey = 0;
		for (List<String> nameList : nameLists)
		{
			for (String name: nameList)
			{
				Person p = new Person(familyKey, name);
				personPool.add(p);
			}
			familyKey++;

		}
		
		for (Person p : personPool)
		{
			secretSantas.put(p.name, this.getSecretSantaFor(p));
		}
	}
	
	public String getSecretSantaFor(Person p)
	{
		List<Person> poolWithoutFamilyOrTaken = personPool.stream().filter(person -> 
			person.familyKey != p.familyKey && !secretSantas.containsValue(person.name))		
			.collect(Collectors.toList());
		int randomIndex = rand.nextInt(poolWithoutFamilyOrTaken.size());
		return poolWithoutFamilyOrTaken.get(randomIndex).name;
	}
}
