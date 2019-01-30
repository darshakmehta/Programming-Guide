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
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return sum;
        if(root.left != null) {
            if(root.left.left == null && root.left.right == null)
                sum += root.left.val;
            sumOfLeftLeaves(root.left);
        }
        if(root.right != null) {
            sumOfLeftLeaves(root.right);
        }
        return sum;
        
    }
}
