import java.lang.*;
import java.io.*;
import java.util.*;

//Class for Tree node
class Node {

	int key;
	Node left, right;

	Node(int key) {
		this.key = key;
		left = right = null;
	}
}

// A class to represent a queue item. The queue is used to do Level
// order traversal. Every Queue item contains node and horizontal
class QueueLOT {
	Node node;
	int h; //horizontal distance

	QueueLOT(Node node, int h) {
		this.node = node;
		this.h = h;
	}
}

class Tree {
	Node root;

	Tree() {
		root = null;
	}

	Tree(Node root) {
		this.root = root;
	}

	public void printTopView() { //Running time is O(n)
		//base case
		if(root == null) {
			return;
		}
		//Create an empty hashset
		HashSet<Integer> set = new HashSet<Integer>();

		//Create a queue and add root
		Queue<QueueLOT> queue = new LinkedList<QueueLOT>();
		queue.add(new QueueLOT(root, 0));

		//Standard BFS or level order traversal loop
		while(!queue.isEmpty()) {

			//Remove the front item and get its details
			QueueLOT q = queue.remove();
			int hd = q.h;
			Node n = q.node;

			//If this is the first node at its horizontal distance, then this node is in the top view
			if(!set.contains(hd)) {
				set.add(hd);
				System.out.print(n.key + " ");
			}

			//Enqueue left and right children of current node
			if(n.left != null)
				queue.add(new QueueLOT(n.left, hd - 1));
			if(n.right != null)
				queue.add(new QueueLOT(n.right, hd + 1));

		}
	}

}

class TopView {

	public static void main(String arg[]) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);
        Tree t = new Tree(root);	
        System.out.println("Following are nodes in top view of Binary Tree");
        t.printTopView();		
	}
}