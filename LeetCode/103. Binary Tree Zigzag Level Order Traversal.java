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
   
    public void levelHelper(List<List<Integer>> result, TreeNode root, int height) {
        if (root == null) return;
        
        if (height == result.size()) 
            result.add(new LinkedList<Integer>());
        
        if(height % 2 != 0)
            result.get(height).add(0, root.val);
        else
            result.get(height).add(root.val);
        levelHelper(result, root.left, height+1);
        levelHelper(result, root.right, height+1);
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        levelHelper(result, root, 0);
        return result;
    }
}