package com.maksymchuk.binarytree;

import java.util.Arrays;

public class BinaryHeapTree {
	
	public int[] heap = new int[8];
	public int currentIndex = 0;
	
	public void add(int value)
	{
		if (heap.length <= currentIndex * 2)
		{
			int[] biggerArray = Arrays.copyOf(heap, heap.length * 2);
			heap = biggerArray;
		}
		heap[currentIndex] = value;
		shuffle(currentIndex);

		currentIndex++;
	}
	
	public int leftIndex(int index)
	{
		return (index * 2) + 1;
	}
	
	public int rightIndex(int index)
	{
		return (index * 2) + 2;
	}
	
	public int parentIndex(int index)
	{
		if (isRight(index))
		{
			return  (index - 2) / 2;
		}
		else if (isLeft(index))
		{
			return (index -1) / 2;
		} 
		else 
		{
			return -1;
		}
	}
	
	public boolean isLeft(int index)
	{
		return index != 0 && index % 2 == 1;
	}
	
	public boolean isRight(int index)
	{
		return index != 0 && index % 2 == 0;
	}
	
	public void shuffle(int index)
	{
		int parentIndex = parentIndex(index);
		if (parentIndex != -1)
		{
			if (heap[index] < heap[parentIndex])
			{
				int temp = heap[index];
				heap[index] = heap[parentIndex];
				heap[parentIndex] = temp;
				shuffle(parentIndex);
			}
		}
	}
	

    public String toString() {
    	int index = 0;
        StringBuilder buffer = new StringBuilder(50);
        print(index, buffer, "", "");
        return buffer.toString();
    }

    public void print(int index, StringBuilder buffer, String prefix, String childrenPrefix) {
    	int value = heap[index];
    	int left = heap[leftIndex(index)];
    	int right = heap[rightIndex(index)];
    	
        buffer.append(prefix);
        buffer.append(value);
        buffer.append('\n');
        if (left != 0)
        {
            print(leftIndex(index), buffer, childrenPrefix + "|-l ", childrenPrefix + "|   ");
        }
        if (right != 0)
        {
            print(rightIndex(index), buffer, childrenPrefix + "|-r ", childrenPrefix + "|   ");        
        }
    }
	/*
	
	
	                     0
	           1                  2
	      3         4         5       6
	 7         8 9     10  11  12   13  14 
	*/
}
