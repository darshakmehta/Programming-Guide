import java.util.*;
import java.lang.*;
import java.io.*;

class BinarySearchTree {

    // Root node of BST
    private Node root;

    BinarySearchTree() {
        root = null;
    }

    class Node {
        private int key;
        private Node left, right;

        public Node(int item) {
            this.key = item;
            this.left = this.right = null;
        }
    }

    private Node insertNode(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertNode(root.left, key);
        }
        else if (key > root.key) {
            root.right = insertNode(root.right, key);
        }
        return root;
    }

    public void insert(int key) {
        root = insertNode(root, key);
    }

    private void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.key + " ");
            inorderTraversal(root.right);
        }
    }

    /** Sorted Order Traversal **/
    public void inorder() {
        inorderTraversal(root);
    }

    private void preorderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    public void preorder() {
        preorderTraversal(root);
    }

    private void postorderTraversal(Node root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.key + " ");
        }
    }

    public void postorder() {
        postorderTraversal(root);
    }

    private Node searchNode(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (root.key == key) {
            return root;
        }
        else if (key < root.key) {
            return searchNode(root.left, key);
        }
        else {
            return searchNode(root.right, key);
        }
    }

    public Node search(int key) {
        return searchNode(root, key);
    }

    public static void main(String arg[]) {
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
        System.out.println();

        Node x = bst.search(80);
        System.out.println("Searched key 80 " + (x != null ? "exists" : "does not exist"));

        x = bst.search(90); // x == null
        System.out.println("Searched key 90 " + (x != null ? "exists" : "does not exist"));

        System.out.println("Inorder: \t");
        bst.inorder();
        System.out.println();
    }
}

/**
 * Time Complexity: The worst-case time complexity of search and insert operations is O(h) where h is the height of the
 * Binary Search Tree. In the worst case, we may have to travel from root to the deepest leaf node.
 * The height of a skewed tree may become n and the time complexity of search and insert operation may become O(n).
 */

/**
 * Notes:
 * 1. Inorder traversal of BST always produces sorted output.
 * 2. We can construct a BST with only Preorder or Postorder or Level Order traversal.
 * 3. We can always get inorder traversal by sorting the only given traversal.
 * 4. TODO: Number of unique BSTs with n distinct keys is Catalan Number
 */

// Code: https://ideone.com/yDPkiE

/***
      50
    /    \
   /  	  \
  30      70
 /	\	/  \
 20	40 60	80


 **/
