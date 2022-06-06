package com.maksymchuk.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
/**
 * https://github.com/volkodavs/secret-santa
 * @author cmaksym
 *
 */
public class SecretSanta {
	
	Map<String, String> secretSantas = new HashMap<String, String>();
	Random rand = new Random();
	Map<Integer, Map<String, String>> resultsMap = new HashMap<>();
	
	public SecretSanta(Set<String> names)
	{
		// if there are 4 people, we must shift between 1 and 3
		int randomShift = rand.nextInt(3) + 1;
		List<String> nameList = new ArrayList<String>(names);
		for (int i = 0; i < nameList.size(); i++) 
		{
			secretSantas.put(nameList.get(i), nameList.get((i + randomShift) % nameList.size()));			
		}				
	}
	
	public String getSecretSantaFor(String name)
	{
		return secretSantas.get(name);
	}

}
