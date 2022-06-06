package com.maksymchuk.prep;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverlappingIntervals 
{

	public static class Pair
	{
		public int start;
		public int end;

		public Pair(int start, int end)
		{
			this.start = start;
			this.end = end;
		}
		public String toString() 
		{
			return "[" + start + "," + end + "]";
		}		
	}
	public static void main(String...strings)
	{
		Pair[] arr = new Pair[] {
				new Pair(1,5)
				, new Pair(3,7)
				, new Pair(4,6)
				, new Pair(6,8)
				, new Pair(10,12)
				, new Pair(12,15)
		};
		
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(merge(arr)));
	}
	

	public static Pair[] merge(Pair[] pairs)
	{
		List<Pair> merged = new ArrayList<Pair>();
		for (int i = 0; i < pairs.length; i++)
		{
			if (i == 0)
			{
				merged.add(pairs[i]);
				continue;
			}
			
			Pair lastMerged = merged.get(merged.size()-1);
			if (pairs[i].start <= lastMerged.end)
			{
				int end = lastMerged.end > pairs[i].end ? lastMerged.end : pairs[i].end;
				merged.set(merged.size()-1, new Pair(lastMerged.start, end));
			}
			else
			{
				merged.add(pairs[i]);
			}			
		}
		
		Pair[] rtrn = new Pair[merged.size()];
		rtrn = merged.toArray(rtrn);
		return rtrn;
	}
	
	
}
