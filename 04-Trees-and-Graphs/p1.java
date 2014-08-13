/**
 * 4.1 Implement a function to check if a binary tree is balanced. 
 * For the purposes of this question, a balanced tree is defined to be a tree 
 * such that the heights of the two subtrees of any node never differ by more than one.
 */


// Solution 1
/*
 * Time Complexity : O(NlogN)
 * Space Complexity : O(H)
 */
public class Solution {
	public boolean isBalanced(TreeNode head) {
		if(head==null) return true;
		return isBalanced(head.left) && isBalanced(head.right) 
			&& Math.abs(getHeight(head.left)-getHeight(head.right))<2;
	}
	public int getHeight(head) {
		if(head==null) return 0;
		return Math.max(getHeight(head.left), getHeight(head.right))+1;
	}
}

// Solution 2
/*
 * Time Complexity : O(N)
 * Space Complexity : O(H)
 */
public class Solution {
	public boolean isBalanced(TreeNode head) {
		if(checkHeight(head)==-1) {
			return false;
		} else {
			return true;
		}
	}
	public int checkHeight(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int leftHeight = checkHeight(root.left);
		if(leftHeight==-1) return -1;
		int rightHeight = checkHeight(root.right);
		if(rightHeight==-1) return -1;
		return Math.abs(leftHeight-rightHeight)<2 ? Math.max(leftHeight, rightHeight)+1:-1;
	}
}