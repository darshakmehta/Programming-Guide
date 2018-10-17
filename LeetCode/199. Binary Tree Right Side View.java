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
    List<Integer> result = new ArrayList<Integer>();
        
    public List<Integer> rightSideView(TreeNode root) {
        rightSideViewHelper(result, root, 0);
        return result;
    }
    
    public void rightSideViewHelper(List<Integer> result, TreeNode root, int level) {
        if(root == null) return;
        if(result.size() == level) result.add(root.val);
        
        rightSideViewHelper(result, root.right, level + 1);
        rightSideViewHelper(result, root.left, level + 1);
    }
}