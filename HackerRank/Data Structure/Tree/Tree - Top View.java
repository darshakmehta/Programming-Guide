	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/

    static class QueueLOT {
        Node node;
        int h; //horizontal distance

        QueueLOT(Node node, int h) {
            this.node = node;
            this.h = h;
        }
    }

	public static void topView(Node root) {
        if(root == null)
            return;
        HashSet<Integer> set = new HashSet<Integer>();
        Queue<QueueLOT> queue = new LinkedList<QueueLOT>();
        queue.add(new QueueLOT(root, 0));
        
        while(!queue.isEmpty()) {
            QueueLOT q = queue.remove();
            int hd = q.h;
            Node n = q.node;
            
            if(!set.contains(hd)) {
                set.add(hd);
                System.out.print(n.data + " ");
            }
            
            if(n.left != null)
                queue.add(new QueueLOT(n.left, hd - 1));
            if(n.right != null)
                queue.add(new QueueLOT(n.right, hd + 1));
        }
        
    }