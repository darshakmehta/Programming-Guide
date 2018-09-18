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
    
    int res = Integer.MAX_VALUE;
    
    public void traverse(TreeNode root, Integer max, Integer min) {
        if(root == null) return;
        
        if(max != null) res = Math.min(res, max - root.val);
        if(min != null) res = Math.min(res, root.val - min);
        
        traverse(root.left, root.val, min);
        traverse(root.right, max, root.val);
    }
    
    public int getMinimumDifference(TreeNode root) {
        traverse(root, null, null);
        return res;
    }
}