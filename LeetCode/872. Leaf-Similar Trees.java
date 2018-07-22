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
    
    public void findAllNodes(ArrayList<Integer> list, TreeNode root) {
        if(root == null)
            return;
        
        if(root.left == null && root.right == null) {
            list.add(root.val);
        }
        findAllNodes(list, root.left);
        findAllNodes(list, root.right);
        
    }
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        findAllNodes(list1, root1);
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        findAllNodes(list2, root2);
        
        
        if(list1.size() != list2.size())
            return false;
        boolean flag = true;
        for(int i = 0; i < list1.size(); i++) {
            if(list1.get(i) != list2.get(i)) {
                flag = false;
                break;
            }
        }
        
        return flag;
        
        
    }
}