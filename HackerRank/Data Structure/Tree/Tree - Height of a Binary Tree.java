	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static int height(Node root) {
      	// Write your code here.
        if(root == null)
            return 0;
        if(root.left == null  && root.right == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }