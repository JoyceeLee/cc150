/*
 * 4.9 You are given a binary tree in which each node contains a value. Design an algorithm
 * to print all paths which sum to a given value. 
 * Note : The path does not need to start or end at the root or a leaf.
 */


/* 
 * DFS, check if the current node is the end of the valid path
 *
 * Time Complexity
 * 	- helper : T(n) = O(h) + 2T(n/2)
 *                  = 1 + 2*2^1 + 3*2^2 + ... + (log2(n)-1)*2^(log2(n))
 *                  = O(nlog(n))
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if(root==null) return ret;
		List<Integer> curPath = new ArrayList<Integer>();
		helper(ret, curPath, root, target);
		return ret;
	}
	public void helper(ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> curPath, TreeNode root, int target) {
		if(root==null) return;
		curPath.add(root.val);
		int sum = 0;
		for(int i=curPath.size()-1; i>=0; i--) {
			sum += curPath.get(i);
			if(sum==target) {
				ret.add(new ArrayList<Integer>(curPath.subList(i, curPath.size())));
			}
		}
		helper(ret, curPath, root.left, target);
		helper(ret, curPath, root.right, targte);
		curPath.remove(curPath.size()-1);
		return;
	}
}