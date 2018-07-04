/***

How to eliminate recursion?
Think: Stack

***/

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
    public List<Integer> inorderTraversal(TreeNode root) {
        
       	List<Integer> list = new ArrayList<Integer>();
       	Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode current = root;

            while(current != null) {
                stack.push(current);
                current = current.left;
            }

            while(stack.size() > 0) {
                current = stack.pop();
                list.add(current.val);
                if(current != null) {
                    current = current.right;
                    
                    while(current != null) {
                        stack.push(current);
                        current = current.left;
                    }
                }     
            }
        return list;
    }
}


/***

TODO:

1. Implement inorder traversal without recursion and without stack. Use Morris traversal, it based on idea of threaded binary tree

***/