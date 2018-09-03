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
    
    public void inorderTraversal(TreeNode root, LinkedList<Integer> list){
			if(root != null){
				inorderTraversal(root.left, list);
                list.add(root.val);
				inorderTraversal(root.right,list);
			}
	}
    
    public TreeNode increasingBST(TreeNode root) {
        TreeNode result = root;
        LinkedList<Integer> list = new LinkedList<Integer>();
        inorderTraversal(root, list);        
        
        TreeNode node = new TreeNode(list.get(0));
        root = node;
        for(int i = 1; i <list.size(); i++) {
            TreeNode temp = new TreeNode(list.get(i));
            node.right = temp;
            node = node.right;
        }
        return root;
        
    }
}