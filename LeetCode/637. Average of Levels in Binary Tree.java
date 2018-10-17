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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> sum = new ArrayList<Double>();
        List<Double> count = new ArrayList<Double>();
        
        compute(sum, count, root, 0);
        
        for(int i = 0; i < sum.size(); i++)
            sum.set(i, sum.get(i) / count.get(i));
        
        return sum;
    }
    
    public void compute(List<Double> sum, List<Double> count, TreeNode root, int level) {
        if(root == null) return;
        if(level == sum.size()) {
            sum.add(0.0);
            count.add(0.0);
        }
        
        sum.set(level, sum.get(level) + (double)root.val);
        count.set(level, count.get(level) + 1);
        
        compute(sum, count, root.left, level + 1);
        compute(sum, count, root.right, level + 1);
        
    }
}