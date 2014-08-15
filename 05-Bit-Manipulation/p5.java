/*
 * 5.5 Write a function to determine the number of bits required to convert integer A to integer B.
 */

public class Solution {
	public int bitSwap(int a, int b) {
		int count = 0;
		for(c=a^b; c!=0; c>>=1) {
			count += c & 1;
		}
		return count;
	}
}