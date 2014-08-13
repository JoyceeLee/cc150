/*
 * 4.6 Write an algorithm to find the 'next'node (i.e. in-order successor) 
 * of a given node in a binary search tree. You may assume that each node has 
 * a link to its parent.
 */

public class Solution {
	public TreeNode findNext(TreeNode node) {
		if(node==null) return null;
		if(node.right!=null) {
			node = node.right;
			while(node.left!=null) {
				node = node.left;
			}
			return node;
		} else {
			while(node == node.parent.right) {
				node = node.parent;
			}
			return node.parent;
		}
	}
}