/***
Find k-th smallest element in BST (Order Statistics in BST)
Given root of binary search tree and K as input, find K-th smallest element in BST.

Method 2: Augmented  Tree Data Structure

The idea is to maintain rank of each node. We can keep track of elements in a subtree of any node while building the tree. Since we need K-th smallest element, we can maintain number of elements of left subtree in every node.

Assume that the root is having N nodes in its left subtree. If K = N + 1, root is K-th node. If K < N, we will continue our search (recursion) for the Kth smallest element in the left subtree of root. If K > N + 1, we continue our search in the right subtree for the (K – N – 1)-th smallest element. Note that we need the count of elements in left subtree only.

Time complexity: O(h) where h is height of tree.

Algorithm:

start:
if K = root.leftElement + 1
   root node is the K th node.
   goto stop
else if K > root.leftElements
   K = K - (root.leftElements + 1)
   root = root.right
   goto start
else
   root = root.left
   goto start

stop:
**/

// Code: https://ideone.com/FifaN4

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
		private int lCount;
		private Node left, right;

		public Node(int item, int lCount) {
			this.key = item;
			this.lCount = lCount;
			this.left = this.right = null;
		}
	}

	private void inorderTraversal(Node root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.println(root.key + " " + root.lCount);
			inorderTraversal(root.right);
		}
	}

	public void inorder() {
		inorderTraversal(root);
	}

	// Iterative insertion
	private Node insertNode(Node root, Node node) {
		Node traverse = root;
		Node currentParent = root;

		// Traverse till appropriate node
		while (traverse != null) {
			currentParent = traverse;

			if (node.key < traverse.key) {
				/* We are branching to left subtree
				increment node count */
				traverse.lCount++;
				traverse = traverse.left;
			} else {
				/* right subtree */
				traverse = traverse.right;
			}
		}

		/* If the tree is empty, make it as root node */
		if (root == null) {
			root = node;
		} else if (node.key < currentParent.key) {
			currentParent.left = node;
		} else {
			currentParent.right = node;
		}

		return root;
	}

	private Node createBSTUtil(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			Node new_node = new Node(arr[i], 0);
			root = insertNode(root, new_node);
		}
		return root;
	}

	public void createBST(int[] arr, int n) {
		root = createBSTUtil(arr, n);
	}

	// Iterative Solution
	public int kthSmallestElementUtil(Node node, int k) {
		int result = -1;

		Node traverse = root;

		/* Go to k-th smallest */
		while (traverse != null) {
			if ((traverse.lCount + 1) == k) {
				result = traverse.key;
				break;
			} else if (k > traverse.lCount) {
				/*  There are less nodes on left subtree
				    Go to right subtree */
				k = k - (traverse.lCount + 1);
				traverse = traverse.right;
			} else {
				/* The node is on left subtree */
				traverse = traverse.left;
			}
		}
		return result;
	}

	// Recursive Solution
	public int kthSmallestElementUtilRecursive(Node node, int k) {
		if (k == (node.lCount + 1)) {
			return node.key;
		} else if (k <= node.lCount) {
			return kthSmallestElementUtilRecursive(node.left, k);
		} else {
			return kthSmallestElementUtilRecursive(node.right, (k - (node.lCount + 1)));
		}
	}

	public int kthSmallestElement(int k) {
		return kthSmallestElementUtil(root, k);
	}

	public static void main(String arg[]) {
		BinarySearchTree bst = new BinarySearchTree();
		int[] arr = {50, 30, 20, 40, 70, 60, 80};
		bst.createBST(arr, arr.length);
		// bst.inorder();
		int k1 = 3;
		int k2 = 6;

		System.out.println(k1 + "th/rd/nd/st smallest element is " + bst.kthSmallestElement(k1));
		System.out.println(k2 + "th/rd/nd/st smallest element is " + bst.kthSmallestElement(k2));
	}
}

// Time complexity: O(h) where h is height of tree.
