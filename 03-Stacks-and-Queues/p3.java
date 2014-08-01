/*
 * 3.3 Imagine a (literal) stack of plates. If the stack gets too high, it might topple. 
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold. 
 * Implement a data structure SetOf Stacks that mimics this. 
 * SetOf Stacks should be composed of several stacks and should create a new stack once the previous one exceeds capacity. 
 * SetOfStacks.push() and SetOfStacks.pop() should be have identically to a single stack(that is,pop() should 
 * return the same values as it would if there were just a single stack).
 * FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 */
 
class Node {
    int val;
    Node above;
    Node below;
    public Node(int v) {
        val = v;
        above = null;
        below = null;
    }
}


class Stack {
    private int capacity;
    public Node top, bottom;
    public int size = 0;
    
    public Stack(int capacity) {
        this.capacity = capacity;
    }
    public boolean isFull() {
        return capacity==size;
    }
    public void join(Node above, Node below) {
        if(below != null) below.above = above;
        if(above != null) above.below = below;
    }
    public boolean push(int v) {
        if(size>=capacity) return false;
        Node newNode = new Node(v);
        if(size==0) bottom = newNode;
        join(newNode top);
        top = newNode;
        size++;
        return true;
    }
    public int pop() {
        Node t = top;
        top = top.below;
        if(top!=null) top.above = null;
        t.below = null;
        size--;
        return t.val;
    }
    public boolean isEmpty() {
        return size==0;
    }
    public int removeBottom() {
        Node b = bottom;
        bottom = bottom.above;
        if(bottom!=null) bottom.below = null;
        size--;
        return b.val;
    }
}


public class SetOfStacks {
    ArrayList<Stack> stacks = new ArrayList<Stack>();
    public int capacity;
    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }
    public Stack getLastStack() {
        if(stacks.size()==0) return null;
        return stacks.get(stacks.size()-1);
    }
    public void push(int v) {
        Stack last = getLastStack();
        if(last!=null && !last.isFull()) {
            last.push(v);
        } else {
            Stack stack = new Stack(capacity);
            stack.push(v);
            stacks.add(stack);
        }
    }
    public void pop() {
        Stack last = getLastStack();
        int v = last.pop();
        if(last.size==0) stacks.remove(stacks.size()-1);
        return v;
    }
    public boolean isEmpty() {
        Stack last = getLastStack();
        return last==null || last.isEmpty();
    }
    public int popAt(int index) {
        return leftShift(index, true);
    }
    public int leftShift(int index, boolean removeTop) {
        Stack stack = stack.get(index);
        int removedItem;
        if(removeTop) removedItem = stack.pop();
        else removedItem = stack.removeBottom();
        
        if(stack.isEmpty()) {
            stacks.remove(index);
        } else if(stacks.size()>index+1) {
            // If we pop an element from stack 1, 
            // we need to remove the bottom of stack 2 and push it onto stack 1.
            int v = leftShift(index+1, false);
            stack.push(v);
        }
        return removedItem;
    }
}
