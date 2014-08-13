/*
 * 4.4 Given a binary tree, design an algorithm which creates a linked list of all the nodes at
 * each depth (e.g., if you have a tree with depth D, you'll have D linked lists)
 */

// recursion 1
public class Solution {
	public ArrayList<ArrayList<TreeNode>> levelOrderTraversal(TreeNode root) {
		ArrayList<ArrayList<TreeNode>> ret = new ArrayList<ArrayList<TreeNode>>();
		helper(root, ret, 0);
		return ret;
	}
	public void helper(TreeNode root, ArrayList<ArrayList<TreeNode>> ret, int level) {
		if(root==null) return;
		ArrayLits<TreeNode> curLevel = null;
		if(ret.size()==level) {
			curLevel = new ArrayList<TreeNode>();
			ret.add(curLevel);
		} else {
			curLevel = ret.get(level);
		}
		curLevel.add(root);
		helper(root.left, ret, level+1);
		helper(root.right, ret, level+1);
	}
}

// BFS 1
public class Solution {
	public ArrayList<ArrayList<TreeNode>> levelOrderTraversal(TreeNode root) {
		ArrayList<ArrayList<TreeNode>> ret = new ArrayList<ArrayList<TreeNode>>();
		if(root==null) return ret;
		int curNum = 1;
		int nextNum = 0;
		ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
		LinkedList<TreeNode> que = new LinkedList<TreeNode>();
		que.offer(root);
		while(curNum!=0) {
			TreeNode cur = que.poll();
			curNum--;
			tmp.add(cur);
			if(cur.left!=null) {
				nextNum++;
				que.offer(cur.left);
			}
			if(cur.right!=null) {
				nextNum++;
				que.offer(cur.right);
			}
			if(curNum==0) {
				ret.add(tmp);
				curNum = nextNum;
				nextNum=0
				tmp = new ArrayList<TreeNode>();
			}
		}
	}
}

// BFS 2
public class Solution {
	public ArrayList<ArrayList<TreeNode>> levelOrderTraversal(TreeNode root) {
		ArrayList<ArrayList<TreeNode>> ret = new ArrayList<ArrayList<TreeNode>>();
		ArrayList<TreeNode> curLevel = new ArrayList<TreeNode>();
		if(root!=null) {
			curLevel.add(root);
		}
		while(curLevel!=null) {
			ret.add(curLevel);
			ArrayList<TreeNode> parent = curLevel;
			curLevel = new ArrayList<TreeNode>();
			for(TreeNode node:parent) {
				if(node.left!=null) {
					curLevel.add(node.left);
				}
				if(node.right!=null) {
					curLevel.add(node.right);
				}
			}
		}
		return ret;
	}
}