/***

Convert a BST to a Binary Tree such that sum of all greater keys is added to every key
Given a Binary Search Tree (BST), convert it to a Binary Tree such that every key of the original BST is changed to key plus sum of all greater keys in BST.
Examples:

Input: Root of following BST
              5
            /   \
           2     13

Output: The given BST is converted to following Binary Tree
              18
            /   \
          20     13
Solution: Do reverse Inoorder traversal. Keep track of the sum of nodes visited so far. Let this sum be sum. For every node currently being visited, first add the key of this node to sum, i.e. sum = sum + node->key. Then change the key of current node to sum, i.e., node->key = sum.
When a BST is being traversed in reverse Inorder, for every key currently being visited, all keys that are already visited are all greater keys.

**/

// Code: https://ideone.com/A8BSc6

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
		root.key = sum.sum;
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
