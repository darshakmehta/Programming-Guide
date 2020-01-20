/***
Given root of binary search tree and K as input, find K-th smallest element in BST.
Method 1: Using Inorder Traversal.
Method 2: Augmented  Tree Data Structure.
**/

// Method 1: Code: https://ideone.com/iDB0Gc

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
		int index = 1;
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

	public int kthSmallestElementUtil(Node node, int k, Index index) {
		// if (node != null) {
		// 	kthSmallestElementUtil(node.left, k, index);
		// 	if (k == index.index++) 
		// 		return node.key;
		// 	kthSmallestElementUtil(node.right, k, index);
		// }
		// return -1;
		// Note: Recursion is not helpful so go for Iteration based using Stack

		Stack<Node> stack = new Stack<Node>();

		// Add left extreme subtree
		while (node != null) {
			stack.push(node);
			node = node.left;
		}

		while (!stack.isEmpty()) {
			Node temp = stack.pop();
			if (k == index.index++) {
				node = temp;
				break;
			}

			if (temp.right != null) {
				temp = temp.right;
				// Add left substree of right
				while (temp != null) {
					stack.push(temp);
					temp = temp.left;
				}
			}
		}
		return node.key;
	}

	public int kthSmallestElement(int k) {
		Index index = new Index();
		return kthSmallestElementUtil(root, k, index);
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
		int k = 3;

		System.out.println(k + "th/rd/nd/st smallest element is " + bst.kthSmallestElement(k));
	}	
}

/***
		 50
		/  \
	   /  	\
	  30     70
	 /	\	/  \
	20	40 60	80
**/
