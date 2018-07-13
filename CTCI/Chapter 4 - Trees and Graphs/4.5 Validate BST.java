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
    
    public boolean isBSTUtil(Node root, int min, int max) {
    	if(root == null) //Empty tree is BST
    		return true;
    	if(root.key < min || root.key > max)
    		return false;
    	return (isBSTUtil(root.left, min, root.key - 1) && isBSTUtil(root.right, root.key + 1, max));
    }

    public boolean isBSTUtilUsingPointers(Node root, Node left, Node right) {
    	if(root == null) //Empty tree is BST
    		return true;
    	if(left != null && root.key < left.key)
    		return false;
    	if(right != null && root.key > right.key)
    		return false;
    	return (isBSTUtilUsingPointers(root.left, left, root) && isBSTUtilUsingPointers(root.right, root, right));	
    }

    public boolean isBST() {
    	return isBSTUtil(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
    	//return isBSTUtilUsingPointers(root, null, null);
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
		System.out.println(bst.isBST());
		System.out.println(bst.height());
	}	
}



/***

TODO: Check if it is a BST

Implementation:

Method 1: Simple and Wrong [O(n)]

Check if left < root and right > root [We miss the depth ndoes with small or large values]; further recursive calls

Method 2: Correct and inefficient [O(n^2)]

Check if maxValue(left) > root || minValue(right) < root; further recursive calls

Method 3: Correct and efficient [O(n)] Space: O(1) if function call stack size is not considered, otherwise O(n)

Method 3 Solution 1: Maintain min, max value at every recursive call 
Method 3 Solution 2: you can use pointers instead of min max

Method 4: Using in-order traversal [O(n)]

Solution 1: In-order traversal and store in temp array, and check if array is sorted.
Solution 2: Space optimization: We can keep track of previously visited node. If the value of the currently visited node is less than the previous value, then tree is not BST.

***/