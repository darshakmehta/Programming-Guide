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
    
    public List<Integer> largestValues(TreeNode root) {
        helper(result, root, 0);
        return result;
    }
    
    public void helper(List<Integer> result, TreeNode root, int level) {
        if(root == null) return;
        if(level == result.size()) result.add(level, root.val);
        
        if(result.get(level) < root.val)
            result.set(level, root.val);
        
        helper(result, root.left, level + 1);
        helper(result, root.right, level + 1);
        
    }
}