/*
 * 1.3 Given two strings, write a method to decide if one is a permutation of the other.
 */

public class Solution {
    public boolean isPermutation(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] chars = new int[256];
        for(int i=0; i<s.length(); i++) {
            chars[s.charAt(i)]++;
        }
        for(int i=0; i<t.length(); j++) {
            chars[t.charAt(i)]--;
            if(chars[t.charAt(i)]<0)
                return false;
        }
        return true;
    }
}
