/***
Given an array of size n. The problem is to check whether the given array can represent the level order traversal of a Binary Search Tree or not

Examples:

Input : arr[] = {7, 4, 12, 3, 6, 8, 1, 5, 10}
Output : Yes
For the given arr[] the Binary Search Tree is:
         7        
       /    \       
      4     12      
     / \    /     
    3   6  8    
   /   /    \
  1   5     10

Input : arr[] = {11, 6, 13, 5, 12, 10}
Output : No
The given arr[] do not represent the level
order traversal of a BST.

**/

// Code: https://ideone.com/f4ADZm

import java.util.*;
import java.lang.*;
import java.io.*;

class BinarySearchTree
{
	static class Node {
		private int data;
		private int min, max;
		
		public Node(int data, int min, int max) {
			this.data = data;
			this.min = min;
			this.max = max;
		}
	}

	private static boolean levelOrderIsOfBSTUtil(int[] arr, int n) {
		Queue<Node> queue = new LinkedList<Node>();

		int i = 0;
		Node new_node = new Node(arr[i++], Integer.MIN_VALUE, Integer.MAX_VALUE);
		queue.add(new_node);
		
		while (i != n && !queue.isEmpty()) {
			Node temp = queue.poll();

			// check whether there are more elements  
	        // in the arr[] and arr[i] can be left child  
	        // of 'temp.data' or not 
	        if (i < n && (arr[i] < (int)temp.data && arr[i] > (int)temp.min)) {
	        	new_node = new Node(arr[i++], temp.min, temp.data);
	        	queue.add(new_node);
	        }

	        // check whether there are more elements  
	        // in the arr[] and arr[i] can be right child  
	        // of 'temp.data' or not  
	        if (i < n && (arr[i] > (int)temp.data && arr[i] < (int)temp.max)) {
	        	new_node = new Node(arr[i++], temp.data, temp.max);
	        	queue.add(new_node);
	        }
		}

		// given array represents level 
    	// order traversal of BST 
		if (i == n) {
			return true;
		}

		return false;
	}

	public static boolean levelOrderIsOfBST(int[] arr, int n) {
		// if tree is empty
		if (n == 0)
			return true;

		return levelOrderIsOfBSTUtil(arr, n);
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println("Is Given BST => Level Order Traversal " + levelOrderIsOfBST(arr, n));
	}
}


// Time Complexity: O(n)
