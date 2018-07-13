/*  
	class Node
		public  int frequency; // the frequency of this tree
    	public  char data;
    	public  Node left, right;
    
*/ 

	void decode(String s, Node root) {
        Node temp = root;
        
        int i = 0;
        while(i < s.length()) {
            if(s.charAt(i) == '0')
                temp = temp.left;
            else
                temp = temp.right;
            if(temp.data != root.data) {
                System.out.print(temp.data+"");
                temp = root;
            }
            i++;
        }
        
    }