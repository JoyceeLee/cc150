/*
 * 4.7 Design an algorithm and write code to find the first common ancestor of two 
 * nodes in a binary tree. Avoid storing additional nodes in a data structure.
 * NOTE: This is not necessarily a binary search tree.
 */


// Solution 2.1
/* 
 * in the Solution 1.1, covers searches all nodes under root for p and q. 
 * That is each subtree is searched over and over again
 * We may recognize that we should only need to search the entire tree once to find p and q. 
 * We should then be able to "bubble up" the findings to earlier nodes in the stack
 */
// A Bottom-up Approach (Worst case O(n) ):
/*
Time Complexity : O(n)
- check : t(n) = O(n)
- helper : tt(n) = O(n)
- LCAofBT : T(n) = t(n) + tt(n) = O(n)
*/
public class Solution {
    public TreeNode LCAofBT(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null)
            return null;
        if(!check(root, p) || !check(root, q))
            return null;
        return helper(root, p, q);
    }
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root==p || root==q)
            return root;
        
        TreeNode left = helper(root.left, p, q);
        if(left!=null && left!=p && left!=q) return left; // to reduce time
        
        TreeNode right = helper(root.right, p, q);
        
        if(left!=null && right!=null) return root;
        return left==null ? right : left;
    }
    public boolean cover(TreeNode root, TreeNode p) {
        if(root==null) return false;
        if(root==p) return true;
        return check(root.left, p) || check(root.right, p);
    }
}

// Solution 2.2
public class Solution {
	public TreeNode node;
	public boolean isAncestor;
	public Solution (TreeNode node, boolean isAnc) {
		this.node = node;
		this.isAncestor = isAnc;
	} 
	public TreeNode LCAofBT(TreeNode root, TreeNode p, TreeNode q) {
		Solution slv = helper(root, p, q);
		if(slv.isAncestor)
			return slv.node;
		return null;
	}
	public Solution helper (TreeNode root, TreeNode p, TreeNode q) {
		if(root==null) {
			return new Solution(null, false);
		}
		if(root==p && root==q) {
			return new Solution(root, true);
		}
		Solution slvLeft = helper(root.left, p, q);
		if(slvLeft.isAncestor) {
			return slvLeft;
		}
		Solution slvRight = helper(root.right, p, q);
		if(slvRight.isAncestor) {
			return slvRight;
		}
		if(slvLeft.node!=null && slvRight.node!=null) {
			return new Solution(root, true);
		} else if(root==p || root==q) {
			boolean isAncestor = slvLeft.node!=null || slvRight.node!=null;
			return new Solution(root, isAncestor);
		} else {
			return new Solution(slvLeft.node!=null ? slvLeft.node : slvRight.node, false);
		}
	}
}