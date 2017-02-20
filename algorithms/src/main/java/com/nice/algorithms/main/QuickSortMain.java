package com.nice.algorithms.main;

public class QuickSortMain 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    public void QuickSort(int[] input, int left, int right) {
    	int temp;
    	int length = input.length;
    	int flag = input[length-1];
    	int i = left, j = right;
    	while( i < j ) {
    		while(input[++i] < flag);
    		while(input[--j] > flag);
    		temp = input[i];
    		input[i] = input[j];
    		input[j] = temp;
    	}
    	temp = input[i];
    	input[i] = input[length-1];
    	input[length-1] = temp;
    }
}
