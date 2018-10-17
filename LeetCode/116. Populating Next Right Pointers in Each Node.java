/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode level = root;
        while(level != null) {
            TreeLinkNode current = level;
            while(current != null) {
                if(current.left != null) current.left.next = current.right;
                if(current.next != null && current.right != null) current.right.next = current.next.left;
                current = current.next;
            }
            level = level.left;
        }
        
    } 
    
}