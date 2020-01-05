/***

Construct a Binary Search Tree from given postorder
Given postorder traversal of a binary search tree, construct the BST.

For example, if the given traversal is {1, 7, 5, 50, 40, 10}, then following tree should be constructed and root of the tree should be returned.

     10
   /   \
  5     40
 /  \      \
1    7      50

Input: 1 7 5 50 40 10
Output: 1 5 7 10 40 50

**/

/* Method 1 ( O(n^2) time complexity ) */
// Code: https://ideone.com/3eGQQX

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

	public Node constructBSTFromPostOrderUtil(int[] postOrder, int low, int high) {

		// Base Case
		if (low > high) {
			return null;
		}

		Node root = new Node(postOrder[high]); // First Element in postOrder[] is root

		// If only one element, return root
		if (low == high) {
			return root;
		}

		int i;
		for (i = high; i >= low; i--) {
			if (postOrder[i] < root.key) {
				break;
			}
		}

		root.left = constructBSTFromPostOrderUtil(postOrder, low, i);
		root.right = constructBSTFromPostOrderUtil(postOrder, i + 1, high - 1);

		return root;
	}

	public void constructBSTFromPostOrder(int[] postOrder, int size) {
		root = constructBSTFromPostOrderUtil(postOrder, 0, size - 1);
	}

	public static void main(String arg[]) {

		Scanner sc = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();
		int n = sc.nextInt();
		int[] postOrder = new int[n];

		for (int i = 0; i < n; i++) {
			postOrder[i] = sc.nextInt();
		}

		bst.constructBSTFromPostOrder(postOrder, n);

		System.out.println("Inorder: \t");
		bst.inorder();
		System.out.println();
		
	}
}


/* Method 2 ( O(n) time complexity ) */
// Code: https://ideone.com/C9FCE0

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

	class Index {
		int index;
		Index(int index) {
			this.index = index;
		}
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

	public Node constructBSTFromPostOrderUtil(int[] postOrder, Index postIndex, 
		int key, int min, int max, int size) {

		// Base Case
		if (postIndex.index < 0) {
			return null;
		}

		Node root = null;

		if (key > min && key < max) {

			root = new Node(key);
			postIndex.index -= 1;

			if (postIndex.index > 0) {

				root.right = constructBSTFromPostOrderUtil(postOrder, postIndex, 
					postOrder[postIndex.index], key, max, size);
				root.left = constructBSTFromPostOrderUtil(postOrder, postIndex, 
					postOrder[postIndex.index], min, key, size);
			}
		}

		return root;
	}

	public void constructBSTFromPostOrder(int[] postOrder, int size) {
		Index index = new Index(size - 1);
		root = constructBSTFromPostOrderUtil(postOrder, index, 
			postOrder[index.index], Integer.MIN_VALUE, Integer.MAX_VALUE, size);
	}

	public static void main(String arg[]) {

		Scanner sc = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();
		int n = sc.nextInt();
		int[] postOrder = new int[n];

		for (int i = 0; i < n; i++) {
			postOrder[i] = sc.nextInt();
		}

		bst.constructBSTFromPostOrder(postOrder, n);

		System.out.println("Inorder: \t");
		bst.inorder();
		System.out.println();
		
	}
}
