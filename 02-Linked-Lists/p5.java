/*
 * 2.5 You have two numbers represented by a linked list, where each node contains a single digit. 
 * The digits are stored in reverse order, such that the Ts digit is at the head of the list. 
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input:(7-> 1 -> 6) + (5 -> 9 -> 2).Thatis,617 + 295.
 * Output: 2 -> 1 -> 9.That is, 912.
 * 
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem. EXAMPLE
 * Input:(6 -> 1 -> 7) + (2 -> 9 -> 5).Thatis,617 + 295.
 * Output: 9 -> 1 -> 2.That is, 912.
 */
 
 
public class Solution {
    public ListNode addList(ListNode a, ListNode b) {
        int carry = 0;
        ListNode prehead = new ListNode(-1);
        ListNode run = prehead;
        while(a!=null || b!=null || carray!=0) {
            int sum = carray;
            if(a!=null) {
                sum += a.val;
                a = a.next;
            }
            if(b!=null) {
                sum += b.val;
                b = b.next;
            }
            run.next = new ListNode(sum % 10);
            carray = sum /10;
        }
        return prehead.next;
    }
}
 

/*
 * Follow Up : what if the list are in normal order ?
 */
public class Solution {
    public ListNode addLists(ListNode l1, ListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);
        if(len2>len1) {
            padList(l1, len2-len1);
        } else if(len1>len2){
            padList(l2, len1-len2);
        }
        ListNode head = addLast(l1, l2);
        if(head.val>9) {
            ListNode newNode = new ListNode(head.val/10);
            head.val = head.val % 10;
            newNode.next = head;
            head = newNode;
        }
        return head;
    }
    public int length(ListNode l) {
        ListNode run = l;
        int count = 0;
        while(run!=null) {
            run = run.next;
            count++;
        }
        return count;
    }
    public void padList(ListNode head, int len) {
        for(int i=0; i<len; i++) {
            ListNode newNode = new ListNode(0);
            newNode.next = head;
            head = newNode;
        }
    }
    public ListNode addLast(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) return null;
        ListNode head = addLast(l1.next, l2.next);
        ListNode newhead = new ListNode(l1.val+l2.val);
        newhead.next = head;
        if(head!=null) {
            newhead.val += head.val/10;
            head.val= head.val % 10;
        }
        return newhead;
    }
}
