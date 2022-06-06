package com.maksymchuk.prep;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

public class RegularExpressionsTest {
	
	@Test
	public void test()
	{
	    Pattern pattern = Pattern.compile("w3schools", Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher("Visit W3Schools!");
	    
	    
	    
	    boolean matchFound = matcher.find();
	    if(matchFound) {
	      System.out.println("Match found");
	    } else {
	      System.out.println("Match not found");
	    }
	}

	
	@Test
	public void testEmpNoReplace()
	{
		String s = "100000202";
	    s = s.replaceAll("^\\d{2}[0]*", "");
	    System.out.println("-" + s + "-");
	    
	    s = "A100000202";
	    s = s.replaceAll("^[A-Za-z]?\\d{2}[0]*", "");
	    System.out.println("-" + s + "-");
	}
	

}
