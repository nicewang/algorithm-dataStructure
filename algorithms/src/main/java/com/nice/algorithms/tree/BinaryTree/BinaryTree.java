package com.nice.algorithms.tree.BinaryTree;

public class BinaryTree {
	
	private BinaryTreeNode root;
	
	public BinaryTree() {
	}
	
	public BinaryTree(BinaryTreeNode root) {
		this.root = root;
	}

	public BinaryTreeNode getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}
	
	//标记：以下清空方法单元测试验证失败
	/**
	 * 清除某个子树的所有节点
	 * @param node
	 */
	public void clear(BinaryTreeNode node) {
		if(node != null) {
			clear(node.getLeftChild());   //递归地删除左子节点
			clear(node.getRightChild());  //递归地删除右子节点
			node = null;
		}
	}
	
	/**
	 * 清空树
	 */
	public void clear() {
		clear(root);
	}
	//标记：以上清空方法单元测试验证失败
	
	/**
	 * 判断二叉树是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return root == null;
	}
	
	/**
	 * 获取该二叉树的高度
	 * @return
	 */
	public int height() {
		return height(root);
	}
	
	/**
	 * 获取以某节点为根的子树的高度
	 * @param node
	 * @return
	 */
	public int height(BinaryTreeNode node) {
		if(node == null) {
			return 0; //递归结束，空子树的高度为0
		} else {
			//递归获取左子树的高度
			int l = height(node.getLeftChild());
			//递归获取右子树的高度
			int r = height(node.getRightChild());
			//高度为更高的一边（加1是因为要加上自己这一层）
			return l > r ? l + 1 : r + 1;
		}
	}
	
	/**
	 * 获取二叉树的节点数
	 * @return
	 */
	public int size() {
		return size(root);
	}
	
	/**
	 * 获取以某节点为根的子树的节点数
	 * @param node
	 * @return
	 */
	public int size(BinaryTreeNode node) {
		if(node == null) {
			return 0; //递归结束，空子树的节点数为0
		} else {
			//递归获取左子树的节点数
			int l = size(node.getLeftChild());
			//递归获取右子树的节点数
			int r = size(node.getRightChild());
			//节点数为左右子树节点数之和再加上自己（加1）
			return l + r + 1;
		}
	}
	
	/**
	 * 查找node节点在二叉树中的父节点
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getParent(BinaryTreeNode node) {
		return getParent(root, node); //验一下root为空和root为node的情况
	}
	
	/**
	 * 递归查找node节点在以subTree为根的子树中的父节点
	 * @param subTree
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getParent(BinaryTreeNode subTree, BinaryTreeNode node) {
		if(subTree == null) {
			//如果子树为空，则没有父节点
			return null;
		}
		if(subTree.getLeftChild() == node || subTree.getRightChild() == node) {
			//父节点为该子树树根的情况
			return subTree;
		}
		BinaryTreeNode parent = null;
		//先递归在左子树找
		if((parent = getParent(subTree.getLeftChild(), node)) != null) {
			return parent;
		} else {
			//再递归在右子树找
			return getParent(subTree.getRightChild(), node);
		}
	}
	
	/**
	 * 获取某个节点的左子树
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getLeftTree(BinaryTreeNode node) {
		return node.getLeftChild();
	}
	
	/**
	 * 获取某个节点的右子树
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getRightTree(BinaryTreeNode node) {
		return node.getRightChild();
	}
	
	/**
	 * 给某节点插入左子节点
	 * @param parent
	 * @param newNode
	 */
	public void insertLeft(BinaryTreeNode parent, BinaryTreeNode newNode) {
		parent.setLeftChild(newNode);
	}
	
	/**
	 * 给某节点插入右子节点
	 * @param parent
	 * @param newNode
	 */
	public void insertRight(BinaryTreeNode parent, BinaryTreeNode newNode) {
		parent.setRightChild(newNode);
	}
	
	/**
	 * 二叉树先根遍历
	 * @param node
	 */
	public void preOrder(BinaryTreeNode node) {
		if(node != null) {
			//visited(node);
			System.out.println(node.getData());
			preOrder(node.getLeftChild());
			preOrder(node.getRightChild());
		}
	}
	
	/**
	 * 二叉树中根遍历
	 * @param node
	 */
	public void inOrder(BinaryTreeNode node) {
		if(node != null) {
			inOrder(node.getLeftChild());
			//visited(node);
			System.out.println(node.getData());
			inOrder(node.getRightChild());
		}
	}
	
	/**
	 * 二叉树后根遍历
	 * @param node
	 */
	public void postOrder(BinaryTreeNode node) {
		if(node != null) {
			postOrder(node.getLeftChild());
			postOrder(node.getRightChild());
			//visited(node);
			System.out.println(node.getData());
		}
	}

}
