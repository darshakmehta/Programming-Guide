/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;
        ListNode prev = slow;
        while (fast != null) {
            if (slow.val == fast.val) {
                if (slow == head) {
                    head = fast;
                    slow = head;
                    fast = slow.next;
                } else {
                    prev.next = fast;
                    slow = prev;
                }                
            } else {
                prev = slow;
                slow = fast;
                fast = fast.next;
            }
        }

        return head;
    }
}


/* Efficient Solution */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if(curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }
}