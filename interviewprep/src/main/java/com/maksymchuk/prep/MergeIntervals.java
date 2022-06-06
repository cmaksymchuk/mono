package com.maksymchuk.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
    	
        if (intervals == null || intervals.length == 0)
            return intervals;
    	
        // sort the intervals in increasing order of start time
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] r1,int[] r2)
            {
                return r1[0] - r2[0];
            }
        });
        
        System.out.println(Arrays.deepToString(intervals));
    	
    	
    	// merged will contain all zeros (false)
    	List<int[]> mergedList = new ArrayList<>();
    	mergedList.add(intervals[0]);
    	
    	for (int i = 1; i < intervals.length; i++) {
    		int[] r1 = mergedList.get(mergedList.size()-1);
    		int[] r2 = intervals[i];
			
			
			if (overlaps(r1,r2))
			{
				r1[1] = Math.max(r1[1], r2[1]);
			}
			else
			{
				mergedList.add(r2);
			}
		}

    	int[][] rtrnArray = new int[mergedList.size()][mergedList.get(0).length];
        return mergedList.toArray(rtrnArray);
    }
    
    public boolean overlaps(int[] r1, int[] r2)
    {
    	return r1[1] >= r2[0];
    }
    
    
    // the biggest start to the smallest end is the overlapping range
    
//    public boolean overlaps(int[] r1, int[] r2)
//    {
//    	// if r1 = 1-5, r2 = 4-6
//    	// e = 4, f = 5 there is overlap
//    	
//    	// if r1 = 1-2, r2 = 3-4
//    	// e = 3, f = 2, no overlap
//    	int e = Math.max(r1[0],r2[0]);
//    	int f = Math.min(r1[1],r2[1]);    	
//    	return e <= f;
//    }
    
    public int[] newRange(int[] r1, int[] r2)
    {
    	return new int[] {
    			Math.min(r1[0], r2[0])
    			, Math.max(r1[1], r2[1])};
    	    	
    }
}
