/* 1.1 Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data structures?
 */
 
public class uniqueChar {
    public boolean allUnique(String s) {
        if(s==null || s.length()==0) return true;
        boolean[] appear = new boolean[256];
        for(int i=0; i<s.length(); i++) {
            if(appear[s.charAt(i)]) return false;
            appear[s.charAt(i)] = true;
        }
        return true;
    }
}
