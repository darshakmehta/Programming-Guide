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
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public void backtrack(TreeNode root, int sum, List<Integer> tempList) {
        if(root == null) return;
        tempList.add(root.val);
        if(root.left == null && root.right == null && root.val == sum) {
            result.add(new ArrayList<Integer>(tempList));
        } else {
            backtrack(root.left, sum - root.val, tempList);
            backtrack(root.right, sum - root.val, tempList);
        }
        tempList.remove(tempList.size() - 1);
    }
    
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        backtrack(root, sum, new ArrayList<Integer>());
        return result;
        
    }
}