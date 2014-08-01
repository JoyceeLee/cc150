/*
 *3.1  Describe how you could use a single array to implement three stacks.
 */


class StackData {
    public int start;
    public int pointer;
    public int size = 0;
    public int capacity;
    public StackData(int _start, int _capacity) {
        start = _start;
        pointer = _start - 1;
        capacity = _capacity;
    }
    public boolean isWithinStack(int index, int total_size) {
        if(start<=index && index<start+capacity) {
            return true;
        } else if(start+capacity>total_size && index<(start+capacity)%total_size ) {
            return true;
        }
        return false;
    }
}
 
public class Solution{
    static int numberOfStack = 3;
    static int defaultSize = 4;
    static int totalSize = defaultSize * numberOfStack;
    static StackData[] stakcs = {new StackData(0, defaultSize), 
                                 new StackData(defaultSize, defaultSize), 
                                 new StackData(2*defaultSize, defaultSize)};
    static int[] buffer = new int[totalSize];
    
    public static int numberOfElements() {
        return stacks[0].size + stacks[1].size + stacks[2].size;
    }
    
    public static int nextElement(int index) {
        if(index+1==totalSize) return 0;
        return index+1;
    }
    
    public static int previousElement(int index) {
        if(index==0) return totalSize-1;
        return index-1;
    }
    
    // 占人家地儿
    public static void shift(int stackNum) {
        StackData stack = stacks[stackNum];
        if(stack.size>=stack.capacity) {
            int nextStack = (stackNum+1) % numberOfStack;
            shift(nextStack);
            stack.Cpacity++;
        }
        for(int i=(stack.start+stack.capacity-1)%totalSize;
        stack.isWithinStack(i, totalSize);
        i = previousElement(i)) {
            buffer[i] = buffer[previousElement(i)];
        }
        buffer[stack.start] = 0;
        stack.start = nextElement(stack.start);
        stack.pointer = nextElement(stack.pointer);
        stack.capacity--;
    }
    
    public static void expand(int stackNum, int value) throws Exception {
        shift( (stackNum+1) % numberOfStack );
        stacks[stackNum].capacity++;
    }
    
    public static void push(int stackNum, int value) throws Exeption {
        StackData stack = stacks[stackNum];
        if(stack.size>=stack.capacity) {
            if(numberOfElements()>=totalSize) {
                throw new Exception("0ut of space.");
            } else {
                expand(stackNum);
            }
        }
        stack.size++;
        stack.pointer = nextElement(stack.pointer);
        buffer[stack.pointer] = value;
    }
    
    public static int pop(int stackNum) throws Exception {
        StackData stack = stacks[stackNum];
        if(stack.size==0) {
            throw new Exception("Trying to pop an empty stack.");
        }
        int value = buffer[stack.pointer];
        buffer[stack.pointer]=0;
        stack.pointer = previousElement(stack.pointer);
        stack.size--;
        return value;
    }
    
    public static int peek(int stackNum) {
        StackData stack = stacks[stackNum];
        return buffer[stack.pointer];
    }
    
    public static boolean isEmpty(int stackNum) {
        StackData stack = stacks[stackNum];
        return stack.size==0;
    }
}
