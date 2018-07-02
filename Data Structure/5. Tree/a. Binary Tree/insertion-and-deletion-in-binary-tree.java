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
		if(root == null)
			return;
		inOrderTraversal(root.left);
		System.out.println(root.key + " ");
		inOrderTraversal(root.right);
	}

	public void inOrder() {
		public void inOrderTraversal(root);
	}

	public void insertNode(Node root, int key) {
		if(root == null) {
			Npde new_node = new Node();
			root = new_node;
			return;
		}

		Queue<Node> queue = new LinkedList<Node>();
		q.add(root);

		while(!q.isEmpty()) {
			Node temp = q.peek();
			q.remove();

			if(temp.left == null) {
				temp.left = new Node(key);
			} else {
				q.add(temp.left);
			}
			if(temp.right == null) {
				temp.right = new Node(key);
			} else {
				q.add(temp.right);
			}
		}

	}

	public void insert(int key) {
		public void insertNode(root, key);
	}

	public static void main(String arg[]) {
		BinaryTree tree = new BinaryTree();
		tree.insert(10);

		tree.inOrder();
	}
}