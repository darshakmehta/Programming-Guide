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
		System.out.print(root.data + " ");
		inOrderTraversal(root.right);
	}

	public void inOrder() {
		inOrderTraversal(root);
	}

	public Node insertNode(Node root, int key) {
		if(root == null) {
			Node new_node = new Node(key);
			root = new_node;
			return root;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while(!queue.isEmpty()) {
			Node temp = queue.peek();
			queue.remove();

			if(temp.left == null) {
				temp.left = new Node(key);
				break;
			} else {
				queue.add(temp.left);
			}
			if(temp.right == null) {
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

	//Modification of BFS
	public ArrayList<LinkedList<Node>> createLevelLinkedList(Node root) {
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();

		/* Visit the root */
		LinkedList<Node> current = new LinkedList<Node>();
		if(root != null) {
			current.add(root);
		}

		while(current.size() > 0) {
			result.add(current); //Add previous level
			LinkedList<Node> parents = current; //Go to next level
			current = new LinkedList<Node>(); 
			for(Node parent : parents) {
				/* Visit the children */
				if(parent.left != null) {
					current.add(parent.left);
				}
				if(parent.right != null) {
					current.add(parent.right);
				}
			}

		}
		return result;

	}
	/* Analysis: O(n) running time, space O(n) data */
	public ArrayList<LinkedList<Node>> createLevelLinkedList() {
		return createLevelLinkedList(root);
	}

	public void createLevelLinkedListDFS(Node root, ArrayList<LinkedList<Node>> lists, int level) {
		if(root == null)
			return; //base case

		LinkedList<Node> list = null;
		if(lists.size() == level) {
			list = new LinkedList<Node>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
			list.add(root);
			createLevelLinkedListDFS(root.left, lists, level + 1);
			createLevelLinkedListDFS(root.right, lists, level + 1);
	}

	public ArrayList<LinkedList<Node>> createLevelLinkedListDFS(Node root) {
		ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
		createLevelLinkedListDFS(root, lists, 0);
		return lists;
	}

	/* Analysis: O(n) running time, O(log n) recursive calls (in a balanced tree) and returns O(n) data */
	public ArrayList<LinkedList<Node>> createLevelLinkedListDFS() {
		return createLevelLinkedListDFS(root);
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
		ArrayList<LinkedList<Node>> list = tree.createLevelLinkedList(); //modification of BFS
		System.out.println(list.size());

		ArrayList<LinkedList<Node>> listDFS = tree.createLevelLinkedListDFS();
		System.out.println(listDFS.size());

	}
}

