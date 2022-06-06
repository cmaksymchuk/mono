package com.maksymchuk.tree;

import org.junit.jupiter.api.Test;

public class TrieNodeTest {
    Trie trie = new Trie();

    @Test
	public void setup() 
	{

		    trie.add("Programming");
		    trie.add("is");
		    trie.add("a");
		    trie.add("way");
		    trie.add("of");
		    trie.add("life");

	
		    System.out.println(trie.find("is"));
		    System.out.println(trie.find("Program"));
		    System.out.println(trie.find("Programming"));


	}
    
    
}
