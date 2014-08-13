/*
 * 4.7 Design an algorithm and write code to find the first common ancestor of two 
 * nodes in a binary tree. Avoid storing additional nodes in a data structure.
 * NOTE: This is not necessarily a binary search tree.
 */


// Solution 1.1
/*
 * Time Complexity
 * For balance tree : O(n)
 *     - cover : t(n) = O(n)
 *     - helper : T(n) = t(n) + t(n/2) + T(n/2)
 *                T(n) = O(n)
 *     - LCAofBT : = T(n) 
 * For degenerate tree (worst case) : O(n^2)
 *     - cover : t(n) = O(n)
 *     - helper : T(n) = t(n) + t(n-1) + T(n-1)
 *                 T(n) = O(n^2)
 *     - LCAofBT : = T(n) 
 */
 * O(n) on a balanced tree -- 
 *  is called on 2n nodes in the first call
 * After that, the algorithm branches left or right, at which point covers will be called on 2n/2 nodes, then 2n/4, and soon.
 * This results in a runtime of O(n).
 * Well in the worst case, Time Complexity is O(n^2)
 */
public class Solution {
	public TreeNode LCAofBT(TreeNode root, TreeNode p, TreeNode q) {
		if(!cover(root, p)|| !cover(root, q)) return null;
		return helper(root, p, q);
	}
	public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null) return null;
		if(root==p || root==q) return root;
		boolean pOnLeft = cover(root.left, p);
		boolean qOnLeft = cover(root.left, q);
		if(pOnleft != qOnleft) return root;
		TreeNode childRoot = pOnLeft ? root.left : root.right;
		return helper(childRoot, p, q);
	}
	public boolean cover(TreeNode root, TreeNode p) {
		if(root==null) return false;
		if(root==p) return true;
		return cover(root.left, p) || cover(root.right, p);
	}
}

/* https://github.com/JoyceeLee/Binary-Tree/blob/master/Lowest%20Common%20Ancestor%20of%20a%20Binary%20Search%20Tree%20(BST).java
 * https://github.com/JoyceeLee/Binary-Tree/blob/master/Lowest%20Common%20Ancestor%20of%20a%20Binary%20Tree%20Part%20I.java
 * https://github.com/JoyceeLee/Binary-Tree/blob/master/Lowest%20Common%20Ancestor%20of%20a%20Binary%20Tree%20Part%20II.java
 */

// Solution 1.2
// A Top-Down Approach ( Worst case O(n^2) ):
/*
 * Time Complexity
 * For balance tree : O(n)
 *     - countMatch : t(n) = O(n)
 *     - LCAofBT : T(n) = t(n) + t(n/2) + T(n/2)
 *                 T(n) = O(n)
 * For degenerate tree (worst case) : O(n^2)
 *     - countMatch : t(n) = O(n)
 *     - LCAofBT : T(n) = t(n) + t(n-1) + T(n-1)
 *                 T(n) = O(n^2)
 */
public class Solution {
    public TreeNode LCAofBT(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null)
            return null;
        int totalMatch = countMatch(root, p, q);
        if(totalMatch!=2) return null;  
        
        if(root==p || root==q) return root;
        int leftMatch = countMatch(root.left, p, q);
        if(leftMatch==1) 
            return root;
        else if(leftMatch==2) 
            return LCAofBT(root.left, p, q);
        else
            return LCAofBT(root.right, p, q);
    }
    public int countMatch(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return 0;
        int matched = countMatch(root.left, p, q) + countMatch(root.right, p, q);
        if(root==p || root==q)
            matched += 1;
        return matched;
    }
}