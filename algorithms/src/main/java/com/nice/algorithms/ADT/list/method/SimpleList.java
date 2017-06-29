package com.nice.algorithms.ADT.list.method;

/**
 * @author wangxiaonan
 */
public class SimpleList {
	
	/**
	 * 表的简单数组实现
	 * 将原数组中的所有元素复制到新数组
	 * 并将新数组的存储空间扩大为原数组的两倍
	 * @param arr
	 */
	public int[] simpleList_byArray(int[] arr) {
		int length = arr.length;
		int[] new_arr = new int[length*2];
		for(int i = 0; i < length; i++) {
			new_arr[i] = arr[i];
			System.out.println("new_arr's length = " + new_arr.length);
		}
		arr = new_arr;
		return new_arr;
	}
	
}
