/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution { //Recursive Solution
    
    public boolean isBSTUtilUsingPointers(TreeNode root, TreeNode left, TreeNode right) {
    	if(root == null) //Empty tree is BST
    		return true;
    	if(left != null && root.val <= left.val)
    		return false;
    	if(right != null && root.val >= right.val)
    		return false;
    	return (isBSTUtilUsingPointers(root.left, left, root) && isBSTUtilUsingPointers(root.right, root, right));	
    }

    public boolean isValidBST(TreeNode root) {
        return isBSTUtilUsingPointers(root, null, null);
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution { //Iterative solution

    public boolean isValidBST(TreeNode root) {
       if (root == null) return true;
       Stack<TreeNode> stack = new Stack<>();
       TreeNode pre = null;
       while (root != null || !stack.isEmpty()) {
          while (root != null) {
             stack.push(root);
             root = root.left;
          }
          root = stack.pop();
          if(pre != null && root.val <= pre.val) return false;
          pre = root;
          root = root.right;
       }
       return true;
    }
}