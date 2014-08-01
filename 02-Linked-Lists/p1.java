/*
 * 2.1 Write code to remove duplicates from an unsorted linked list. 
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
 
public class Solution {
    public void deleteDups(ListNode head) {
        if(head==null) return;
        ListNode cur = head;
        while(cur!=null) {
            ListNode run = cur;
            while(run.next!=null) {
                if(run.next.val==cur.val) {
                    run.next=run.next.next;
                } else {
                    run = run.next;
                }
            }
            cur = cur.next;
        }
    }
}
