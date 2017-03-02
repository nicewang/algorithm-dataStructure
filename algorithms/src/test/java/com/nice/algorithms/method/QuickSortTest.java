package com.nice.algorithms.method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;


public class QuickSortTest extends TestCase
{
    
	@Before
	public void setUp() {
		
	}
	
	@After
	public void tearDown() {
		
	}
	/**
	 * 一般用例
	 */
	@Test
	public void testSimple() {
		int[] input = {1,4,2,3,9,7,8};
		int[] expected = {1,2,3,4,7,8,9};
		QuickSort sort = new QuickSort();
		sort.Sort(input, 0, input.length-2);
		for(int i = 0; i < input.length; i++) {
			assertEquals(expected[i], input[i]);
		}
	}
	/**
	 * 特殊情况用例一：除middle外所有数都比middle小（每一次排序所选取的middle为最右边元素即数组最后一个元素）
	 */
	@Test
	public void testRightMax() {
		int[] input = {6,4,2,5,3,7,8,0,1,9};
		int[] expected = {0,1,2,3,4,5,6,7,8,9};
		QuickSort sort = new QuickSort();
		sort.Sort(input, 0, input.length-2);
		for(int i = 0; i < input.length; i++) {
			assertEquals(expected[i], input[i]);
		}
	}
	/**
	 * 一般用例二：除middle外所有数都比middle大
	 */
	@Test
	public void testRightMin() {
		int[] input = {1,4,2,3,9,7,0};
		int[] expected = {0,1,2,3,4,7,9};
		QuickSort sort = new QuickSort();
		sort.Sort(input, 0, input.length-2);
		for(int i = 0; i < input.length; i++) {
			assertEquals(expected[i], input[i]);
		}
	}
	
	/**
	 * 下面的测试都是针对数组中有重复元素的情况
	 * 有重复元素的快排还没写，只是想测试一下当前的方法是否对有重复元素的情况也适用
	 */
	
	@Test
	public void testRepeatRightMax() {
		//重复元素为数组中最大元素
		//且重复元素为数组中最右边元素
		int[] input = {6,4,2,5,3,7,8,0,1,9,9};
		int[] expected = {0,1,2,3,4,5,6,7,8,9,9};
		QuickSort sort = new QuickSort();
		sort.Sort(input, 0, input.length-2);
		for(int i = 0; i < input.length; i++) {
			assertEquals(expected[i], input[i]);
		}
		//重复元素为数组中最小元素
		int[] input1 = {6,4,2,5,3,7,8,0,0,1,9,};
		int[] expected1 = {0,0,1,2,3,4,5,6,7,8,9};
		sort.Sort(input1, 0, input1.length-2);
		for(int i = 0; i < input1.length; i++) {
			assertEquals(expected1[i], input1[i]);
		}
		//重复元素为数组中最左边元素
		int[] input2 = {6,6,4,2,5,3,7,8,0,1,9,};
		int[] expected2 = {0,1,2,3,4,5,6,6,7,8,9};
		sort.Sort(input2, 0, input2.length-2);
		for(int i = 0; i < input2.length; i++) {
			assertEquals(expected2[i], input2[i]);
		}
		//重复元素为数组中间的某个元素
		//（既不是最左边元素也不是最右边元素）
		//（既不是最大元素也不是最小元素）
		int[] input3 = {6,4,2,5,5,3,7,8,0,1,9,};
		int[] expected3 = {0,1,2,3,4,5,5,6,7,8,9};
		sort.Sort(input3, 0, input3.length-2);
		for(int i = 0; i < input3.length; i++) {
			assertEquals(expected3[i], input3[i]);
		}
	}
	
	@Test
	public void testRepeatRightMin() {
		//重复元素为数组中最小元素
		//且重复元素为数组中最右边元素
		int[] input = {1,4,2,3,9,7,0,0};
		int[] expected = {0,0,1,2,3,4,7,9};
		QuickSort sort = new QuickSort();
		sort.Sort(input, 0, input.length-2);
		for(int i = 0; i < input.length; i++) {
			assertEquals(expected[i], input[i]);
		}
		//重复元素为数组中最大元素
		int[] input2 = {1,4,2,3,9,9,7,0};
		int[] expected2 = {0,1,2,3,4,7,9,9};
		sort.Sort(input2, 0, input2.length-2);
		for(int i = 0; i < input2.length; i++) {
			assertEquals(expected2[i], input2[i]);
		}
		//重复元素为数组中最左边元素
		int[] input1 = {1,1,4,2,3,9,7,0};
		int[] expected1 = {0,1,1,2,3,4,7,9};
		sort.Sort(input1, 0, input1.length-2);
		for(int i = 0; i < input1.length; i++) {
			assertEquals(expected1[i], input1[i]);
		}
		//重复元素为数组中间的某个元素
		//（既不是最左边元素也不是最右边元素）
		//（既不是最大元素也不是最小元素）
		int[] input3 = {1,4,2,2,3,9,9,7,0};
		int[] expected3 = {0,1,2,2,3,4,7,9,9};
		sort.Sort(input3, 0, input3.length-2);
		for(int i = 0; i < input3.length; i++) {
			assertEquals(expected3[i], input3[i]);
		}
	}
	
	@Test
	public void testRepeatSimple() {
		//重复元素为数组中最小元素
		//且重复元素为数组中最左边元素
		int[] input = {1,1,4,2,3,9,7,8};
		int[] expected = {1,1,2,3,4,7,8,9};
		QuickSort sort = new QuickSort();
		sort.Sort(input, 0, input.length-2);
		for(int i = 0; i < input.length; i++) {
			assertEquals(expected[i], input[i]);
		}
		//重复元素为数组中最大元素
		int[] input1 = {1,4,2,3,9,9,7,8};
		int[] expected1 = {1,2,3,4,7,8,9,9};
		sort.Sort(input1, 0, input1.length-2);
		for(int i = 0; i < input1.length; i++) {
			assertEquals(expected1[i], input1[i]);
		}
		//重复元素为数组中最右边元素
		int[] input2 = {1,4,2,3,9,7,8,8};
		int[] expected2 = {1,2,3,4,7,8,8,9};
		sort.Sort(input2, 0, input2.length-2);
		//测试用例在这里运行失败了，so输出一下以mark
		for(int i = 0; i < input2.length; i++) {
			System.out.println(input2[i]);
		}
		//测试用例在这里运行失败了，so输出一下以mark
		for(int i = 0; i < input2.length; i++) {
			assertEquals(expected2[i], input2[i]);
		}
		//重复元素为数组中间的某个元素
		//（既不是最左边元素也不是最右边元素）
		//（既不是最大元素也不是最小元素）
		int[] input3 = {1,4,2,3,9,7,7,8};
		int[] expected3 = {1,2,3,4,7,7,8,9};
		sort.Sort(input3, 0, input3.length-2);
		for(int i = 0; i < input3.length; i++) {
			assertEquals(expected3[i], input3[i]);
		}
	}
}
