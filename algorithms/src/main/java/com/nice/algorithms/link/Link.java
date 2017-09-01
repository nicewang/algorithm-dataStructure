package com.nice.algorithms.link;

/**
 * @author wangxiaonan
 */
public class Link {

	private int size = 0;
	private Node first;
	private Node last;
	
	/**
	 * 链表的初始化
	 */
	public Link() {
	}
	
	/**
	 * 链表后部插入
	 * @param data
	 */
	public void addLast(int data) {
		if(size == 0) {
			//链表为空，初始化前后元素
			fillStart(data);
		} else {
			Node node = new Node();
			node.setData(data);
			last.setNext(node);
			last = node;
		}
		size++;
	}
	
	public void addFirst(int data) {
		if(size == 0) {
			//链表为空，初始化头尾元素
			fillStart(data);
		} else {
			Node node = new Node();
			node.setData(data);
			node.setNext(first);
			first = node;
		}
		size++;
	}
	
	/**
	 * 在链表指定位置的后面插入
	 * @param data
	 * @param index
	 */
	public void add(int data, int index) {
		if(size > index) {
			if(size == 0) {
				//对应index小于0的情况，通通在第1个元素（first）的位置插入
				//为空初始化前后元素
				fillStart(data);
				size++;
			} else if(index == -1) {
				//在位置为0处插入
				addFirst(data);
			} else if(size == index + 1) {
				//在位置为size处插入
				addLast(data);
			} else if(index < -1) {
				//另一种index小于0的情况
				throw new IndexOutOfBoundsException("链表不为空时，不能在位置为负数的地方插入");
			} else {
				//在位置为index+1处插入
				Node temp = get(index);
				Node node = new Node();
				node.setData(data);
				node.setNext(temp.getNext());
				temp.setNext(node);
				size++;
			}
		} else {
			throw new IndexOutOfBoundsException("链表没有那么长");
		}
	}
	
	/**
	 * 删除表头元素
	 */
	public void removeFirst() {
		if(size ==  0) {
			throw new IndexOutOfBoundsException("链表没有元素");
		} else if (size == 1) {
			//只剩一个时需要清除first和last
			clear();
		} else {
			Node temp = first;
			first = temp.getNext();
			temp = null;
			size--;
		}
	}
	
	/**
	 * 删除链表尾部元素
	 */
	public void removeLast() {
		if (size == 0) {
			throw new IndexOutOfBoundsException("链表没有元素");
		} else if(size == 1) {
			//只剩一个时需要清除first和last
			clear();
		} else {
			Node temp = get(size - 2);
			last = temp;
			temp.setNext(null);
			temp = null;   //不能这么些，写了last就变为null了?   //不会的
			size--;
		}
	}
	
	/**
	 * 删除链表中间的元素
	 * @param index
	 */
	public void removeMiddle(int index) {
		if(size == 0) {
			throw new IndexOutOfBoundsException("链表没有元素");
		} else if(size == 1) {
			//只剩一个元素时需要清除first和last
			clear();
		} else {
			if(index == 0) {
				removeFirst();
			} else if(size == index + 1) {
				removeLast();
			} else if(index >= size) {
				throw new IndexOutOfBoundsException("链表没有那么长");
			} else if(index < 0) {
				throw new IndexOutOfBoundsException("请输入正确的index");
			} else {
				Node temp = get(index - 1);
				Node next = temp.getNext();
				temp.setNext(next.getNext());
				next = null;
				size--;
			}
		}
	}
	
	/**
	 * 获取指定下标元素
	 * @param index
	 * @return
	 */
	public Node get(int index) {
		Node temp = first;
		for(int i = 0; i < index; i++) {
			temp = temp.getNext();
		}
		return temp;
	}
	
	/**
	 * 打印所有元素的数据
	 */
	public void printAll() {
		if(size == 0) {
			throw new IndexOutOfBoundsException("链表没有元素");
		} else {
			Node temp = first;
			System.out.println(temp.getData());
			for(int i = 0; i < size - 1; i++) {
				temp = temp.getNext();
				System.out.println(temp.getData());
			}
		}
	}
	
	public int size() {
		return size;
	}
	
	/**
	 * 在链表为空时插入第1个元素，头、尾元素都是一个元素
	 * @param data
	 */
	private void fillStart(int data) {
		first = new Node();
		first.setData(data);
		last = first;
	}
	
	/**
	 * 在链表元素只有1个时清除
	 */
	private void clear() {
		first = null;
		last = null;
		size = 0;
	}
	
}
