import java.util.*;
import java.lang.*;
import java.io.*;

class BinarySearchTree {

    public enum DeleteChoice {
        PREDECESSOR, SUCCESSOR
    }

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
        return searchNode(root.right, key);
    }

    public Node search(int key) {
        return searchNode(root, key);
    }

    // Find Inorder Successor
    public int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // Find Inorder Predecessor
    public int maxValue(Node root) {
        int maxv = root.key;
        while (root.right != null) {
            maxv = root.right.key;
            root = root.right;
        }
        return maxv;
    }

    public Node deleteNode(Node root, int key, DeleteChoice choice) {
        if (root == null) {
            return root;
        }
        if (key < root.key) {
            root.left = deleteNode(root.left, key, choice);
        }
        else if (key > root.key) {
            root.right = deleteNode(root.right, key, choice);
        }
        else {
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
            if (choice == DeleteChoice.PREDECESSOR) {
                root.key = maxValue(root.left); // find Inorder Predecessor
                root.left = deleteNode(root.left, root.key, choice);
            } else if (choice == DeleteChoice.SUCCESSOR) {
                root.key = minValue(root.right); // find Inorder Successor
                root.right = deleteNode(root.right, root.key, choice);
            }
        }
        return root;
    }

    public void delete(int key, DeleteChoice choice) {
        root = deleteNode(root, key, choice);
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

        bst.delete(30, DeleteChoice.SUCCESSOR); // Using Inorder Successor

        System.out.println("Preoder: \t");
        bst.preorder();
        System.out.println();

        bst.delete(70, DeleteChoice.PREDECESSOR); // Using Inorder Predecessor

        System.out.println("Preorder: \t");
        bst.preorder();
        System.out.println();
    }
}

// Code: https://ideone.com/0vGTbS

/**
 * Time Complexity: The worst case time complexity of delete operation is O(h) where h is the height of the
 * Binary Search Tree. In worst case, we may have to travel from the root to the deepest leaf node.
 * The height of a skewed tree may become n and the time complexity of delete operation may become O(n)
 */

/**
 * Optimization to above code for two children case :
 * In the above recursive code, we recursively call delete() for the successor.
 * We can avoid recursive calls by keeping track of the parent node of the successor so that we can simply remove
 * the successor by making the child of a parent NULL. We know that the successor would always be a leaf node.
 */



/***
 50
 /    \
 /  	  \
 30      70
 /	\	/  \
 20	40 60	80


 **/
