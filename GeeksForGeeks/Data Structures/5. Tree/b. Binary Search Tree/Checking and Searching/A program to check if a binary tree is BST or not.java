/***
A binary search tree (BST) is a node based binary tree data structure which has the following properties.
• The left subtree of a node contains only nodes with keys less than the node’s key.
• The right subtree of a node contains only nodes with keys greater than the node’s key.
• Both the left and right subtrees must also be binary search trees.

From the above properties it naturally follows that:
• Each node (item in the tree) has a distinct key.
**/

// Code: https://ideone.com/zGeREJ

import java.util.*;
import java.lang.*;
import java.io.*;

class Index {
	int index = 0;
}

class BinarySearchTree {

	// Root node of BST
	Node root;
	Index index = new Index();

	BinarySearchTree() {
		root = null;
	}

	class Node{
		int key;
		Node left, right;
		
		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	void insert(int key) {
		root = insertNode(root, key);
	}
	
	public Node insertNode(Node root, int key) {
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
	
	void inorder() {
		inorderTraversal(root);
	}
	
	public void inorderTraversal(Node root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.print(root.key + " ");
			inorderTraversal(root.right);
		}
			
	}

	public int minValue(Node root)
    {
        int minv = root.key;
        while (root.left != null)
        {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    public Node createMinimalTree(int a[], int low, int high) {
    	if (low > high)
    		return null;
    	int mid = low + (high - low) / 2;
    	Node node = new Node(a[mid]);
    	node.left = createMinimalTree(a, low, mid - 1);
    	node.right = createMinimalTree(a, mid + 1, high);

    	return node;
    }
    
    public boolean isBSTUtil(Node root, int min, int max) {
    	if (root == null) // Empty tree is BST
    		return true;
    	if (root.key < min || root.key > max)
    		return false;
    	return isBSTUtil(root.left, min, root.key - 1)
    		&& isBSTUtil(root.right, root.key + 1, max);
    }

    // TC: O(n)
    public boolean isBST() {
    	return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    	// return isBSTUtilUsingPointers(root, null, null);
    }

    public boolean isBSTUtilUsingPointers(Node root, Node left, Node right) {
    	if (root == null) // Empty tree is BST
    		return true;
    	if (left != null && root.key < left.key)
    		return false;
    	if (right != null && root.key > right.key)
    		return false;
    	return isBSTUtilUsingPointers(root.left, left, root) 
    		&& isBSTUtilUsingPointers(root.right, root, right);	
    }

    // TC: O(n)
    public boolean isBSTPointers() {
    	return isBSTUtilUsingPointers(root, null, null);
    }

    public static void isBSTUtilUsingInOrderAndTempArray(int[] arr, Node root, Index index) {
    	if (root == null)
    		return;

    	isBSTUtilUsingInOrderAndTempArray(arr, root.left, index);
    	arr[index.index++] = root.key;
    	isBSTUtilUsingInOrderAndTempArray(arr, root.right, index);
    }

    public boolean checkIfArrIsSorted(int[] arr, int n) {
    	for (int i = 0; i < n - 1; i++) {
    		if (arr[i] > arr[i + 1]) {
    			return false;
    		}
    	}
    	return true;
    }

    // TC: O(n)
    public boolean isBSTInorder(int n) {
    	int[] arr = new int[n];
    	isBSTUtilUsingInOrderAndTempArray(arr, root, index);
    	return checkIfArrIsSorted(arr, n);
    }

    
    public boolean isBSTInorderUsingPrevNodeUtil(Node node) {
    	if (node == null)
    		return true;

    	if (!isBSTInorderUsingPrevNodeUtil(node.left)) {
    		return false;
    	}

    	if (prev != null && node.key <= prev.key) {
    		return false;
    	}

    	prev = node;
    	return isBSTInorderUsingPrevNodeUtil(node.right);
    }

    // TC: O(n) with no Extra temp array

	Node prev;
    public boolean isBSTInorderUsingPrevNode() { // TODO: Solve more examples
    	prev = null;
    	return isBSTInorderUsingPrevNodeUtil(root);
    }
    
	public static void main(String arg[]) {
		BinarySearchTree bst = new BinarySearchTree();
		int a[] = {1, 2, 5, 18, 19, 25, 47, 58, 96, 100, 121, 190};
		bst.root = bst.createMinimalTree(a, 0, a.length - 1);
		bst.inorder();
		System.out.println();
		System.out.println(bst.isBST());
		System.out.println(bst.isBSTPointers());
		System.out.println(bst.isBSTInorder(a.length));
		System.out.println(bst.isBSTInorderUsingPrevNode());
	}	
}
