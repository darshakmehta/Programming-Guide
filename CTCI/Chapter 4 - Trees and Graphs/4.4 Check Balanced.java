import java.util.*;
import java.lang.*;
import java.io.*;

class BinaryTree {
	Node root;

	BinaryTree() {
		this.root = null;
	}

	class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public void inOrderTraversal(Node root) {
		if (root == null)
			return;
		inOrderTraversal(root.left);
		System.out.print(root.data + " ");
		inOrderTraversal(root.right);
	}

	public void inOrder() {
		inOrderTraversal(root);
	}

	public Node insertNode(Node root, int key) {
		if (root == null) {
			Node new_node = new Node(key);
			root = new_node;
			return root;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while(!queue.isEmpty()) {
			Node temp = queue.peek();
			queue.remove();

			if (temp.left == null) {
				temp.left = new Node(key);
				break;
			} else {
				queue.add(temp.left);
			}
			if (temp.right == null) {
				temp.right = new Node(key);
				break;
			} else {
				queue.add(temp.right);
			}
		}
		return root;
	}

	public void insert(int key) {
		root = insertNode(root, key);
	}

	public int checkHeight(Node root) {
		if (root == null) return -1;

		int leftHeight = checkHeight(root.left);
		if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; //Pass error up

		int rightHeight = checkHeight(root.left);
		if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; //Pass error up

		int heighDiff = leftHeight - rightHeight;
		if (Math.abs(heighDiff) > 1) {
			return Integer.MIN_VALUE; // Found error -> pass it back
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}

 	}

	public boolean isBalanced(Node root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}

	public boolean isBalanced() {
		return isBalanced(root);
	}


	public static void main(String arg[]) {
		BinaryTree tree = new BinaryTree();
		tree.insert(10);
		tree.insert(11);
		tree.insert(9);
		tree.insert(7);
		tree.insert(15);
		tree.insert(8);
		tree.insert(12);
		tree.inOrder();
		System.out.println();
		System.out.println(tree.isBalanced());	

	}
}

