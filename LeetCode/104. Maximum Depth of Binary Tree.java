/***
Running time: O(N lgn) where N = number of elements
***/

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
    public int maxDepth(TreeNode root) {
        int depth = 0;
         if(root == null)
            return depth;
         if(root != null)
             depth++;
         if(root.left !=null || root.right!= null) {  
             
             depth = Math.max(depth + maxDepth(root.left) ,depth + maxDepth(root.right) );
         }
        return depth;
    }
}