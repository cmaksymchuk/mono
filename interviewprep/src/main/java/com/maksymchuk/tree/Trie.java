package com.maksymchuk.tree;

public class Trie {
    private TrieNode root = new TrieNode();
    
    public void add(String word)
    {
    	TrieNode current = root;
    	for (int i = 0 ; i < word.length(); i++	)
    	{
    		char c = word.charAt(i);
    		current.children.put(c, current.children.computeIfAbsent(c, l -> new TrieNode()));
    		current = current.children.get(c);
    	}
    	current.isWord = true;    	

    }
    
    public boolean find(String word)
    {
    	TrieNode current = root;
    	for (int i = 0 ; i < word.length(); i++	)
    	{
    		char c = word.charAt(i);
    		if (current.children.containsKey(c))
    		{
    			current = current.children.get(c);
    		}
    		if (i == (word.length() -1) && current.isWord)
    		{
    			return true;
    		}
    	}
    	return false;    	
	}
    
}
