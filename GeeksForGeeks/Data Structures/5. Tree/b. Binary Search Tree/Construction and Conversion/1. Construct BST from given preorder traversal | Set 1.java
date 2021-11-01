/***

Given preorder traversal of a binary search tree, construct the BST.

For example, if the given traversal is {10, 5, 1, 7, 40, 50}, then the output should be inorder traversal of following BST.
     10
   /   \
  5     40
 /  \      \
1    7      50

Input: {10, 5, 1, 7, 40, 50}
Output: 1, 5, 7, 10, 40, 50


**/

/* Method 1 ( O(n^2) time complexity ) */
// Code: https://ideone.com/e9nwnI

import java.util.*;
import java.lang.*;
import java.io.*;

class BinarySearchTree {

	// Root node of BST
	private Node root;
	Index index = new Index();

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
		int index = 0;
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

	public Node constructBSTFromPreOrderUtil(int[] preOrder, Index preIndex, int low, int high, int size) {
		// Base Case
		if (preIndex.index >= size || low > high) {
			return null;
		}

		Node root = new Node(preOrder[preIndex.index]); // First Element in preOrder[] is root
		preIndex.index += 1;

		// If only one element, return root
		if (low == high) {
			return root;
		}

		int i;
		for (i = low; i <= high; i++) {
			if (preOrder[i] > root.key) {
				break;
			}
		}

		root.left = constructBSTFromPreOrderUtil(preOrder, preIndex, preIndex.index, i - 1, size);
		root.right = constructBSTFromPreOrderUtil(preOrder, preIndex, i, high, size);

		return root;
	}

	public void constructBSTFromPreOrder(int[] preOrder, int size) {
		root = constructBSTFromPreOrderUtil(preOrder, index, 0, size - 1, size);
	}

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();
		int n = sc.nextInt();
		int[] preOrder = new int[n];

		for (int i = 0; i < n; i++) {
			preOrder[i] = sc.nextInt();
		}

		bst.constructBSTFromPreOrder(preOrder, n);

		System.out.println("Inorder: \t");
		bst.inorder();
		System.out.println();
	}
}

/* Method 2 ( O(n) time complexity ) */
/**
 * We save the iteration of finding next greater element from Method 1 each time we split our tree using MIN, MAX value.
 */
// Code: https://ideone.com/7hV9Nz

import java.util.*;
import java.lang.*;
import java.io.*;

class BinarySearchTree {

	// Root node of BST
	private Node root;
	Index index = new Index();

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
		int index = 0;
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

	public Node constructBSTFromPreOrderUtil(int[] preOrder, Index preIndex, int key, int min, int max, int size) {
		// Base Case
		if (preIndex.index >= size) {
			return null;
		}

		Node root = null;

		if (key > min && key < max) {

			root = new Node(key);
			preIndex.index += 1;

			if (preIndex.index < size) {
				root.left = constructBSTFromPreOrderUtil(preOrder, preIndex, preOrder[preIndex.index], min, key, size);
				root.right = constructBSTFromPreOrderUtil(preOrder, preIndex, preOrder[preIndex.index], key, max, size);
			}
		}
		return root;
	}

	public void constructBSTFromPreOrder(int[] preOrder, int size) {
		root = constructBSTFromPreOrderUtil(preOrder, index, preOrder[0], Integer.MIN_VALUE, Integer.MAX_VALUE, size);
	}

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();
		int n = sc.nextInt();
		int[] preOrder = new int[n];

		for (int i = 0; i < n; i++) {
			preOrder[i] = sc.nextInt();
		}

		bst.constructBSTFromPreOrder(preOrder, n);

		System.out.println("Inorder: \t");
		bst.inorder();
		System.out.println();
	}
}

/* Method 3 ( O(n^2) time complexity ) */
/**
 * Use recursion to insert elements in BST. Refer insertNode().
 */
