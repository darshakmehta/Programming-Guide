class Solution {

    public TreeNode minValue(Node root) {
        int minv = root.key;

        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return root;
    }

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null || p == null) return;

		if (p.right != null) {
			return minValue(p.right);
		}

		TreeNode successor = null;

		while (root != null) {
			if (p.val < root.val) {
				successor = root;
				root = root.left;
			} else if (p.val > root.val) {
				root = root.right;
			} else
				break;
		}
        
		return successor;
	}
}

public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (root==null)
        return null;
 
    TreeNode next = null;
    TreeNode c = root;
    while (c!=null && c.val!=p.val){ //check for p.null
        if (c.val > p.val){
            next = c;
            c = c.left;
        } else {
            c= c.right;
        }
    }
 
    if (c==null)        
        return null;
 
    if (c.right==null)
        return next;
 
    c = c.right;
    while (c.left!=null)
        c = c.left;
 
    return c;
}

public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    if (root==null || p==null)
        return null;
 
    stack.push(root);
    boolean isNext = false;
    while (!stack.isEmpty()){
        TreeNode top = stack.pop();
 
        if (top.right==null&&top.left==null){
            if (isNext){
                return top;
            }
 
            if (p.val==top.val){
                isNext = true;
            }
            continue;
        }
 
        if (top.right!=null){
            stack.push(top.right);
            top.right=null;
        }
 
        stack.push(top);
 
        if (top.left!=null){
            stack.push(top.left);
            top.left=null;
        }
    }
 
    return null;
}