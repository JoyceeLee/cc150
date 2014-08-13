/*
 * 4.5 Implement a function to check if a binary tree is a binary search tree
 */

// Solution 1 in-order traversal
public class Solution {
	public boolean checkBST(TreeNode root) {
		TreeNode pre = null;
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode cur = root;
		while(!st.isEmpty() || cur!=null) {
			if(cur!=null) {
				st.push(cur);
				cur = cur.left;
			} else {
				cur = st.pop();
				if(pre!=null && pre.val>=cur.val) {
					return false;
				}
				pre = cur;
				cur = cur.right;
			}
		}
		return true;
	}
}

// Solution 2 min-max
public class Solution {
	public boolean checkBST(TreeNode root) {
		return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, root);
	}
	public boolean helper(int min, int max, TreeNode root) {
		if(root==null) return true;
		return min<root.val && max>root.val 
			   && helper(min, root.val, root.left)
			   && helper(root.val, max, root.right);
	}
}