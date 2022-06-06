package com.maksymchuk.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class SecretSantaTest {

	@Test
	void test() {
		List<String> name1 = Arrays.stream(new String[] {"Cory","Allison","Emma","Ava"}).collect(Collectors.toList());
		List<String> name2 = Arrays.stream(new String[] {"Dustin","Wendy","Dion","Davis"}).collect(Collectors.toList());
		List<String> name3 = Arrays.stream(new String[] {"Marie","Dennis"}).collect(Collectors.toList());
		List<List<String>> nameLists = new ArrayList<List<String>>();
		nameLists.add(name1);
		nameLists.add(name2);
		nameLists.add(name3);
		

		SecretSantaNoFamily ss = new SecretSantaNoFamily(nameLists);
		System.out.println(ss.secretSantas);
	}

}
