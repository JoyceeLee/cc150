/*
 * 3.1  Describe how you could use a single array to implement three stacks.
 */
 
public class Solution {
    int stackSize = 100;
    int[] buffer = new int[3+stackSize];
    int[] stackPointer = {-1, -1, -1};
    
    public void push(int stackNum, int v) throws Exception{
        if(stackPointer[stackNum]+1>=stackSize) {
            throw new Exception("out of space");
        }
        stackPointer[stackNum]++;
        buffer[stackIdx(stackNum)] = v;
    }
    
    public int pop(int stackNum) throws Exception{
        if(stackPointer[stackNum]==-1) {
            throw new Exception("Try to pop from an empty stack");
        }
        int v = buffer[stackIdx(stackNum)];
        buffer[stackIdx(stackNum)] = 0;
        stackPointer[stackNum]--;
        return v;
    }
    
    public int peek(int stackNum) {
        int v = buffer(stackIdx(stackNum));
        return v;
    }
    
    public boolean isEmpty(int stackNum) {
        return stackPointer[stackNum]==-1;
    }
    
    public int stackIndx(int stackNum) {
        return stackSize * stackNum + stackPointer[stackNum];
    }
}
