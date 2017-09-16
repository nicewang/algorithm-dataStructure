package com.nice.algorithms.sort.method;

import java.util.List;

/**
 * 插入排序算法
 * @author NiceWang
 */
public class InsertSort {

	/**
	 * 自己写的插入排序，不知道对不对，也不知道也没有写出冒泡排序的意味
	 * @param input
	 */
	public void insertSort1(long[] input) {
		long time0 = System.nanoTime();
		for(int i = 0; i < input.length; i++) {
			for(int j = input.length - 1; j > i; j--) {
				if(input[j] < input[j-1]) {
					long tmp = input[j];
					input[j] = input[j-1];
					input[j-1] = tmp;
				}
			}
		}
		long time1 = System.nanoTime();
		System.out.println("The lasting time of swaping of insertSort1: " + (time1 - time0));
	}
	
	/**
	 * 插入排序的官方版本
	 * @param input
	 */
	public void insertSort2(long[] input) {
		long time0 = System.nanoTime();
		for(int i = 1; i < input.length; i++) {
			long temp = input[i];
			int j;
			for(j = i; j > 0 && input[j-1] > temp; j--) {
				input[j] = input[j-1];
			}
			input[j] = temp;
		}
		long time1 = System.nanoTime();
		System.out.println("The lasting time of swaping of insertSort2: " + (time1 - time0));
	}
	
	/**
	 * 插入排序官方版本——要排序的对象放在ArrayList里
	 * @param input
	 */
	public static void insertSort(List<Integer> input) {
		for(int i = 1; i < input.size(); i++) {
			int temp = input.get(i);
			int j;
			for(j = i; j > 0 && input.get(j-1) > temp; j--) {
				input.add(j, input.get(j-1));
				input.remove(j+1);
			}
			input.add(j, temp);
			input.remove(j+1);
		}
	}
	
}
