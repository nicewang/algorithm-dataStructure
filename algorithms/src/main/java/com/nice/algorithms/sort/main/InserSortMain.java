package com.nice.algorithms.sort.main;

import java.util.Scanner;

import com.nice.algorithms.sort.method.InsertSort;

/**
 * 带入口函数的用于测试插入排序算法的类
 * @author NiceWang
 */
public class InserSortMain {

	public static void main(String[] args) {
		InsertSort Sort = new InsertSort();
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int n = in.nextInt();
			long[] lights_list = new long[n];
			for(int i = 0; i < n; i++) {
				lights_list[i] = in.nextLong();
			}
			Sort.insertSort1(lights_list);
			for(int i = 0; i < n; i++) {
				System.out.println(lights_list[i]);
			}
			n = in.nextInt();
			lights_list = new long[n];
			for(int i = 0; i < n; i++) {
				lights_list[i] = in.nextLong();
			}
			Sort.insertSort2(lights_list);
			for(int i = 0; i < n; i++) {
				System.out.println(lights_list[i]);
			}
		}
		in.close();
	}
	
}
