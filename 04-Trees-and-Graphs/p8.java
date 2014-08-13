/*
 * 4.8 You have two very large binary trees: T1, with millions of nodes, and T2, with
 * hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n
 * is identical to T2. That is, if you cut off the tree at node n, the two trees would be identical.
 */


/*
 * The 1st solution is build the in-order and pre-order traversal of both t1 and t2,
 * Then test if t2 is the subArray of t1;
 * To avoid cases that unable to distinguish, we use special chars to indicate when a left
 * or right node is NULL
 *
 * The 2nd solution is as follows
 */
/*
 * Time Complexity
 * Solution 1 : O(n+m)
 * Solution 2 : 
 * 		- worst case : O(nm)
 * 		- tighter : O(n+km)
 * Space Complexity
 * Solution 1 : O(n+m)
 * Solution 2 : O(logn+logm)
 * 
 * ps: n--Node# in t1
 *     m--Node# in t2
 *     k--occurence of t2 root in t1
 */
public class Solution {
	public boolean containsTree(TreeNode t1, TreeNode t2) {
		if(t2==null) {
			return true;
		}
		return subTree(t1, t2);
	}
	public boolean subTree(TreeNode t1, TreeNode t2) {
		if(t1==null) {
			return false;
		}
		if(t1.val==t2.val) {
			if(matchTree(t1, t2))
				return true;
		}
		return subTree(t1.left, t1) || subTree(t1.right, t2);
	}
	public matchTree(TreeNode t1, TreeNode t2) {
		if(t2==null || t1==null)
			return (t2==null && t1==null);
		if(t1.val!=t2.val)
			return false;
		return matchTree(t1.left, t2.left)
		    && matchTree(t1.right, t2.right);
	}
}