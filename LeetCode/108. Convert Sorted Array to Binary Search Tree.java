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
    
    public TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        if(low > high)
            return null;
        
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = sortedArrayToBST(nums, low, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, high);  
        return root;
        
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);     
    }
}