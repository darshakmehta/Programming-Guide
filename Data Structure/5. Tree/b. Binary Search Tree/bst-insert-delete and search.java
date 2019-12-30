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
	
	private void postorderTraversal(Node root) {
		if (root != null) {
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			System.out.print(root.key + " ");
		}
	}

	public void postorder() {
		postorderTraversal(root);
	}

	private Node searchNode(Node root, int key) {
		if (root == null)
			return null;
		if (root.key == key)
			return root;
		else if (key < root.key)
			return searchNode(root.left, key);
		else
			return searchNode(root.right, key);
	}
	
	public Node search(int key) {
		return searchNode(root, key);
	}

	public int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
	
	public Node deleteNode(Node root, int key) {
		if (root == null) 
			return root;
		if (key < root.key)
	        root.left = deleteNode(root.left, key);
		else if (key > root.key)
	        root.right = deleteNode(root.right, key);
        else {
        	if (root.left == null)
        		return root.right;
        	else if (root.right == null)
        		return root.left;
        	root.key = minValue(root.right);
        	
        	root.right = deleteNode(root.right, root.key);
        }
        return root;
	}

	public void delete(int key) {
		root = deleteNode(root, key);
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

		System.out.println("Inorder: \t");
		bst.inorder();
		System.out.println();
		
		System.out.println("Preorder: \t");
		bst.preorder();
		System.out.println();
		
		System.out.println("Postorder: \t");
		bst.postorder();
		System.out.println();
		
		Node x = bst.search(80);
		System.out.println("Searched key 80 " + (x != null ? "exists" : "does not exist"));

		x = bst.search(90); // x == null
		System.out.println("Searched key 90 " + (x != null ? "exists" : "does not exist"));

		bst.delete(30);

		System.out.println("Inorder: \t");
		bst.inorder();
		System.out.println();
	}	
}

// Code: https://ideone.com/yDPkiE