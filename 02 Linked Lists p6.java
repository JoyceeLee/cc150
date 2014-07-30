/*
 * 2.6 Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.
 * EXAMPLE
 * Input:A->B->C->D->E-> C[thesameCasearlier] 
 * Output:C
 */
 
public class Solution {
    public ListNode findNOde(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(true) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow) break;
        }
        slow = head;
        while(fast!=slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
