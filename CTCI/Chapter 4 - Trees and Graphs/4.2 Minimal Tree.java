
import java.util.*;
import java.lang.*;
import java.io.*;

class BinarySearchTree {

	//Root node of BST
	Node root;
	
	BinarySearchTree(){
		root = null;
	}

	class Node{
		int key;
		Node left, right;
		
		public Node(int item){
			key = item;
			left = right = null;
		}
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
	
	public void delete(int key) {
		root = deleteNode(root, key);
	}
	
	public Node search(int key) {
		return searchNode(root, key);
	}
	
	public Node searchNode(Node root, int key) {
		if(root.key == key) {
			return root;
		} 
		else if(key < root.key)
			return searchNode(root.left, key);
		else
			return searchNode(root.right, key);
	}
	
	public Node deleteNode(Node root, int key) {
		if(root == null) return root;
		if (key < root.key)
	            	root.left = deleteNode(root.left, key);
		else if (key > root.key)
	            	root.right = deleteNode(root.right, key);
        else 
        {
        	if(root.left == null)
        		return root.right;
        	else if(root.right == null)
        		return root.left;
        	root.key = minValue(root.right);
        	
        	root.right = deleteNode(root.right, root.key);
        }
        return root;
	}
	
    public int minValue(Node root)
    {
        int minv = root.key;
        while (root.left != null)
        {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    public Node createMinimalTree(int a[], int low, int high) {
    	if(low > high)
    		return null;
    	int mid = low + (high - low) / 2;
    	Node node = new Node(a[mid]);
    	node.left = createMinimalTree(a, low, mid - 1);
    	node.right = createMinimalTree(a, mid + 1, high);

    	return node;
    }
    

    public int heightUtil(Node root) {
    	if(root == null)
    		return 0;
    	return 1 + Math.max(heightUtil(root.left), heightUtil(root.right));
    }
 
    public int height() {
    	return heightUtil(root);
    }
    
	
	public static void main(String arg[]){
		BinarySearchTree bst = new BinarySearchTree();
		int a[] = {1, 2, 5, 18, 19, 25, 47, 58, 96, 100, 121, 190};
		bst.root = bst.createMinimalTree(a, 0, a.length - 1);
		bst.inorder();
		System.out.println(bst.height());
	}	
}