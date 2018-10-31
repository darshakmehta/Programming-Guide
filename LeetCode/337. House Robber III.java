/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution { // Inefficent but Accepted
    public int rob(TreeNode root) {
        if (root == null) return 0; //Empty Tree - Nothing to rob

        int val = 0;

        if (root.left != null) { 
            val += rob(root.left.left) + rob(root.left.right); // skip one layer since we robbed the root, avoid their direct children
        }

        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right); // skip one layer since we robbed the root, avoid their direct children
        }

        return Math.max(val + root.val, rob(root.left) + rob(root.right)); // Maximum of starting at root or starting at immediate children of root where you do not rob root house
    }
}

/*
Efficient at Cost of O(n) space ==> where n is number of nodes in a tree (We did not consider the stack space) 
*/
class Solution { 
    public int rob(TreeNode root) {
        return robHelper(root, new HashMap<>());
    }

    private int robHelper(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0; //Base Condition - Empty Tree (No House) - Money = 0
        if (map.containsKey(root)) return map.get(root); // Avoid recomputation

        int val = 0;
        
        if (root.left != null) 
            val += robHelper(root.left.left, map) + robHelper(root.left.right, map);

        if (root.right != null) 
            val += robHelper(root.right.left, map) + robHelper(root.right.right, map);
        /* Start at root ==> val + root.val || Start at (root.left + root.right) */
        val = Math.max(val + root.val, robHelper(root.left, map) + robHelper(root.right, map)); //Store money robbed until now
        map.put(root, val);

        return val;
    }
}

/* Think more DP using arrays

public int rob(TreeNode root) {
    int[] res = robSub(root);
    return Math.max(res[0], res[1]);
}

private int[] robSub(TreeNode root) {
    if (root == null) return new int[2];
    
    int[] left = robSub(root.left);
    int[] right = robSub(root.right);
    int[] res = new int[2];

    res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    res[1] = root.val + left[0] + right[0];
    
    return res;
}

*/