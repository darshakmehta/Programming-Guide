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

class PerpendicularOrder {
	Node root;

    void printVerticaleOrder(TreeMap<Integer, LinkedList<Node>> distanceMap) {
        for (int key : distanceMap.keySet()) {
            for (Node node : distanceMap.get(key))
                System.out.print(node.data+" ");
            System.out.println("");
        }
        
    }

    void verticaleOrder(Node root) {

        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        Queue<Integer> distanceQueue = new LinkedList<Integer>();

        TreeMap<Integer, LinkedList<Node>> distanceMap = new TreeMap<>();

        distanceQueue.add(0);
        queue.add(root);

        while (!queue.isEmpty()) {

            Node tempNode = queue.poll();
            int distance = distanceQueue.poll();

            if (distanceMap.get(distance) == null) {
                distanceMap.put(distance, new LinkedList<Node>());
            }

            distanceMap.get(distance).add(tempNode);

            if (tempNode.left != null) {
                distanceQueue.add(distance - 1);
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                distanceQueue.add(distance + 1);
                queue.add(tempNode.right);
            }
        }
        printVerticaleOrder(distanceMap);
    }


	public static void main(String[] args) { 
        PerpendicularOrder tree = new PerpendicularOrder();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
        tree.root.right.right.right = new Node(9);
        tree.root.right.right.left = new Node(10);
        tree.root.right.right.left.right = new Node(11);
        tree.root.right.right.left.right.right = new Node(12);

        System.out.println("vertical order traversal is :");
        tree.verticaleOrder(tree.root);
    } 
}

/*

Output:
Vertical order traversal is 
4  
2  
1  5  6  
3  8  10  
7  11  
9  12

*/

/***

We have discussed an efficient approach in below post.

Print a Binary Tree in Vertical Order | Set 2 (Hashmap based Method)

The above solution uses preorder traversal and Hashmap to store nodes according to horizontal distances. Since above approach uses preorder traversal, nodes in a vertical line may not be prined in same order as they appear in tree. For example, the above solution prints 12 before 9 in below tree. See this for a sample run.

If we use level order traversal, we can make sure that if a node like 12 comes below in same vertical line, it is printed after a node like 9 which comes above in vertical line.

1. To maintain a hash for the branch of each node.
2. Traverse the tree in level order fashion.
3. In level order traversal, maintain a queue
   which holds, node and its vertical branch.
    * pop from queue.
    * add this node's data in vector corresponding
      to its branch in the hash.
    * if this node hash left child, insert in the 
      queue, left with branch - 1.
    * if this node hash right child, insert in the 
      queue, right with branch + 1.

Time Complexity of above implementation is O(n Log n). Note that above implementation uses map which is implemented using self-balancing BST.

We can reduce time complexity to O(n) using unordered_map. To print nodes in desired order, we can have 2 variables denoting min and max horizontal distance. We can simply iterate from min to max horizontal distance and get corresponding values from Map. So it is O(n)

Auxiliary Space : O(n)

Reference: https://ide.geeksforgeeks.org/z1AQPm      
***/