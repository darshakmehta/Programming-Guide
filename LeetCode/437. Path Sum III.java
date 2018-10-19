/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution { //Close to Brute Force since dual DFS
    
    public int findPath(TreeNode root, int sum) {
        int result = 0;
        if(root == null) return result;
        if(sum == root.val) result++;
        result += findPath(root.left, sum - root.val);
        result += findPath(root.right, sum - root.val);
        return result;
    }
    
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
}

class Solution {
    
    Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
    
    public int backtrack(TreeNode root, int sum, int target){
        if(root == null) return 0;
        sum += root.val;
        int res = hmap.getOrDefault(sum - target, 0);    
        hmap.put(sum, hmap.getOrDefault(sum, 0) + 1);
        res += backtrack(root.left, sum, target) + 
               backtrack(root.right, sum, target);
        hmap.put(sum, hmap.get(sum) - 1);   
        return res;
    }
    
    public int pathSum(TreeNode root, int sum) {
        hmap.put(0, 1);  //Default sum = 0 has one count
        return backtrack(root, 0, sum); 
    }
}