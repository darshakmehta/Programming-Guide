import java.util.*;
import java.lang.*;
import java.io.*;

class BinarySearchTree {
	class Node{
		int key;
		Node left, right;
		
		public Node(int item){
			key = item;
			left = right = null;
		}
	}
		//Root node of BST
		Node root;
		
		BinarySearchTree(){
			root = null;
		}
		
		void insert(int key) {
			root = insertNode(root, key);
		}
		
		public Node insertNode(Node root, int key) {
			if(root == null){
			    root = new Node(key);
			    return root;
			}
			
			if(key < root.key) 
			    root.left = insertNode(root.left, key);
			else if (key > root.key)
            		    root.right = insertNode(root.right, key);
            		    return root;
		}
		
		void inorder() {
			inorderTraversal(root);
		}
		
		public void inorderTraversal(Node root){
			if(root != null){
				inorderTraversal(root.left);
				System.out.print(root.key + " ");
				inorderTraversal(root.right);
			}
				
		}
	
		void preorder() {
			preorderTraversal(root);
		}
		
		public void preorderTraversal(Node root){
			if(root != null){
				System.out.print(root.key + " ");
				preorderTraversal(root.left);
				preorderTraversal(root.right);
			}
				
		}
		
		void postorder() {
			postorderTraversal(root);
		}
		
		public void postorderTraversal(Node root){
			if(root != null){
				postorderTraversal(root.left);
				postorderTraversal(root.right);
				System.out.print(root.key + " ");
			}
				
		}
		
		public static void main(String arg[]){
			BinarySearchTree bst = new BinarySearchTree();
			bst.insert(50);
			bst.insert(30);
			bst.insert(20);
			bst.insert(40);
			bst.insert(70);
			bst.insert(60);
			bst.insert(80);
			System.out.println("Inorder: \t");
			bst.inorder();
			System.out.println();
			System.out.println("Preorder: \t");
			bst.preorder();
			System.out.println();
			System.out.println("Postorder: \t");
			bst.postorder();
		}	
			
	
}