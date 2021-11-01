/***
Construct BST from given preorder traversal | Set 2 | Iterative Based Solution (Stack)
For example, if the given traversal is {10, 5, 1, 7, 40, 50}, then the output should be inorder traversal of following BST.
     10
   /   \
  5     40
 /  \      \
1    7      50

Input: {10, 5, 1, 7, 40, 50}
Output: 1, 5, 7, 10, 40, 50

 **/

/**
 * Algorithm:
 * 1. Create an empty stack.
 * 2. Make the first value as root. Push it to the stack.
 * 3. Keep on popping while the stack is not empty and the next value is greater than stack’s top value.
 *  Make this value as the right child of the last popped node. Push the new node to the stack.
 * 4. If the next value is less than the stack’s top value, make this value as the left child of the stack’s top node.
 *  Push the new node to the stack.
 * 5. Repeat steps 2 and 3 until there are items remaining in pre[].
 */

// Code: https://ideone.com/cBdttd

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

	public void constructBSTFromPreOrderIterative(int[] preOrder, int size) {

		Stack<Node> stack = new Stack<Node>();
		root = new Node(preOrder[0]); // first element is root node
		stack.push(root);

		// Iterate through rest of the size-1 items of given preorder array
		for (int i = 1; i < size; i++) {
			Node temp = null;

			// Keep on popping while the next value is greater than stack's top value.
			while (!stack.isEmpty() && preOrder[i] > stack.peek().key) {
				temp = stack.pop();
			}

			// Make this greater value as the right child and push it to the stack
			if (temp != null) {
				temp.right = new Node(preOrder[i]);
				stack.push(temp.right);
			}

			// If the next value is less than the stack's top value,
            // make this value as the left child of the stack's top node. Push the new node to stack
			else {
				temp = stack.peek();
				temp.left = new Node(preOrder[i]);
				stack.push(temp.left);
			}
		}
	}

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();
		int n = sc.nextInt();
		int[] preOrder = new int[n];

		for (int i = 0; i < n; i++) {
			preOrder[i] = sc.nextInt();
		}

		bst.constructBSTFromPreOrderIterative(preOrder, n);

		System.out.println("Inorder: \t");
		bst.inorder();
		System.out.println();
	}
}

/**
 * Time Complexity: O(n). The complexity looks more from first look.
 * If we take a closer look, we can observe that every item is pushed and popped only once.
 * So at most 2n push/pop operations are performed in the main loops of constructTree().
 * Therefore, time complexity is O(n).
**/
