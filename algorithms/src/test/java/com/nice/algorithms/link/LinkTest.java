package com.nice.algorithms.link;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class LinkTest extends TestCase {
	
	private Link link;
	
	@BeforeClass
	public void setUp() {
		link = new Link();
	}
	
	@AfterClass
	public void tearDown() {
	}
	
	@Test
	public void testAddNormal() {
		assertEquals(0, link.size());
		link.addLast(4);
		assertEquals(1, link.size());
		link.addLast(5);
		assertEquals(2, link.size());
		assertEquals(5, link.get(1).getData());
		link.addFirst(2);
		assertEquals(3, link.size());
		assertEquals(2, link.get(0).getData());
		link.addFirst(1);
		assertEquals(4, link.size());
		assertEquals(1, link.get(0).getData());
		link.add(3, 1);
		assertEquals(5, link.size());
		assertEquals(3, link.get(2).getData());
		System.out.println("Test Add Normal -- 打印序列：");
		link.printAll();
		System.out.println("____________________");
	}
	
	@Test
	public void testAddNormal2() {
		assertEquals(0, link.size());
		link.addFirst(7);
		link.addFirst(6);
		assertEquals(2, link.size());
		assertEquals(6, link.get(0).getData());
		assertEquals(7, link.get(1).getData());
		System.out.println("Test Add Normal 2 -- 打印序列：");
		link.printAll();
		System.out.println("____________________");
	}
	
	@Test
	public void testAddNormal3() {
		assertEquals(0, link.size());
		link.add(9, -1);
		assertEquals(1, link.size());
		assertEquals(9, link.get(0).getData());
		link.add(8, -1);
		assertEquals(2, link.size());
		assertEquals(8, link.get(0).getData());
		link.add(10, 1);
		assertEquals(3, link.size());
		assertEquals(10, link.get(2).getData());
		System.out.println("Test Add Normal 3 -- 打印序列：");
		link.printAll();
		System.out.println("____________________");
	}
	
	@Test
	public void testAddException() {
		link.addFirst(11);
		boolean flag = false;
		String message = null;
		try {
			link.add(12, 1);
		} catch(IndexOutOfBoundsException e) {
			assertEquals("链表没有那么长", e.getMessage());
			flag = true;
			message = e.getMessage();
		}
		if(!flag) {
			fail();
		}
		System.out.println("Test Add Exception -- 打印序列：");
		link.printAll();
		System.out.println("Test Add Exception -- 打印异常信息：");
		System.out.println(message);
		System.out.println("____________________");
	}
	
	@Test
	public void testAddException2() {
		link.addFirst(13);
		link.add(12, -1);
		boolean flag = false;
		String message = null;
		try {
			link.add(14, -2);
		} catch(IndexOutOfBoundsException e) {
			assertEquals("链表不为空时，不能在位置为负数的地方插入", e.getMessage());
			flag = true;
			message = e.getMessage();
		}
		if(!flag) {
			fail();
		}
		System.out.println("Test Add Exception 2 -- 打印序列：");
		link.printAll();
		System.out.println("Test Add Exception 2 -- 打印异常信息：");
		System.out.println(message);
		System.out.println("____________________");
	}
	
	@Test
	public void testPrintAllException() {
		boolean flag = false;
		String message = null;
		try {
			link.printAll();
		} catch(IndexOutOfBoundsException e) {
			assertEquals("链表没有元素", e.getMessage());
			flag = true;
			message = e.getMessage();
		}
		if(!flag) {
			fail();
		}
		System.out.println("Test PrintAll Exception -- 打印异常信息：");
		System.out.println(message);
		System.out.println("____________________");
	}
	
	@Test
	public void testRemoveNormal() {
		link.addFirst(1);
		assertEquals(1, link.size());
		link.removeFirst();
		assertEquals(0, link.size());
		
		link.addLast(1);
		assertEquals(1, link.size());
		link.removeLast();
		assertEquals(0, link.size());
		
		link.addFirst(1);
		link.addLast(3);
		link.add(2, 0);
		assertEquals(3, link.size());
		assertEquals(1, link.get(0).getData());
		assertEquals(3, link.get(2).getData());
		link.removeFirst();
		link.removeLast();
		assertEquals(1, link.size());
		assertEquals(2, link.get(0).getData());
		
		link.removeMiddle(-1);
		assertEquals(0, link.size());
		
		link.addFirst(2);
		link.addFirst(1);
		link.addLast(4);
		link.addLast(5);
		link.add(3, 1);
		assertEquals(5, link.size());
		assertEquals(1, link.get(0).getData());
		assertEquals(5, link.get(4).getData());
		link.removeMiddle(0);
		assertEquals(2, link.get(0).getData());
		link.removeMiddle(3);
		assertEquals(4, link.get(2).getData());
		link.removeMiddle(1);
		assertEquals(2, link.size());
		assertEquals(2, link.get(0).getData());
		assertEquals(4, link.get(1).getData());
	}
	
	@Test
	public void testRemoveException() {
		boolean flag = false;
		String message = null;
		try {
			link.removeFirst();
		} catch(IndexOutOfBoundsException e) {
			assertEquals("链表没有元素", e.getMessage());
			flag = true;
			message = e.getMessage();
		}
		if(!flag) {
			fail();
		}
		System.out.println("Test Remove Exception -- 打印异常信息：");
		System.out.println(message);
		System.out.println("____________________");
	}
	
	@Test
	public void testRemoveException2() {
		boolean flag = false;
		String message = null;
		try {
			link.removeLast();
		} catch(IndexOutOfBoundsException e) {
			assertEquals("链表没有元素", e.getMessage());
			flag = true;
			message = e.getMessage();
		}
		if(!flag) {
			fail();
		}
		System.out.println("Test Remove Exception 2 -- 打印异常信息：");
		System.out.println(message);
		System.out.println("____________________");
	}
	
	@Test
	public void testRemoveException3() {
		boolean flag = false;
		String message = null;
		try {
			link.removeMiddle(-1);
		} catch(IndexOutOfBoundsException e) {
			assertEquals("链表没有元素", e.getMessage());
			flag = true;
			message = e.getMessage();
		}
		if(!flag) {
			fail();
		}
		System.out.println("Test Remove Exception 3 -- 打印异常信息：");
		System.out.println(message);
		System.out.println("____________________");
	}
	
	@Test
	public void testRemoveException4() {
		boolean flag = false;
		String message = null;
		link.addFirst(1);
		link.addLast(2);
		try {
			link.removeMiddle(2);
		} catch(IndexOutOfBoundsException e) {
			assertEquals("链表没有那么长", e.getMessage());
			flag = true;
			message = e.getMessage();
		}
		if(!flag) {
			fail();
		}
		System.out.println("Test Remove Exception 4 -- 打印异常信息：");
		System.out.println(message);
		System.out.println("____________________");
	}
	
	@Test
	public void testRemoveException5() {
		boolean flag = false;
		String message = null;
		link.addFirst(1);
		link.addLast(2);
		try {
			link.removeMiddle(-1);
		} catch(IndexOutOfBoundsException e) {
			assertEquals("请输入正确的index", e.getMessage());
			flag = true;
			message = e.getMessage();
		}
		if(!flag) {
			fail();
		}
		System.out.println("Test Remove Exception 5 -- 打印异常信息：");
		System.out.println(message);
		System.out.println("____________________");
	}
	
}
