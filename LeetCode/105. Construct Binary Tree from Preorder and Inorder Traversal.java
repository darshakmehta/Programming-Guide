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
    
    Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i = 0; i <  inorder.length; i++)
            hmap.put(inorder[i], i);
        
        TreeNode root = buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length -1);
        return root;
    }
    
    public TreeNode buildTreeHelper(int preorder[], int preStart, int preEnd, int inorder[], int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = hmap.get(root.val);
        int numsLeft = inRoot - inStart;
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1);
        root.right = buildTreeHelper(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd);
        return root;
    }
}

/***

Follow up: Postorder and Inorder is given, build the binary tree

***/