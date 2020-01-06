/***
In this article, first count of possible BST (Binary Search Trees)s is discussed, then construction of all possible BSTs.

How many structurally unique BSTs for keys from 1..N?
For example, for N = 2, there are 2 unique BSTs
     1               2  
      \            /
       2         1 

For N = 3, there are 5 possible BSTs
  1              3        3         2      1
    \           /        /        /  \      \
     3        2         1        1    3      2
    /       /            \                    \
   2      1               2                    3

We know that all node in left subtree are smaller than root and in right subtree are larger than root so if we have ith number as root, all numbers from 1 to i-1 will be in left subtree and i+1 to N will be in right subtree. If 1 to i-1 can form x different trees and i+1 to N can from y different trees then we will have x*y total trees when ith number is root and we also have N choices for root also so we can simply iterate from 1 to N for root and another loop for left and right subtree. If we take a closer look, we can notice that the count is basically n’th Catalan number. We have discussed different approaches to find n’th Catalan number here.

How to construct all BST for keys 1..N?
	The idea is to maintain a list of roots of all BSTs. Recursively construct all possible left and right subtrees. 
	Create a tree for every pair of left and right subtree and add the tree to list. Below is detailed algorithm.

1) Initialize list of BSTs as empty.  
2) For every number i where i varies from 1 to N, do following
......a)  Create a new node with key as 'i', let this node be 'node'
......b)  Recursively construct list of all left subtrees.
......c)  Recursively construct list of all right subtrees.
3) Iterate for all left subtrees
   a) For current leftsubtree, iterate for all right subtrees
        Add current left and right subtrees to 'node' and add
        'node' to list.
**/

import java.util.*;
import java.lang.*;
import java.io.*;

class BinarySearchTree
{
	// Root node of BST
	private Node root;

	BinarySearchTree() {
		this.root = null;
	}

	class Node {
		private int key;
		private Node left, right;

		public Node() { }

		public Node(int key) {
			this.key = key;
			this.left = this.right = null;
		}
	}

	public List<Node> allPossibleBSTs(int start, int end) {
		List<Node> result = new ArrayList<Node>();

		/*  if start > end   then subtree will be empty so returning NULL  
            in the list */
		if (start > end) {
			result.add(null);
			return result;
		}

		/*  iterating through all values from start to end  for constructing
            left and right subtree recursively  */
        for (int i = start; i <= end; i++) {

        	/*  constructing left subtree   */
        	List<Node> leftSubtree = allPossibleBSTs(start, i - 1);
        	/*  constructing right subtree   */
        	List<Node> rightSubtree = allPossibleBSTs(i + 1, end);

        	 /*  now looping through all left and right subtrees and connecting  
                them to ith root  below  */
            for (int j = 0; j < leftSubtree.size(); j++) {
            	Node left = leftSubtree.get(j);

            	for (int k = 0; k < rightSubtree.size(); k++) {
            		Node right = rightSubtree.get(k);
            		Node node = new Node(i);
            		node.left = left;
            		node.right = right;
            		result.add(node);
            	}
            }
        }
        return result;
	}

	private void preorderTraversal(Node root) {
		if (root != null) {
			System.out.print(root.key + " ");
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
	}

	public void preorder(Node root) {
		preorderTraversal(root);
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		BinarySearchTree bst = new BinarySearchTree();
		List<Node> result = bst.allPossibleBSTs(1, n);

		System.out.println("Preorder traversals of all constructed BSTs are "); 
        for (int i = 0; i < result.size(); i++) {  
            bst.preorder(result.get(i));  
            System.out.println(); 
        }
	}
}
