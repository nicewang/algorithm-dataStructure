package com.nice.algorithms.link.main;

import com.nice.algorithms.link.Link;

public class LinkReverseMain {
	
	public static void main(String[] args) {
		Link link = new Link();
		link.addFirst(2);
		link.addFirst(1);
		link.add(3, 1);
		link.addLast(4);
		link.addLast(5);
		System.out.println("正序打印12345序列");
		System.out.println("链表长度为：" + link.size());
		System.out.println("顺序打印链表各元素如下：");
		link.printAll();
		System.out.println("____________________");
		link.reverse();
		System.out.println("逆序打印12345序列");
		System.out.println("链表长度为：" + link.size());
		System.out.println("顺序打印链表各元素如下：");
		link.printAll();
		System.out.println("____________________");
	}

}
