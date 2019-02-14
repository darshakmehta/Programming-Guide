import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class Tree {
	Node root;

	void printLevelOrder() { // Running time is O(n)
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.print(temp.data + " ");

			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);
		}
	}

	public static void main(String args[]) 
    {
        /* creating a binary tree and entering 
         the nodes */
        Tree tree = new Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        System.out.println("Level order traversal of binary tree is - ");
        tree.printLevelOrder();
    }
}

/***

TODO:

1. Recursive implementation


***/