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

class Values {
	int max, min;
}

class Tree {
	Node root;
	Values val = new Values();

	// A utility function to find min and max distances with respect 
    // to root. 
    void findMinMax(Node root, Values min, Values max, int hd)  
    { 
        // Base case 
        if (root == null)  
            return; 
   
        // Update min and max 
        if (hd < min.min)  
            min.min = hd; 
        else if (hd > max.max)  
            max.max = hd; 
   
        // Recur for left and right subtrees 
        findMinMax(root.left, min, max, hd - 1); 
        findMinMax(root.right, min, max, hd + 1); 
    } 	

    // A utility function to print all nodes on a given line_no. 
    // hd is horizontal distance of current node with respect to root. 
    void printVerticalLine(Node root, int line_no, int hd)  
    { 
        // Base case 
        if (root == null)  
            return; 
   
        // If this root is on the given line number 
        if (hd == line_no)  
            System.out.print(root.data + " ");         
   
        // Recur for left and right subtrees 
        printVerticalLine(root.left, line_no, hd - 1); 
        printVerticalLine(root.right, line_no, hd + 1); 
    } 


	// The main function that prints a given binary tree in 
    // vertical order 
    void verticalOrder(Node node)  
    { 
        // Find min and max distances with resepect to root 
        findMinMax(node, val, val, 0); 
   
        // Iterate through all possible vertical lines starting 
        // from the leftmost line and print nodes line by line 
        for (int line_no = val.min; line_no <= val.max; line_no++)  
        { 
            printVerticalLine(node, line_no, 0); 
            System.out.println(""); 
        } 
    } 

	public static void main(String args[]) 
    {
    	Tree tree = new Tree(); 

        /* Let us construct the tree shown in above diagram */
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
        tree.root.right.left.right = new Node(8); 
        tree.root.right.right.right = new Node(9); 
   
        System.out.println("vertical order traversal is :"); 
        tree.verticalOrder(tree.root); 
    }
}

/***

The idea is to traverse the tree once and get the minimum and maximum horizontal distance with respect to root. For the tree shown above, minimum distance is -2 (for node with value 4) and maximum distance is 3 (For node with value 9).
Once we have maximum and minimum distances from root, we iterate for each vertical line at distance minimum to maximum from root, and for each vertical line traverse the tree and print the nodes which lie on that vertical line.

Time Complexity: 

Time complexity of above algorithm is O(w*n) where w is width of Binary Tree and n is number of nodes in Binary Tree. In worst case, the value of w can be O(n) (consider a complete tree for example) and time complexity can become O(n2).

This problem can be solved more efficiently using the technique discussed in this https://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/ post. We will soon be discussing complete algorithm and implementation of more efficient method.

***/