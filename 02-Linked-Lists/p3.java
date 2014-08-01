/*
 * 2.3 Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
 * EXAMPLE
 * Input: the node c from the linked list a->b->c->d->e
 * Result: nothing is returned, but the new linked list looks like a->b->d->e
 * 只给出该list中要剪去的node，从链中剪去该node
 */
 
 
public class Solution {
    public void deleteNode(ListNode n) {
        if(n==null || n.next==null) // not in the middle
            return;
        n.val = n.next.val
        n.next = n.next.next;
        return;
    }
}
