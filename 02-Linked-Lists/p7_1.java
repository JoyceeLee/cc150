/*
 * 2.7  Implement a function to check if a linked list is a palindrome.
 */


// Space Complexity : O(n) 
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode prehead = new ListNode(-1);
        prehead.next = null;
        ListNode l1 = head;
        while(l1!=null) {
            ListNode tmp = new ListNode(l1.val);
            tmp.next = prehead.next;
            prehead.next = tmp;
            l1 = l1.next;
        }
        prehead = prehead.next;
        while(head!=null && prehead!=null) {
            if(head.val!=prehead.vl) {
                return false;
            }
            head = head.next;
            prehead = prehead.next;
        }
        if(head!=null || prehead!=null)
            return false;
        return true;
    }
}

// Space Complexity : O(1) 
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverse(head2);
        while(head2!=null && head!=null) {
            if(head2.val!=head.val) {
                return false;
            }
            head2 = head2.next;
            head = head.next;
        }
        if(head2!=null || (head.next!=null && head.next.next!=null))
            return false;
        return true;
    }
    public ListNode reverse(ListNode head) {
        ListNode prehead = new ListNode(-1);
        prehead.next=head;
        while(head.next!=null) head = head.next;
        while(prehead.next!=head) {
            ListNode tmp = prehead.next;
            prehead.next = prehead.next.next;
            tmp.next = head.next;
            head.next = tmp;
        }
        return prehead.next;
    }
}
