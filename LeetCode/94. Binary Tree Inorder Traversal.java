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
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
            
        }
        return list;
    }
}

class Solution { //Recursion
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return result;
        
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
       
        return result;
    }
}


/***

TODO:

1. Implement inorder traversal without recursion and without stack. Use Morris traversal, it based on idea of threaded binary tree

***/