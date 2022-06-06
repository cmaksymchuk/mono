package com.maksymchuk.shopify;

import java.util.Set;
import java.util.stream.Collectors;

public class StringDictOfWords {

	public boolean validSentence(Set<String> dict, String sentence) {
		
		boolean isValid = true;
		sentence = sentence.replaceAll("[^a-zA-Z0-9\\s]", "");
		System.out.println(sentence);
		String[] sentenceWords = sentence.split("\\s+");
		dict = dict.stream().map(s -> s.toLowerCase()).collect(Collectors.toSet());
		
		for (String word: sentenceWords)
		{
			if (!dict.contains(word.toLowerCase()))
			{
				isValid = false;
				break;
			}			
		}
		return isValid;
	}
}
