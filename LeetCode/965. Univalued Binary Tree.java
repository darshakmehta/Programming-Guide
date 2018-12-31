/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        int rootVal = root.val;
        queue.offer(root);
        
        while ( !queue.isEmpty() ) {
            TreeNode head = queue.poll();
            
            if( head.val != rootVal) return false;
            
            if( head.left != null ) queue.offer(head.left);
            if(head.right != null ) queue.offer(head.right);
            
        }
        
        return true;
        
    }
}