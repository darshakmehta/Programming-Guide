class Solution {

    public TreeNode minValue(TreeNode pRight) {
        int minv = pRight.key;

        while (pRight.left != null) {
            minv = pRight.left.key;
            pRight = pRight.left;
        }
        return pRight;
    }

    /* Method 1 */
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null || p == null) 
            return null;

		if (p.right != null) {
			return minValue(p.right);
		}

		TreeNode successor = null;

		while (root != null) {
			if (p.val < root.val) {
				successor = root; // key step: Since p.val < successor always
				root = root.left;
			} else if (p.val > root.val) {
				root = root.right;
			} else
				break;
		}
        
		return successor;
	}
}

/* Method 2 */
public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (root == null || p == null) 
            return null;
 
    TreeNode next = null;
    TreeNode successor = root;

    while (successor != null && successor.val != p.val) {
        if (successor.val > p.val){
            next = successor;
            successor = successor.left;
        } else {
            successor= successor.right;
        }
    }
 
    if (successor == null)        
        return null;
 
    if (successor.right == null)
        return next;
 
    successor = successor.right;
    while (successor.left != null)
        successor = successor.left;
 
    return successor;
}

/* Method 3 - Stack Based */
public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    
    Stack<TreeNode> stack = new Stack<TreeNode>();
    
    if (root == null || p == null)
        return null;
 
    stack.push(root);
    boolean isNext = false;
    
    while (!stack.isEmpty()) {
        TreeNode top = stack.pop();
 
        if (top.right == null && top.left == null) {
            if (isNext) {
                return top;
            }
 
            if (p.val == top.val) {
                isNext = true;
            }
            continue;
        }
 
        if (top.right != null) {
            stack.push(top.right);
            top.right = null;
        }
 
        stack.push(top);
 
        if (top.left != null) {
            stack.push(top.left);
            top.left = null;
        }
    }
 
    return null;
}
