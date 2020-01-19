/***
Given an array of numbers, return true if given array can represent preorder traversal of a Binary Search Tree, else return false. Expected time complexity is O(n).

Examples:

Input:  pre[] = {2, 4, 3}
Output: true
Given array can represent preorder traversal
of below tree
    2
     
      4
     /
    3

Input:  pre[] = {2, 4, 1}
Output: false
Given array cannot represent preorder traversal
of a Binary Search Tree.

Input:  pre[] = {40, 30, 35, 80, 100}
Output: true
Given array can represent preorder traversal
of below tree
     40
   /   
 30    80 
        
  35     100 


Input:  pre[] = {40, 30, 35, 20, 80, 100}
Output: false
Given array cannot represent preorder traversal
of a Binary Search Tree.

An Efficient Solution can solve this problem in O(n) time. The idea is to use a stack. This problem is similar to Next (or closest) Greater Element problem. Here we find the next greater element and after finding next greater, if we find a smaller element, then return false.

1) Create an empty stack.
2) Initialize root as INT_MIN.
3) Do following for every element pre[i]
     a) If pre[i] is smaller than current root, return false.
     b) Keep removing elements from stack while pre[i] is greater
        then stack top. Make the last removed item as new root (to
        be compared next).
        At this point, pre[i] is greater than the removed root
        (That is why if we see a smaller element in step a), we 
        return false)
     c) push pre[i] to stack (All elements in stack are in decreasing
        order)  

**/


// Code: https://ideone.com/8AeZjw

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static boolean canPreOrderRepresentBST(int[] preOrder, int n) {
		Stack<Integer> stack = new Stack<Integer>();

		int root = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			// If we find a node who is on right side 
            // and smaller than root, return false 
            if (preOrder[i] < root)
            	return false;

            // If preOrder[i] is in right subtree of stack top, 
            // Keep removing items smaller than preOrder[i] 
            // and make the last removed item as new 
            // root.
            while (!stack.isEmpty() && stack.peek() < preOrder[i]) {
            	root = stack.pop();
            }

            // At this point either stack is empty or 
            // preOrder[i] is smaller than root, push preOrder[i] 
            stack.push(preOrder[i]);
		}
		return true;
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] preOrder = new int[n];

		for (int i = 0; i < n; i++) {
			preOrder[i] = sc.nextInt();
		}

		if (canPreOrderRepresentBST(preOrder, n)) {
			System.out.println("Given preorder can represent BST");
		} else {
			System.out.println("Given preorder can not represent BST");
		}
	}
}

// TC: O(n)
