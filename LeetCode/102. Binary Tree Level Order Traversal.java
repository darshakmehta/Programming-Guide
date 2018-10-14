public class Solution { //BFS Iterative
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();  
        if (root == null) return result;  

        Queue<TreeNode> queue = new LinkedList<>();  
        queue.add(root);  
        
       while (!queue.isEmpty()) { 
           List<Integer> level = new ArrayList<Integer>(); 
           int cnt = queue.size(); 
           
           for (int i = 0; i < cnt; i++) { 
               TreeNode node = queue.poll(); 
               level.add(node.val); 
               
               if (node.left != null) queue.add(node.left); 
               if (node.right != null) queue.add(node.right); 
           } 
           result.add(level); 
       }
       return result;
    }
}


public class Solution { //DFS Recursive
    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }
    
}