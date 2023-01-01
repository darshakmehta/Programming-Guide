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

    class DeleteTwoChildNode {
        int value;
        Node successorParent;

        public DeleteTwoChildNode(int value, Node successorParent) {
            this.value = value;
            this.successorParent = successorParent;
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
    public DeleteTwoChildNode minValue(Node root) {
        int minv = root.key;
        DeleteTwoChildNode result = new DeleteTwoChildNode(minv, null);
        while (root.left != null) {
            result.successorParent = root;
            minv = root.left.key;
            result.value = minv;
            root = root.left;
        }
        return result;
    }

    public Node deleteNode(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.key) {
            root.left = deleteNode(root.left, key);
        }
        else if (key > root.key) {
            root.right = deleteNode(root.right, key);
        }
        else {
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }

            Node parent = root;

            DeleteTwoChildNode result = minValue(root.right); // find Inorder Successor
            root.key = result.value;

            // root.right = deleteNode(root.right, root.key); // Save recursive calls by storing successor parent node
            if (result.successorParent == null) {
                parent.right = null;
            } else {
                result.successorParent.left = null; // Delete minValue node
            }
        }
        return root;
    }

    public void delete(int key) {
        root = deleteNode(root, key);
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
        bst.insert(35);
        bst.insert(85);
        bst.insert(78);
        bst.insert(90);
        bst.insert(88);
        bst.insert(82);

        System.out.println("Preorder: \t");
        bst.preorder();
        System.out.println();

        bst.delete(30); // Using Inorder Successor
        bst.delete(70); // Using Inorder Successor
        bst.delete(85); // Using Inorder Successor

        System.out.println("Preoder: \t");
        bst.preorder();
        System.out.println();
    }
}

// Code: https://ideone.com/Wc5E2D

/**
 * Note: Above optimization can be applied for Predecessor as well.
 */
