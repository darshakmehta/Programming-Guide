/***

Given a Singly Linked List which has data members sorted in ascending order. Construct a Balanced Binary Search Tree which has same data members as the given Linked List.

Examples:

Input:  Linked List 1->2->3
Output: A Balanced BST 
     2   
   /  \  
  1    3 


Input: Linked List 1->2->3->4->5->6->7
Output: A Balanced BST
        4
      /   \
     2     6
   /  \   / \
  1   3  5   7  

Input: Linked List 1->2->3->4
Output: A Balanced BST
      3   
    /  \  
   2    4 
 / 
1

Input:  Linked List 1->2->3->4->5->6
Output: A Balanced BST
      4   
    /   \  
   2     6 
 /  \   / 
1   3  5 

**/

/**

Method 1 (Simple)

Algorithm:

Following is a simple algorithm where we first find the middle node of the list and make it the root of the tree to be constructed.

1) Get the Middle of the linked list and make it root.
2) Recursively do same for the left half and right half.
       a) Get the middle of the left half and make it left child of the root
          created in step 1.
       b) Get the middle of right half and make it the right child of the
          root created in step 1.

Time complexity: O(nLogn) where n is the number of nodes in Linked List.

#TODO: Write Code

**/

/**

Method 2 (Tricky)

Method 1 constructs the tree from root to leaves. In this method, we construct from leaves to root. The idea is to insert nodes in BST in the same order as they appear in Linked List so that the tree can be constructed in O(n) time complexity. We first count the number of nodes in the given Linked List. Let the count be n. After counting nodes, we take left n/2 nodes and recursively construct the left subtree. After left subtree is constructed, we allocate memory for root and link the left subtree with root. Finally, we recursively construct the right subtree and link it with root.
While constructing the BST, we also keep moving the list head pointer to next so that we have the appropriate pointer in each recursive call.

// Code: https://ideone.com/ZASrzl
**/

import java.util.*;
import java.lang.*;
import java.io.*;

class BalancedBST {
		// Root node of BalancedBST
		private TNode root;

		BalancedBST() {
			this.root = null;
		}
		
		public TNode getRootTNode() {
			return this.root;
		}
		
		public void setRootTNode(TNode root) {
			this.root = root;
		}

		class TNode {
			private int key;
			private TNode left, right;

			public TNode() { }

			public TNode(int key) {
				this.key = key;
				this.left = this.right = null;
			}

			public TNode getLeftTNode() {
				return this.left;
			}
			
			public void setLeftTNode(TNode left) {
				this.left = left;
			}

			public TNode getRightTNode() {
				return this.right;
			}
			
			public void setRightTNode(TNode right) {
				this.right = right;
			}
		}

	private void inorderTraversal(TNode root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.print(root.key + " ");
			inorderTraversal(root.right);
		}
	}

	public void inorder() {
		inorderTraversal(root);
	}

	private void preorderTraversal(TNode root) {
		if (root != null) {
			System.out.print(root.key + " ");
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
	}

	public void preorder() {
		preorderTraversal(root);
	}	
}


class LinkList {

	// Head node of LinkList
	private LNode head;

	LinkList() {
		head = null;
	}
	
	class LNode {
		private int key;
		private LNode next;
		
		public LNode(int key) {
			this.key = key;
			this.next = null;
		}
	}

	public int countLNodes(LNode temp) {
		if (temp == null)
			return 0;

		return 1 + countLNodes(temp.next);
	}

	public BalancedBST.TNode sortedListToBST(int n, BalancedBST bst) {
		/* Base Case */
		if (n <= 0)
			return null;

		/* Recursively construct the left subtree */
		BalancedBST.TNode left = sortedListToBST(n / 2, bst);

		/* head_ref now refers to middle node,  
           make middle node as root of BST*/
		BalancedBST.TNode root = bst.new TNode(head.key);

		// Set pointer to left subtree
		root.setLeftTNode(left);

		/* Change head pointer of Linked List for parent  
           recursive calls */
        head = head.next; 
  
        /* Recursively construct the right subtree and link it  
           with root. The number of nodes in right subtree  is  
           total nodes - nodes in left subtree - 1 (for root) */
        root.setRightTNode(sortedListToBST(n - (n / 2) - 1, bst));

        return root;
	}

	public void sortedListToBST(BalancedBST bst) {
		int n = countLNodes(head);
		
		bst.setRootTNode(sortedListToBST(n, bst));
	}

	public void push(int data) { // O(1)
		LNode new_LNode = new LNode(data);
		new_LNode.next = head;
		head = new_LNode;
		return;
	}

	public void addElements() {
		this.push(7); 
        this.push(6); 
        this.push(5); 
        this.push(4); 
        this.push(3); 
        this.push(2); 
        this.push(1);
	}

	private void printLinkListUtil(LNode head) {
		LNode temp = head;

		while (temp != null) {
			System.out.print(temp.key + " ");
			temp = temp.next;
		}
	}

	public void printLinkList() {
		printLinkListUtil(head);
	}

	public static void main (String[] args) throws java.lang.Exception {
		LinkList list = new LinkList();
		list.addElements();

		System.out.println("Sorted List");
		list.printLinkList();
		System.out.println();

		BalancedBST bst = new BalancedBST();
		list.sortedListToBST(bst);

		System.out.println("Inorder: \t");
		bst.inorder();
		System.out.println();

		System.out.println("Preorder: \t");
		bst.preorder();
		System.out.println();
	}
}

// TC: O(n)
