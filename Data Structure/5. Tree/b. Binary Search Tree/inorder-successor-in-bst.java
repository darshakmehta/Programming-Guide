class Solution {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if(root == null || p == null) return;

		if(p.right != null) {
			return minValue(n.right);
		}

		TreeNode successor = null;

		while(root != null) {
			if(p.val < root.val) {
				successor = root;
				root = root.left;
			} else if(p.val > root.val) {
				root = root.right;
			} else
				break;
		}
		return successor;
	}

}