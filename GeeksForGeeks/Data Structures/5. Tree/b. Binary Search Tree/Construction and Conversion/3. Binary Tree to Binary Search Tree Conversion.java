/***

Given a Binary Tree, convert it to a Binary Search Tree. The conversion must be done in such a way that keeps the original structure of Binary Tree.
Examples.

Example 1
Input:
          10
         /  \
        2    7
       / \
      8   4
Output:
          8
         /  \
        4    10
       / \
      2   7


Example 2
Input:
          10
         /  \
        30   15
       /      \
      20       5
Output:
          15
         /  \
       10    20
       /      \
      5        30

**/

/**
 * Algorithm:
 *
 * Following is a 3 step solution for converting Binary tree to Binary Search Tree.
 * 1) Create a temp array arr[] that stores inorder traversal of the tree. This step takes O(n) time.
 * 2) Sort the temp array arr[]. Using Heap Sort, Merge Sort or Quick Sort (Quick Sort Worst Case: O(n^2))
 * 3) Again do inorder traversal of tree and copy array elements to tree nodes one by one. This step takes O(n) time.
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class BinaryTree {

	private Node root;
	private Index index = new Index();

	BinaryTree() {
		root = null;
	}

	class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
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

	public int countNodes(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + countNodes(root.left) + countNodes(root.right);
	}

	public void storeInorder(Node root, int[] inOrder, Index i) {
		if (root == null) {
			return;
		}

		storeInorder(root.left, inOrder, index);
		inOrder[i.index++] = root.key;
		storeInorder(root.right, inOrder, index);
	}

	public void arrayToBst(int[] inOrder, Node root, Index index) {
		if (root == null) {
			return;
		}

		arrayToBst(inOrder, root.left, index);
		root.key = inOrder[index.index++];
		arrayToBst(inOrder, root.right, index);
	}

	public void binaryTreeToBST() {
		if (root == null) {
			return;
		}

		int n = countNodes(root);
		int[] temp = new int[n];

		storeInorder(root, temp, index); // O(n)

		Arrays.sort(temp); // O(n logn)

		index.index = 0;
		arrayToBst(temp, root, index); // O(n)
	}

	/* Modify as per requirement */
	public void makeTree() {
		root = new Node(10);
		root.left = new Node(30);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.right.right = new Node(5);
	}

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();

		tree.makeTree();
		tree.binaryTreeToBST();

		System.out.println("Inorder: \t");
		tree.inorder();
		System.out.println();
	}
}

/**
 * Complexity Analysis:
 *
 * Time Complexity: O(nlogn). This is the complexity of the sorting algorithm which we are using after
 *  first in-order traversal, rest of the operations take place in linear time.
 * Auxiliary Space: O(n). Use of data structure ‘array’ to store in-order traversal.
 */

// Code: https://ideone.com/wnzka0

// TODO: Convert the tree using O(height of tree) extra space.
