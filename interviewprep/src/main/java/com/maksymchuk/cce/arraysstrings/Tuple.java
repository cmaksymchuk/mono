package com.maksymchuk.cce.arraysstrings;

public class Tuple<X, Y> { 
	  public final X first; 
	  public final Y second; 
	  public Tuple(X first, Y second) { 
	    this.first = first; 
	    this.second = second; 
	} 
	public X first()
	{
		return first;
	}
	public Y second()
	{
		return second;
	}
} 