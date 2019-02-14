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

	public Node recursivelca(Node node, int n1, int n2)  // Recursive solution
    { 
        if (node == null) 
            return null; 
   
        // If both n1 and n2 are smaller than root, then LCA lies in left 
        if (node.data > n1 && node.data > n2) 
            return lca(node.left, n1, n2); 
   
        // If both n1 and n2 are greater than root, then LCA lies in right 
        if (node.data < n1 && node.data < n2)  
            return lca(node.right, n1, n2); 
   
        return node; 
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
        t = tree.recursivelca(tree.root, v1, v2);
        System.out.println("LCA of " + v1 + " and " + v2 + " is " + t.data);
  
        v1 = 14;
        v2 = 8;
        t = tree.lca(tree.root, v1, v2);
        System.out.println("LCA of " + v1 + " and " + v2 + " is " + t.data);
  
        v1 = 10;
        v2 = 22;
        t = tree.lca(tree.root, v1, v2);
        System.out.println("LCA of " + v1 + " and " + v2 + " is " + t.data);
	}
}

/***

Note: 

1. Running time of Iterative solution of LCA is O(h) where h is the height of the tree
2. Extra space of the function call stack for recursive function calls is avoided, by using iterative solution.

TODO:

0. Extend above solution to return NULL if n1 or n2 or both are not present in the tree.
1. LCA of Binary Tree
2. LCA of Binary Tree using RMQ
3. LCA of BST | BT using parent pointer

***/
