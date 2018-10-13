/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution { // O(n) space
    
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        
        ListNode reverse = null;
        ListNode last = head;
        ListNode first = head;
        
        while(last != null) {
            ListNode newnode = new ListNode(last.val);
            if(reverse == null)
                reverse = newnode;
            else {
                newnode.next = reverse;
                reverse = newnode;
            }
            last = last.next;
        }
        
        ListNode second = reverse;
        while(true) {
            if(first == null)
                return true;
            if(first.val != second.val)
                return false;
            first = first.next;
            second = second.next;
        }
    }
}