package com.maksymchuk.cce.arraysstrings;

import java.util.ArrayList;
import java.util.List;

public class HashTable {
	List<Tuple<String, String>>[] arr = new ArrayList[1000];
	
	public void add(String key, String value)
	{
		
		int arrIndex = index(key);
		if (arr[arrIndex] == null)
		{
			List<Tuple<String,String>> list = new ArrayList<Tuple<String,String>>();
			arr[arrIndex] = list;
			list.add(new Tuple<String, String>(key,value));
		}
		else
		{
			arr[arrIndex].add(new Tuple<String, String>(key,value));
		}
	}
	
	private int index(String key)
	{
		int hash = key.hashCode();
		int arrIndex = hash % arr.length;
		return arrIndex;
	}
	
	public String retrieve(String key)
	{
		int arrIndex = index(key);
		List<Tuple<String,String>> list = arr[arrIndex];
		if (list != null)
		{
			Tuple<String, String> tuple = list.stream().filter(t -> key.equals(t.first())).findFirst().orElse(null);
			return tuple.second();
		}
		return null;
	}
}
