package com.nice.algorithms.main;

import com.nice.algorithms.method.QuickSort;

/**
 * 快排实现从左到右从小到大排序，每一次排序所选取的middle为最右边元素（数组最后一个元素）
 * @author NiceWang
 *
 */
public class QuickSortMain 
{
    public static void main( String[] args )
    {
    	QuickSort quickSort = new QuickSort();
    	int length;
//      int[] input = {1,4,2,3,9,7,8};  //一般用例
//    	int[] input = {6,4,2,5,3,7,8,0,1,9}; //特殊情况用例一：除middle外所有数都比middle小
        int[] input = {1,4,2,3,9,7,0};  //一般用例二：除middle外所有数都比middle大
        length = input.length;
        int right = length - 2;
        quickSort.Sort(input, 0, right);
        for(int i = 0; i < length; i++) {
        	System.out.println(input[i]);
        }
    }
    
}
