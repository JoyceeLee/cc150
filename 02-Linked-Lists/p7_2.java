/*
 * 2.7  Implement a function to check if a linked list is a palindrome.
 */
 
public class Solution {
    public boolean isPalindrome(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        Stack<Integer> st = new Stack<Integer>();
        while(fast!=null && fast.next!=null) {
            st.push(slow.val);
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast!=null) {
            slow = slow.next;
        }
        while(slow!=null) {
            if(slow.val != st.pop()) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
