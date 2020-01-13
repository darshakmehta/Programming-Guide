/***
This is quite simple. Just traverse the node from root to right recursively until right is NULL. The node whose right is NULL is the node with maximum value. 
**/

// Code: https://ideone.com/N5bE1S

import java.util.*;
import java.lang.*;
import java.io.*;

class BinarySearchTree {

	// Root node of BST
	private Node root;
	
	BinarySearchTree() {
		root = null;
	}
	
	class Node {
		private int key;
		private Node left, right;
		
		public Node(int item) {
			this.key = item;
			this.left = this.right = null;
		}
	}

	private Node insertNode(Node root, int key) {
		if (root == null) {
		    root = new Node(key);
		    return root;
		}
		
		if (key < root.key) 
		    root.left = insertNode(root.left, key);
		else if (key > root.key)
		    root.right = insertNode(root.right, key);
		return root;
	}

	public void insert(int key) {
		root = insertNode(root, key);
	}

	public int findMaximumUtil(Node root) {
		if (root == null) 
			return -1;

		if (root.right != null)
			return findMaximumUtil(root.right);
		return root.key;
	}
	
	public int findMaximum() {
		return findMaximumUtil(root);
	}
	
	public static void main(String arg[]) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(70);
		bst.insert(60);
		bst.insert(80);

		System.out.println("The node with Max Value is " + bst.findMaximum());
	}	
}

// Time Complexity: O(n) Worst case happens for right skewed trees.
