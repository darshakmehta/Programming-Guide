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

    // Recursive
    private void inorderTraversalRecursive(Node root) {
        if (root != null) {
            inorderTraversalRecursive(root.left);
            System.out.print(root.key + " ");
            inorderTraversalRecursive(root.right);
        }
    }

    // Iterative
    private void inorderTraversalIterative(Node root) {
        Node temp = root;
        Stack<Node> stack = new Stack<Node>();

        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.add(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.key + " ");
                temp = temp.right;
            }
        }
    }

    /** Sorted Order Traversal **/
    public void inorder() {
        inorderTraversalIterative(root);
    }

    // Recursive
    private void preorderTraversalRecursive(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderTraversalRecursive(root.left);
            preorderTraversalRecursive(root.right);
        }
    }

    // Iterative
    private void preorderTraversalIterative(Node root) {
        Node temp = root;
        Stack<Node> stack = new Stack<Node>();

        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                System.out.print(temp.key + " ");
                stack.add(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                temp = temp.right;
            }
        }
    }

    public void preorder() {
        preorderTraversalIterative(root);
    }

    // Recursive
    private void postorderTraversalRecursive(Node root) {
        if (root != null) {
            postorderTraversalRecursive(root.left);
            postorderTraversalRecursive(root.right);
            System.out.print(root.key + " ");
        }
    }

    // Iterative
    private void postorderTraversalIterative(Node root) {
        Node temp = root;
        Stack<Node> stack = new Stack<Node>();

        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.add(temp); // Left Traversal
                stack.add(temp); // Right Traversal
                temp = temp.left;
            } else {
                temp = stack.pop();

                if (stack.isEmpty()) { // last element of the stack
                    System.out.print(temp.key + " ");
                    break;
                }

                if (!stack.isEmpty() && stack.peek() != temp) { // if stack peek is temp node, right traversal is left
                    System.out.print(temp.key + " ");
                    temp = null;
                } else {
                    temp = temp.right;
                }
            }
        }
    }

    public void postorder() {
        postorderTraversalIterative(root);
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

    }
}

// Code: https://ideone.com/hBWnjt

/***
 50
 /    \
 /  	  \
 30      70
 /	\	/  \
 20	40 60	80


 **/
