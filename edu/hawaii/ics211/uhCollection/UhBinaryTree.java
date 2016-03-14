package edu.hawaii.ics211.uhCollection;

/** Class for a Binary Tree that stores type <E> objects.
 * @author Blake Larson
 * @param <E> The Binary Tree is type <E>.
 */
public class UhBinaryTree<E extends Comparable<E>> {
	
  /** Return the value from the public add method.	
   */
  protected boolean addReturn;
  
  /** The root of the binary tree.
   */
  protected UhBinaryTreeNode<E> root;

  /** Class to encapsulate a tree node.
   * @author Blake Larson
   * @param <E> Node is type <E>.
   */
  public static class UhBinaryTreeNode<E> {
	  
    /** The information stored in this node.
     */
    E data = null;
      
    /** Reference to the left child.
     */
    UhBinaryTreeNode<E> left;
      
    /** Reference to the right child.
     */
    UhBinaryTreeNode<E> right;
      
    /** Construct a node with given data and no children.
     * @param data The data to store in this node.
     */
    public UhBinaryTreeNode(E data) {
      this.data = data;
      left = null;
   	  right = null;
    }
      
    /** Return a string representation of the node.
     * @return A string representation of the data fields.
     */
    public String toString() {
	  return data.toString();
    }
  }
  
    /** No-parameter constructor that sets the data field root to null.
     */
    public UhBinaryTree() {
    	root = null;
    }
    
    /** Constructor that takes a Node as a parameter.
     * @param root The Node.
     */
    protected UhBinaryTree(UhBinaryTreeNode<E> root) {
      this.root = root;
    }
    
    /** Constructs a new binary tree with data in its root leftTree .
     *  as its left subtree and rightTree as its right subtree.
     * @param data The node.
     * @param leftTree Left node of the root.
     * @param rightTree Right node of the root.
     */
    public UhBinaryTree(E data, UhBinaryTree<E> leftTree, UhBinaryTree<E> rightTree) {
    	root = new UhBinaryTreeNode<E>(data);
    	if (leftTree != null) {
    		root.left = leftTree.root;
    	} else {
    		root.left = null;
    	}
    	if (rightTree != null) {
    		root.right = rightTree.root;
    	} else {
    		root.right = null;
    	}
    }
  
    /** Starter method add.
     *  The object to insert must implement the Comparable interface.
     * @param item The object being inserted.
     * @return TRUE if the object is inserted, 
     * 		   FALSE if the object already exists in the tree.
     */
    public boolean add(E item) {
    	root = add(root, item);
    	System.out.println("Adding " + item);
    	return addReturn;
    }
  
    /** Recursive add method.
     *  The data field addReturn is set 
     *  TRUE if the item is added to the tree,
     *  FALSE if the item is already in the tree.
     * @param localRoot The local root of the subtree.
     * @param item The object to be inserted.
     * @return The new local root that now contains the inserted item.
     */
    private UhBinaryTreeNode <E> add(UhBinaryTreeNode<E> localRoot, E item) {
    	if(localRoot == null) {
    		addReturn = true;
    		return new UhBinaryTreeNode<E> (item);
    	} else if (item.compareTo(localRoot.data) == 0) {
    		addReturn = false;
    		return localRoot;
    	} else if (item.compareTo(localRoot.data) < 0) {
    		localRoot.left = add(localRoot.left, item);
    		return localRoot;
    	} else {
    		localRoot.right = add(localRoot.right, item);
    		return localRoot;
    	}
    }
    
    /** Creates a StringBuilder and calls preOrderTraverse passing 
     *  root and 1 as arguments.
     */
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	preOrderTraverse(root, 1, sb);
    	return sb.toString();
    }
    
    /** Perform a preorder traversal of the binary tree.
     * @param node The local root.
     * @param depth The depth.
     * @param sb The String buffer to save the output.
     */
    private void preOrderTraverse(final UhBinaryTreeNode<E> node, final int depth, final StringBuilder sb) {
    	for (int i = 1; i < depth; i++) {
    		sb.append("  ");
    	}
    	if (node == null) {
    		sb.append("null\n");
    	} else {
    		sb.append(node.toString());
    		sb.append("\n");
    		preOrderTraverse(node.left, depth + 1, sb);
    		preOrderTraverse(node.right, depth + 1, sb);
    	}
    }
    
    /** Performs a traversal of the binary tree while counting all non-null nodes.
     * @param node The starting node for the count.
     * @param depth The starting depth for the count.
     * @return The total node count of the binary tree.
     */
    public int countNodes(UhBinaryTreeNode<E> node, int depth){
    	int count = 0;

    	if(node == null){
    		return 0;
    	} else {
    		count++;
    		return (count + countNodes(node.left, depth + 1) + countNodes(node.right, depth + 1)); //Recursion
    	}
    }
}
