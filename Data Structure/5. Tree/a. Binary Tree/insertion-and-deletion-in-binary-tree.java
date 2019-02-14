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
			root = new Node(key);
			return root;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
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

	/*public void deleteNode(Node root, int key) {

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		Node toDeleteNode = null;
		Node temp = null;
		while (!queue.isEmpty()) {
			temp = queue.peek();
			queue.remove();

			if (temp.data == key) {
				toDeleteNode = temp;
			} 
			if (temp.left != null) {
				queue.push(temp.left);
			}
			if (temp.right != null) {
				queue.push(temp.right);
			}
		}
		int x = temp.data;
		toDeleteNode.data = x;
	}

	public void delete(int key) {
		deleteNode(root, key);
	}*/

	public static void main(String arg[]) {
		BinaryTree tree = new BinaryTree();
		tree.insert(10);
		tree.insert(11);
		tree.insert(9);
		tree.insert(7);
		tree.insert(15);
		tree.insert(8);
		tree.insert(12);
		//tree.delete(12);
		tree.inOrder();
	}
}

/* Output: 7 11 15 10 8 9 12 */

/***

TODO: Complete the implementation of Deletion of Node in Binary Tree

***/