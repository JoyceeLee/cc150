/*
 * 5.7 An array A contains all the integers from 0 through n, except for one number which is missing.
 * In this problem, we cannot access an entire integer in A with a single operation.
 * The elements of A are represented in binary, and the only operation we can use 
 * to access them is "fetch the jth bit of A[i]"
 * which takes constant time.
 * Write code to find the missing integer.
 * The algorithm should in O(n) time
 */


public class Solution {
	public int findMissing(ArrayList<BitInteger> array) {
		return helper(array, 0);
	}
	public int helper(ArrayList<BitInteger> array, int column) {
		if(column >= BitInteger.size()) {
			return 0;
		}
		ArrayList<BitInteger> oneBits = new ArrayList<BitInteger>(array.size()/2);
		ArrayList<BitInteger> zeroBits = new ArrayList<BitInteger>(array.size()/2);
		for(BitInteger t:array) {
			if(t.fetch(column)==0) {
				zeroBits.add(t);
			} else {
				oneBits.add(t);
			}
		}
		if(zeroBits.size()<=oneBits.size()) {
			int v = helper(zeroBits, column+1);
			return (v<<1) | 0;
		} else {
			int v = helper(oneBits, column+1);
			return (v<<1) | 1;
		}
	}
}