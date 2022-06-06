package com.maksymchuk.shopify;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
// https://codereview.stackexchange.com/questions/84812/java-class-that-generates-a-short-url-string-for-an-input-string
public class UrlShortener {
	
	Map<String, String> urlMap;

	static class RandomString
	{
	    public static String getRandonString(int length){
	    	if (length > 32)
	    	{
	    		throw new IllegalArgumentException("Maximum Length is 32");
	    	}
	    	return UUID.randomUUID().toString().replaceAll("-", "").substring(0, length);
	    }
	}
	
	public synchronized String encode(String url)
	{
		if (urlMap.containsValue(url))
		{
			return urlMap.get(url);
		}
		String encoded = "http://cory.com/" + RandomString.getRandonString(6);
		urlMap.put(encoded, url);
		return encoded;		
	}
	
	public String decode(String tinyUrl)
	{
		String url = urlMap.get(tinyUrl);
		if (url ==  null)
		{
			throw new NoSuchElementException("Tiny url " + tinyUrl + " was not found");
		}
		return url;		
	}


}
