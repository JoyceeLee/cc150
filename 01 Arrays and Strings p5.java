/*
 * 1.5 Implement a method to perform basic string compression using the counts of repeated characters. 
 * For example, the string aabcccccaaa would become a2blc5a3. 
 * If the "compressed" string would not become smaller than the original string, 
 * your method should return the original string.
 */
 
public class Solution {
    public String compress(String s) {
        if(s==null || s.length()<=1) return s;
        String newStr = "";
        char cur = s.charAt(0);
        char pre = cur;
        int count = 1;
        for(int i=1; i<s.length(); i++) {
            pre = charAt(i);
            if(cur!=pre) {
                newStr += cur;
                newStr += ('0'+count); //
                cur = pre;
                count = 0;
            }
            count++;
        }
        if(newString.length()>=s.length()) return s;
        return newString;
    }
}
