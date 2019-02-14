/* Assume v1, v2 are present in the Tree */

import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
		left = right = null;
	}
}

class Tree
{
	Node root;

	public Node lca(Node root, int v1, int v2) { //Iterative solution
		while (root != null) {
			if (root.data > v1 && root.data > v2)
				root = root.left;
			else if (root.data < v1 && root.data < v2)
				root = root.right;
			else 
				break;
		}
		return root;
	}

	/*
	Procedure for determining the distance between pairs of nodes in a tree: 
		the distance from n1 to n2 can be computed as the distance from the root to n1, plus the distance from the root to n2, minus twice the distance from the root to their lowest common ancestor.
	*/

	public int findDistance(Node root, int v) {
		if (root.data == v) {
			return 0;
		}
		if (root.data > v) {
			return 1 + findDistance(root.left, v);
		} else {
			return 1 + findDistance(root.right, v);
		}
	}

	public int distance(Node root, int v1, int v2) {
		int res = 0;
		res += findDistance(root, v1);
		res += findDistance(root, v2);
		Node lcaRoot = lca(root, v1, v2);
		res -= 2 * findDistance(root, lcaRoot.data);

		return res;
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		Tree tree = new Tree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        int v1 = 10, v2 = 14;
        Node t = tree.lca(tree.root, v1, v2);
        System.out.println("LCA of " + v1 + " and " + v2 + " is " + t.data);
        System.out.println("Distance between " + v1 + " and " + v2 + " is " + tree.distance(tree.root, v1, v2));
        
        v1 = 14;
        v2 = 8;
        t = tree.lca(tree.root, v1, v2);
        System.out.println("LCA of " + v1 + " and " + v2 + " is " + t.data);
  System.out.println("Distance between " + v1 + " and " + v2 + " is " + tree.distance(tree.root, v1, v2));
        v1 = 10;
        v2 = 22;
        t = tree.lca(tree.root, v1, v2);
        System.out.println("LCA of " + v1 + " and " + v2 + " is " + t.data);

        /* Distance between pair of Nodes */

        System.out.println("Distance between " + v1 + " and " + v2 + " is " + tree.distance(tree.root, v1, v2));

	}
}

