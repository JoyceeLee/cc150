/*
 * 2.4 Write code to partition a linked list around a value x, 
 * such that all nodes less than x come before all nodes greater than or equal to x
 */
 
public class Solution {
    public ListNode partition(ListNode head, x) {
        ListNode pre = null;
        ListNode post = null;
        while(head!=null) {
            ListNode tmp = head.next;
            if(head.val<x) {
                head.next = pre;
                pre = head;
            } else {
                head.next = post;
                post = head;
            }
            head = tmp;
        }
        if(pre==null) {
            return post;
        }
        ListNode run = pre;
        while(run.next!=null) {
            run = run.next;
        }
        run.next = post;
        return pre;
    }
}
