/***

Given a sorted array. Write a function that creates a Balanced Binary Search Tree using array elements.
Examples:

Input:  Array {1, 2, 3}
Output: A Balanced BST
     2
   /  \
  1    3 

Input: Array {1, 2, 3, 4}
Output: A Balanced BST
      3
    /  \
   2    4
 /
1

**/

/**

Algorithm
In the previous post, we discussed construction of BST from sorted Linked List. Constructing from sorted array in O(n) time is simpler as we can get the middle element in O(1) time. Following is a simple algorithm where we first find the middle node of list and make it root of the tree to be constructed.

1) Get the Middle of the array and make it root.
2) Recursively do same for left half and right half.
      a) Get the middle of left half and make it left child of the root
          created in step 1.
      b) Get the middle of right half and make it right child of the
          root created in step 1.

**/

// Code: https://ideone.com/4N8BHV

import java.util.*;
import java.lang.*;
import java.io.*;

class BalancedBST
{
	// Root node of BalancedBST
	private Node root;

	BalancedBST() {
		this.root = null;
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

	public Node sortedArrToBalancedBSTUtil(int[] arr, int low, int high) {

		if (low > high)
			return null;
			
		
		int mid = (low + (high - low) / 2);

		Node node = new Node(arr[mid]);

		node.left = sortedArrToBalancedBSTUtil(arr, low, mid - 1);
		node.right = sortedArrToBalancedBSTUtil(arr, mid + 1, high);

		return node;
	}

	public void sortedArrToBalancedBST(int[] arr, int size) {
		root = sortedArrToBalancedBSTUtil(arr, 0, size - 1);
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
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt(); // Given sorted Array
		}

		BalancedBST bst = new BalancedBST();
		bst.sortedArrToBalancedBST(arr, n);

		System.out.println("Inorder: \t");
		bst.inorder();
		System.out.println();

		System.out.println("Preorder: \t");
		bst.preorder();
		System.out.println();
	}
}

/**

Time Complexity: O(n)
Following is the recurrance relation for sortedArrayToBST().

  T(n) = 2T(n/2) + C
  T(n) -->  Time taken for an array of size n
   C   -->  Constant (Finding middle of array and linking root to left 
                      and right subtrees take constant time) 
The above recurrence can be solved using Master Theorem as it falls in case 1.

**/
