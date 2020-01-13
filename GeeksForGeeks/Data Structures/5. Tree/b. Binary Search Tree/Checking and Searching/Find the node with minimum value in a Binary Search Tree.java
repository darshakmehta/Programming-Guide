/***
This is quite simple. Just traverse the node from root to left recursively until left is NULL. The node whose left is NULL is the node with minimum value. 
**/

// Code: https://ideone.com/b21tqN

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

	public int findMinimumUtil(Node root) {
		if (root == null) 
			return -1;

		if (root.left != null)
			return findMinimumUtil(root.left);
		return root.key;
	}
	
	public int findMinimum() {
		return findMinimumUtil(root);
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

		System.out.println("The node with Min Value is " + bst.findMinimum());
	}	
}

// Time Complexity: O(n) Worst case happens for left skewed trees.
