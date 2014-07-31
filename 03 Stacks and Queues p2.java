/*
 * 3.2 How would you design a stack which, in addition to push and pop, 
 * also has a function min which returns the minimum element? 
 * Push, pop and min should all operate in O(1) time.
 */
 
public class Solution extends Stack<Integer> {
    Stack<Integer> minSt;
    public Solution {
        minSt = new Stack<Integer>();
    }
    public void push(int v) {
        if(value<=min()) {
            minSt.push(v);
        }
        super.push(v);
    }
    public Integer pop() {
        int v = super.pop();
        if(v==min()) {
            minSt.pop();
        }
        return v;
    }
    public int min() {
        if(minSt.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return minSt.peek();
        }
    }
}
