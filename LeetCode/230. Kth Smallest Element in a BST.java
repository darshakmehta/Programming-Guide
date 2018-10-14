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
    public int kthSmallest(TreeNode root, int k) {
         Stack<TreeNode> stack = new Stack<>();
         while(root != null || !stack.isEmpty()) {
             while(root != null) {
                 stack.push(root);    
                 root = root.left;   
             } 
             root = stack.pop();
             if(--k == 0) break;
             root = root.right;
         }
         return root.val;
     }
}