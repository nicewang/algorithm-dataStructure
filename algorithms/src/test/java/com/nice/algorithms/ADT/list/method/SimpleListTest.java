package com.nice.algorithms.ADT.list.method;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author wangxiaonan
 */
public class SimpleListTest extends TestCase{
	
	SimpleList simpleList;
	
	@BeforeClass
	public void setUp() {
		System.out.println("Start!");
		simpleList = new SimpleList();
	}
	
	@AfterClass
	public void tearDown() {
		System.out.println("Stop!");
	}
	
	@Test
	public void testBasicOptions() {
		List<String> list = new ArrayList<String> ();
		//验证新创建的表为空
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		System.out.println("Yeah p! The new list is empty!");
		//向表中插入和删除元素
		list.add("Nice");
		assertTrue(list.contains("Nice"));
		System.out.println("Add 'Nice' successfully!");
		list.add("UESTC");
		assertTrue(list.contains("UESTC"));
		assertEquals(1, list.indexOf("UESTC"));
		System.out.println("Add 'UESTC' successfully!");
		list.add(1, "Wang");
		assertTrue(list.contains("Wang"));
		assertEquals(1, list.indexOf("Wang"));
		assertEquals(2, list.indexOf("UESTC"));
		System.out.println("Add 'Wang' successfully!");
		list.remove("Wang");
		assertFalse(list.contains("Wang"));
		System.out.println("Remove 'Wang' successfully!");
		list.remove(1);
		assertFalse(list.contains("UESTC"));
		System.out.println("Remove 'UESTC' successfully!");
		list.removeAll(list);
		assertTrue(list.isEmpty());
		System.out.println("The list is empty again!");
		list.add("nice");
		list.clear();
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		System.out.println("The list is empty again twice!");
		//测试在Iterable类型上使用增强的for循环
		//Iterable间接实现：通过一个增强的for循环间接使用
		list.add("Nice");
		list.add("Wang");
		list.add("UESTC");
		int i = 0;
		for(String tmp : list) {
			assertEquals(tmp, list.get(i++));
			System.out.println(tmp);
		}
		//测试Iterator接口（使用一个迭代器改写的Iterable类型上的增强for 循环）
		//Iterable直接实现：直接使用Iterator
		Iterator<String> iter_list = list.iterator();
		i = 0;
		while(iter_list.hasNext()){
			int size = list.size();
			System.out.println(i + ":");
			System.out.println(iter_list.next());
			iter_list.remove();
			assertEquals(size - 1, list.size());
			System.out.println("List size before = " + size + 
					" , list size after = " + list.size() + " .");
			i++;
		}
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void testSimpleList() {
		int[] arr = {1, 2, 3, 4, 5, 6};
		int length1 = arr.length;
		int[] new_arr = simpleList.simpleList_byArray(arr);
		int length2 = arr.length;
		int length3 = new_arr.length;
		assertEquals(length2, length1);
		assertEquals(length3, length2*2);
		int[] arr_copy = new int[length3];
		System.arraycopy(arr, 0, arr_copy, 0, length2);
		for(int i = 0; i < length3; i++) {
			assertEquals(new_arr[i], arr_copy[i]);
		}
	}
	
}
