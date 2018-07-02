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
    
    public boolean isBSTUtilUsingPointers(TreeNode root, TreeNode left, TreeNode right) {
    	if(root == null) //Empty tree is BST
    		return true;
    	if(left != null && root.val <= left.val)
    		return false;
    	if(right != null && root.val >= right.val)
    		return false;
    	return (isBSTUtilUsingPointers(root.left, left, root) && isBSTUtilUsingPointers(root.right, root, right));	
    }

    public boolean isValidBST(TreeNode root) {
        return isBSTUtilUsingPointers(root, null, null);
    }
}