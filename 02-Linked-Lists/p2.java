/*
 * 2.2 Implement an algorithm to find the kth to last element of a singly linked list.
 */
 
public class Solution {
    public int findKth(ListNode head) {
        ListNode kth = head;
        ListNode end = head;
        int i=0;
        while(i<k) {
            end = end.next;
        }
        while(end!=null) {
            end = end.next;
            kth = kth.next;
        }
        return kth.val;
    }
}
