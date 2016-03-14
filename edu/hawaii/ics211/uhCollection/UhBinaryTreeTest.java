package edu.hawaii.ics211.uhCollection;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.hawaii.ics211.uhCollection.*;
import edu.hawaii.ics211.uhCollection.UhBinaryTree.UhBinaryTreeNode;

public class UhBinaryTreeTest {
  
	@Test
	public void testConstructor1() {
		UhBinaryTree tree = new UhBinaryTree();
		assertNull(tree.root); 
	}
	
	@Test
	public void testConstructor2() {
		UhBinaryTreeNode mike = new UhBinaryTreeNode("mike");
		UhBinaryTree tree = new UhBinaryTree(mike);
		assertEquals(mike, tree.root);
		assertNull(tree.root.left);
		assertNull(tree.root.right);
		assertEquals("mike", tree.root.data);
	}
	
	@Test
	public void testBalancedTree() {
		UhBinaryTreeNode mike = new UhBinaryTreeNode("mike");
		UhBinaryTree treeBal = new UhBinaryTree(mike);

		System.out.println("Add elements to create a balanced tree ");
		
		treeBal.add("golf");
		treeBal.add("sierra");
		treeBal.add("delta");
		treeBal.add("kilo");
		treeBal.add("oscar");
		treeBal.add("victor");
		
		System.out.println("Tree Structure: ");
		
		System.out.println(treeBal.toString());
	}
	
	@Test
	public void testImbalancedTree() {
	  UhBinaryTreeNode alpha = new UhBinaryTreeNode("alpha");
	  UhBinaryTree treeImbal = new UhBinaryTree(alpha);
	  
		System.out.println("Add elements to create a unbalanced tree ");

		treeImbal.add("bravo");
		treeImbal.add("charlie");
		treeImbal.add("delta");
		treeImbal.add("echo");
		treeImbal.add("foxtrot");
		treeImbal.add("golf");
		
		System.out.println("Tree Structure: ");

		System.out.println(treeImbal.toString());
	}
	
	@Test
	public void testNodeCountBal() {
		UhBinaryTreeNode mike = new UhBinaryTreeNode("mike");
		UhBinaryTree treeBal = new UhBinaryTree(mike);

		System.out.println("Add elements to create a balanced tree");
		
		treeBal.add("golf");
		treeBal.add("sierra");
		
		assertEquals(1, treeBal.countNodes(mike.right, 0)); //Check count to the right of root.
		assertEquals(1, treeBal.countNodes(mike.left, 0)); //Check count to the left of root.
		System.out.println("The count on the right of the Balance tree is: " + treeBal.countNodes(mike.right, 0));
		System.out.println("The count on the left of the Balance tree is: " + treeBal.countNodes(mike.left, 0));

		treeBal.add("delta");
		treeBal.add("kilo");
		
		assertEquals(1, treeBal.countNodes(mike.right, 0));
		assertEquals(3, treeBal.countNodes(mike.left, 0));
		System.out.println("The count on the right of the Balance tree is: " + treeBal.countNodes(mike.right, 0));
		System.out.println("The count on the left of the Balance tree is: " + treeBal.countNodes(mike.left, 0));

		treeBal.add("oscar");
		treeBal.add("victor");
		
		assertEquals(3, treeBal.countNodes(mike.right, 0));
		assertEquals(3, treeBal.countNodes(mike.left, 0));
		assertEquals(7, treeBal.countNodes(mike, 0));
		System.out.println("The count on the right of the Balance tree is: " + treeBal.countNodes(mike.right, 0));
		System.out.println("The count on the left of the Balance tree is: " + treeBal.countNodes(mike.left, 0));
	}
	
	@Test
	public void testNodeCountImbal() {
		UhBinaryTreeNode alpha = new UhBinaryTreeNode("alpha");
		UhBinaryTree treeImbal = new UhBinaryTree(alpha);
		
		System.out.println("Add elements to create a unbalanced tree");
		
		treeImbal.add("bravo");
		treeImbal.add("charlie");
		
		assertEquals(2, treeImbal.countNodes(alpha.right, 0)); //Check count to the right of root.
		assertEquals(0, treeImbal.countNodes(alpha.left, 0)); //Check count to the left of root.
		System.out.println("The count on the right of the Imbalance tree is: " + treeImbal.countNodes(alpha.right, 0));
		System.out.println("The count on the left of the Imbalance tree is: " + treeImbal.countNodes(alpha.left, 0));

		treeImbal.add("delta");
		treeImbal.add("echo");
		
		assertEquals(4, treeImbal.countNodes(alpha.right, 0));
		assertEquals(0, treeImbal.countNodes(alpha.left, 0));
		System.out.println("The count on the right of the Imbalance tree is: " + treeImbal.countNodes(alpha.right, 0));
		System.out.println("The count on the left of the Imbalance tree is: " + treeImbal.countNodes(alpha.left, 0));

		treeImbal.add("foxtrot");
		treeImbal.add("golf");
		
		assertEquals(6, treeImbal.countNodes(alpha.right, 0));
		assertEquals(0, treeImbal.countNodes(alpha.left, 0));
		assertEquals(7, treeImbal.countNodes(alpha, 0));
		System.out.println("The count on the right of the Imbalance tree is: " + treeImbal.countNodes(alpha.right, 0));
		System.out.println("The count on the left of the Imbalance tree is: " + treeImbal.countNodes(alpha.left, 0));
	}
}
