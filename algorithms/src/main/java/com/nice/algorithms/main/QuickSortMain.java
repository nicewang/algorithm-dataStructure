package com.nice.algorithms.main;

import com.nice.algorithms.method.QuickSort;

public class QuickSortMain 
{
    public static void main( String[] args )
    {
    	QuickSort quickSort = new QuickSort();
    	int length;
        int[] input = {1,4,2,3,9,7,8};
//    	int[] input = {6,4,2,5,3,7,8,0,1,9};
        length = input.length;
        int right = length - 2;
        quickSort.Sort(input, 0, right);
        for(int i = 0; i < length; i++) {
        	System.out.println(input[i]);
        }
    }
    
}
