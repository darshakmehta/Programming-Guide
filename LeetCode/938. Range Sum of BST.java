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
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return 0;
        if(root.val >= L && root.val <= R)
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        else
            return rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
}