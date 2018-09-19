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
    public TreeNode[] splitBST(TreeNode root, int V) {
    	
    	if(root == null) {
    		return new TreeNode[]{null, null};
    	} else if(root.val <= V) {
    		TreeNode []result = splitBST(root.right, V);
    		root.right = result[0];
    		result[0] = root;
    		return result;
    	} else {
    		TreeNode []result = splitBST(root.left, V);
    		root.left = result[1];
    		result[1] = root;
    		return result;
    	}
    }
}
