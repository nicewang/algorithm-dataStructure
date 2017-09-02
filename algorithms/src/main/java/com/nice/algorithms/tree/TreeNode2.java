package com.nice.algorithms.tree;

import com.nice.algorithms.link.Link;

public class TreeNode2 {

	private int data;
	private int parent;
	private Link children;
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public Link getChildren() {
		return children;
	}
	public void setChildren(Link children) {
		this.children = children;
	}
	
}
