/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution { //Recursive
    
    public boolean isSymmetric(TreeNode first, TreeNode second) {
        if(first == null && second == null)
            return true;
        if(first == null || second == null)
            return false;
        return first.val == second.val && isSymmetric(first.left, second.right) && isSymmetric(first.right, second.left);
        
    }
    public boolean isSymmetric(TreeNode root) {
        TreeNode first = root;
        TreeNode second = root;
        
        return isSymmetric(first, second);
        
    }
}

class Solution { //Iterative
    
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}