/***
Given a BST, transform it into greater sum tree where each node contains sum of all nodes greater than that node.

Method 1 (Naive):
This method doesn’t require the tree to be a BST. Following are steps.
1. Traverse node by node(Inorder, preorder, etc.)
2. For each node find all the nodes greater than that of the current node, sum the values. Store all these sums.
3. Replace each node value with their corresponding sum by traversing in the same order as in Step 1.
This takes O(n^2) Time Complexity.

Method 2 (Using only one traversal)
By leveraging the fact that the tree is a BST, we can find an O(n) solution. The idea is to traverse BST in reverse inorder. Reverse inorder traversal of a BST gives us keys in decreasing order. Before visiting a node, we visit all greater nodes of that node. While traversing we keep track of sum of keys which is the sum of all the keys greater than the key of current node.
**/

/* Method 2: TC: O(n) time */

// Code: 

import java.util.*;
import java.lang.*;
import java.io.*;

class BinarySearchTree
{
	// Root node of BST
	private Node root;
	private Sum sum = new Sum();

	BinarySearchTree() {
		this.root = null;
	}
	
	class Sum {
		int sum = 0;
	}

	class Node {
		private int key;
		private Node left, right;

		public Node() { }

		public Node(int key) {
			this.key = key;
			this.left = this.right = null;
		}
	}

	public void bstToGreaterSumTreeUtil(Node root, Sum sum) {
		if (root == null)
			return;

		bstToGreaterSumTreeUtil(root.right, sum);
		sum.sum += root.key;
		root.key = sum.sum - root.key;
		bstToGreaterSumTreeUtil(root.left, sum);
	}

	public void bstToGreaterSumTree() {
		bstToGreaterSumTreeUtil(root, sum);
	}

	public void makeBST() {
		root = new Node(11);
		root.left = new Node(2); 
	    root.right = new Node(29); 
	    root.left.left = new Node(1); 
	    root.left.right = new Node(7); 
	    root.right.left = new Node(15); 
	    root.right.right = new Node(40); 
	    root.right.right.left = new Node(35); 
	}

	private void inorderTraversal(Node root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.print(root.key + " ");
			inorderTraversal(root.right);
		}
	}

	public void inorder() {
		inorderTraversal(root);
	}

	private void preorderTraversal(Node root) {
		if (root != null) {
			System.out.print(root.key + " ");
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
	}

	public void preorder() {
		preorderTraversal(root);
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		BinarySearchTree bst = new BinarySearchTree();
		bst.makeBST();

		bst.bstToGreaterSumTree();

		System.out.println("Inorder: \t");
		bst.inorder();
		System.out.println();

		System.out.println("Preorder: \t");
		bst.preorder();
		System.out.println();
	}
}

// TC: O(n)
