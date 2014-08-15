/*
 * 5.2 Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, 
 * print the binary representation. If the number cannot be represented accurately in binary 
 * with at most 32 characters, print "ERROR."
 */

public class Solution {
	public String printBinary(double num) {
		if(num>=1 || num<=0)
			return "ERROR";

		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while(num>0) {
			if(binary.length()>=32)
				return "ERROR";
			double num = num*2;
			if(num>=1) {
				binary.append("1");
				num -= 1;
			} else {
				binary.append("0");
			}
		}
		return binary.toString();
	}
}