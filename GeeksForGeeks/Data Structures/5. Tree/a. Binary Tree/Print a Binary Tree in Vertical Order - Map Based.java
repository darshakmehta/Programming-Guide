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

class Tree {
	Node root;

    // Utility function to store vertical order in map 'm' 
    // 'hd' is horizontal distance of current node from root. 
    // 'hd' is initially passed as 0 
    static void getVerticalOrder(Node root, int hd, 
                                TreeMap<Integer,Vector<Integer>> m) 
    { 
        // Base case 
        if(root == null) 
            return; 
          
        //get the vector list at 'hd' 
        Vector<Integer> get =  m.get(hd); 
          
        // Store current node in map 'm' 
        if(get == null) 
        { 
            get = new Vector<>(); 
            get.add(root.key); 
        } 
        else
            get.add(root.key); 
          
        m.put(hd, get); 
          
        // Store nodes in left subtree 
        getVerticalOrder(root.left, hd-1, m); 
          
        // Store nodes in right subtree 
        getVerticalOrder(root.right, hd+1, m); 
    } 

    // The main function to print vertical oder of a binary tree 
    // with given root 
    static void printVerticalOrder(Node root) 
    { 
        // Create a map and store vertical oder in map using 
        // function getVerticalOrder() 
        TreeMap<Integer,Vector<Integer>> m = new TreeMap<>(); 
        int hd = 0; 
        getVerticalOrder(root, hd, m); 
          
        // Traverse the map and print nodes at every horigontal 
        // distance (hd) 
        for (Entry<Integer, Vector<Integer>> entry : m.entrySet()) 
        { 
            System.out.println(entry.getValue()); 
        } 
    } 

	public static void main(String[] args) { 
        // TO DO Auto-generated method stub 
        Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.left = new Node(6); 
        root.right.right = new Node(7); 
        root.right.left.right = new Node(8); 
        root.right.right.right = new Node(9); 
        System.out.println("Vertical Order traversal is"); 
        printVerticalOrder(root); 
    } 
}

/***

We have discussed a O(n2) solution in the previous post. In this post, an efficient solution based on hash map is discussed. We need to check the Horizontal Distances from root for all nodes. If two nodes have the same Horizontal Distance (HD), then they are on same vertical line. The idea of HD is simple. HD for root is 0, a right edge (edge connecting to right subtree) is considered as +1 horizontal distance and a left edge is considered as -1 horizontal distance. For example, in the above tree, HD for Node 4 is at -2, HD for Node 2 is -1, HD for 5 and 6 is 0 and HD for node 7 is +2.
We can do preorder traversal of the given Binary Tree. While traversing the tree, we can recursively calculate HDs. We initially pass the horizontal distance as 0 for root. For left subtree, we pass the Horizontal Distance as Horizontal distance of root minus 1. For right subtree, we pass the Horizontal Distance as Horizontal Distance of root plus 1. For every HD value, we maintain a list of nodes in a hasp map. Whenever we see a node in traversal, we go to the hash map entry and add the node to the hash map using HD as a key in map.

Time Complexity of hashing based solution can be considered as O(n) under the assumption that we have good hashing function that allows insertion and retrieval operations in O(1) time. In the above C++ implementation, map of STL is used. map in STL is typically implemented using a Self-Balancing Binary Search Tree where all operations take O(Logn) time. Therefore time complexity of above implementation is O(nLogn).

***/