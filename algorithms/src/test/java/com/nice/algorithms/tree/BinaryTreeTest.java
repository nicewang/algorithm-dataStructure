package com.nice.algorithms.tree;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.nice.algorithms.tree.BinaryTree.BinaryTree;
import com.nice.algorithms.tree.BinaryTree.BinaryTreeNode;

import junit.framework.TestCase;

public class BinaryTreeTest extends TestCase {
	
	private BinaryTree binaryTree, binaryTree1;
	private BinaryTreeNode A, B, C, D, E, F, G, H, I, J;
	
	@BeforeClass
	public void setUp() {
		
		//构建二叉树
		//第一层（根节点）
		A = new BinaryTreeNode();
		//第二层
		B = new BinaryTreeNode();
		C = new BinaryTreeNode();
		A.setLeftChild(B);
		A.setRightChild(C);
		//第三层
		D = new BinaryTreeNode();
		E = new BinaryTreeNode();
		F = new BinaryTreeNode();
		G = new BinaryTreeNode();
		B.setLeftChild(D);
		B.setRightChild(E);
		C.setLeftChild(F);
		C.setRightChild(G);
		//第四层
		H = new BinaryTreeNode();
		I = new BinaryTreeNode();
		J = new BinaryTreeNode();
		D.setLeftChild(H);
		D.setRightChild(I);
		E.setLeftChild(J);
		
		//准备数据
		A.setData(0);
		B.setData(1);
		C.setData(2);
		D.setData(3);
		E.setData(4);
		F.setData(5);
		G.setData(6);
		H.setData(7);
		I.setData(8);
		J.setData(9);
		
	}
	
	@AfterClass
	public void tearDown() {
		
	}
	
	@Test
	public void testNormal() {
		
		binaryTree = new BinaryTree();
		
		assertTrue(binaryTree.isEmpty());
		
		binaryTree.setRoot(A);
		
		assertEquals(4, binaryTree.height());
		assertEquals(3, binaryTree.height(B));
		assertEquals(2, binaryTree.height(C));
		assertEquals(2, binaryTree.height(D));
		assertEquals(2, binaryTree.height(E));
		assertEquals(1, binaryTree.height(F));
		assertEquals(1, binaryTree.height(G));
		assertEquals(1, binaryTree.height(H));
		assertEquals(1, binaryTree.height(I));
		assertEquals(1, binaryTree.height(J));
		
		assertEquals(10, binaryTree.size());
		assertEquals(6, binaryTree.size(B));
		assertEquals(3, binaryTree.size(C));
		assertEquals(3, binaryTree.size(D));
		assertEquals(2, binaryTree.size(E));
		
		assertEquals(A, binaryTree.getParent(B));
		assertEquals(A, binaryTree.getParent(C));
		assertEquals(B, binaryTree.getParent(D));
		assertEquals(B, binaryTree.getParent(E));
		assertEquals(C, binaryTree.getParent(F));
		assertEquals(C, binaryTree.getParent(G));
		assertEquals(D, binaryTree.getParent(H));
		assertEquals(D, binaryTree.getParent(I));
		assertEquals(E, binaryTree.getParent(J));
		
		BinaryTreeNode A1 = new BinaryTreeNode();
		A1.setData(0);
		binaryTree1 = new BinaryTree(A1);
		binaryTree1.insertLeft(A1, B);
		binaryTree1.insertRight(A1, C);
		assertEquals(A1, binaryTree1.getRoot());
		
		System.out.println("binaryTree -- 前根遍历：");
		binaryTree.preOrder(A);
		System.out.println("____________________");
		System.out.println("binaryTree1 -- 前根遍历：");
		binaryTree1.preOrder(A1);
		System.out.println("____________________");
		
		System.out.println("binaryTree -- 中根遍历：");
		binaryTree.inOrder(A);
		System.out.println("____________________");
		System.out.println("binaryTree1 -- 中根遍历：");
		binaryTree1.inOrder(A1);
		System.out.println("____________________");
		
		System.out.println("binaryTree -- 后根遍历：");
		binaryTree.postOrder(A);
		System.out.println("____________________");
		System.out.println("binaryTree1 -- 后根遍历：");
		binaryTree1.postOrder(A1);
		System.out.println("____________________");

	}

}
