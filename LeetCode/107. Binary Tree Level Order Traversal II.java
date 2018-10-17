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
        if (height >= result.size()) {
            result.add(new LinkedList<Integer>());
        }
        result.get(height).add(root.val);
        levelHelper(result, root.left, height+1);
        levelHelper(result, root.right, height+1);
    }
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        levelHelper(result, root, 0);
        // Collections.reverse(result); //Works but not the right way since it takes O(Nlogn) time
        return result;
    }
}

class Solution {
    public void levelHelper(List<List<Integer>> result, TreeNode root, int height) {
        if(root == null) return;
        if(height == result.size()) {
            result.add(0, new LinkedList<Integer>()); //O(N) time solution
        }
        result.get(result.size() - 1 - height).add(root.val);
        levelHelper(result, root.left, height+1);
        levelHelper(result, root.right, height+1);
    }
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        levelHelper(result, root, 0);
        return result;
    }
}