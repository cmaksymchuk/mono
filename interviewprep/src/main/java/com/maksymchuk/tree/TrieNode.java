package com.maksymchuk.tree;

import java.util.HashMap;

public class TrieNode {

    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isWord;
    

}
